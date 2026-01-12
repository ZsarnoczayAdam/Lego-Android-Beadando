package com.example.lego.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lego.R;
import com.example.lego.api.model.LegoSet;

import java.util.List;

public class LegoSetAdapter extends RecyclerView.Adapter<LegoSetAdapter.LegoSetViewHolder> {

    private Context context;
    private List<LegoSet> legoSetList;


    public interface OnLegoSetClickListener {
        void onLegoSetClick(LegoSet legoSet);
    }

    private OnLegoSetClickListener listener;

    public void setOnLegoSetClickListener(OnLegoSetClickListener listener) {
        this.listener = listener;
    }

    public LegoSetAdapter(Context context, List<LegoSet> legoSetList) {
        this.context = context;
        this.legoSetList = legoSetList;
    }

    @NonNull
    @Override
    public LegoSetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_set, parent, false);
        return new LegoSetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LegoSetViewHolder holder, int position) {
        LegoSet legoSet = legoSetList.get(position);

        holder.name.setText(legoSet.getName());
        holder.year.setText(String.valueOf(legoSet.getYear()));
        holder.parts.setText(legoSet.getNumParts() + " db elem");

        Glide.with(context)
                .load(legoSet.getSetImgUrl())

                .into(holder.poster);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onLegoSetClick(legoSet);
            }
        });
    }

    @Override
    public int getItemCount() {
        return legoSetList.size();
    }


    public static class LegoSetViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView name;
        TextView year;
        TextView parts;

        public LegoSetViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.legoImage);
            name = itemView.findViewById(R.id.legoName);
            year = itemView.findViewById(R.id.legoYear);
            parts = itemView.findViewById(R.id.legoParts);
        }
    }
}