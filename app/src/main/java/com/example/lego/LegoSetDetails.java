package com.example.lego;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.lego.api.model.LegoSet;

public class LegoSetDetails extends Fragment {

    private LegoSet legoSet;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            legoSet = (LegoSet) getArguments().getSerializable("legoSet");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lego_set_details, container, false);

        TextView name = view.findViewById(R.id.legoName);
        TextView year = view.findViewById(R.id.legoYear);
        TextView parts = view.findViewById(R.id.legoParts);
        ImageView poster = view.findViewById(R.id.legoImage);

        if(legoSet != null){
            name.setText(legoSet.getName());
            year.setText(String.valueOf(legoSet.getYear()));
            parts.setText(legoSet.getNumParts() + " db elem");

            Glide.with(requireContext())
                    .load(legoSet.getSetImgUrl())
                    .into(poster);
        }

        return view;
    }
}