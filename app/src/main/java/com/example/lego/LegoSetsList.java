package com.example.lego;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lego.api.ApiService;
import com.example.lego.api.Retrofitclient;
import com.example.lego.api.model.LegoSet;
import com.example.lego.api.model.LegoSetResponse;
import com.example.lego.ui.adapter.LegoSetAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LegoSetsList extends Fragment {

    private RecyclerView recyclerView;
    private LegoSetAdapter adapter;
    private List<LegoSet> legoSetList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lego_sets_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerLegoSets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new LegoSetAdapter(getContext(), legoSetList);


        adapter.setOnLegoSetClickListener(legoSet -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("legoSet", legoSet);

            LegoSetDetails fragment = new LegoSetDetails();
            fragment.setArguments(bundle);

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView.setAdapter(adapter);

        loadLegoSets();

        return view;
    }

    private void loadLegoSets() {
        ApiService api = Retrofitclient.getInstance().create(ApiService.class);
        api.getSets("Star Wars", 1000)
                .enqueue(new Callback<LegoSetResponse>() {
                    @Override
                    public void onResponse(Call<LegoSetResponse> call, Response<LegoSetResponse> response) {
                        if(response.isSuccessful() && response.body() != null){
                            legoSetList.clear();
                            legoSetList.addAll(response.body().getResults());
                            if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                    }
                    @Override
                    public void onFailure(Call<LegoSetResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}