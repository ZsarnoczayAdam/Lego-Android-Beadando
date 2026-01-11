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

import com.example.lego.ui.adapter.MenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerMenu);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // 🔹 Menüelemek listája
        List<String> menuItems = new ArrayList<>();
        menuItems.add("Szettek");
        menuItems.add("Alkatrészek");

        // 🔹 Adapter létrehozása
        MenuAdapter menuAdapter = new MenuAdapter(menuItems);

        // 🔹 Kattintás a menüpontokra
        menuAdapter.setOnMenuItemClickListener(item -> {
            if(item.equals("Szettek")) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new LegoSetsList())
                        .addToBackStack(null)
                        .commit();
            }
        });

        recyclerView.setAdapter(menuAdapter);

        return view;
    }
}