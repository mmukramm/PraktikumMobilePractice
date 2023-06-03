package com.example.t8;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t8.Models.ItemModel;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private ArrayList<ItemModel> itemModels;
    private ActivityResultLauncher<Intent> resultLauncher;

    public ItemAdapter(ArrayList<ItemModel> itemModels, ActivityResultLauncher<Intent> resultLauncher) {
        this.itemModels = itemModels;
        this.resultLauncher = resultLauncher;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        ItemModel itemModel = itemModels.get(position);
        holder.itemTitle_tv.setText(itemModel.getName());
        holder.createdDate_tv.setText(itemModel.getCreatedDate());
        holder.timeDate_tv.setText(itemModel.getCreatedTime());
        holder.description_tv.setText(itemModel.getDescription());
        holder.item_cv.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DataDetailActivity.class);
            intent.putExtra(DataDetailActivity.EXTRA_ITEM, itemModel);
            resultLauncher.launch(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTitle_tv, createdDate_tv, timeDate_tv, description_tv;
        CardView item_cv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle_tv = itemView.findViewById(R.id.itemTitle_tv);
            createdDate_tv = itemView.findViewById(R.id.createdDate_tv);
            timeDate_tv = itemView.findViewById(R.id.timeDate_tv);
            description_tv = itemView.findViewById(R.id.itemDescription_tv);
            item_cv = itemView.findViewById(R.id.item_cv);
        }
    }
}
