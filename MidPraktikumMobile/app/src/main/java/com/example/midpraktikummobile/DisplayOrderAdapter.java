package com.example.midpraktikummobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayOrderAdapter extends RecyclerView.Adapter<DisplayOrderAdapter.ViewHolder> {
    private ArrayList<MenuModel> menus;

    public DisplayOrderAdapter(ArrayList<MenuModel> menus) {
        this.menus = menus;
    }

    @NonNull
    @Override
    public DisplayOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_order_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayOrderAdapter.ViewHolder holder, int position) {
        MenuModel menu = menus.get(position);
        holder.menuNameTv.setText(menu.getMenuName());
        holder.menuPriceTv.setText(menu.getMenuPrice());
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView menuNameTv, menuPriceTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuNameTv = itemView.findViewById(R.id.menuNameTv);
            menuPriceTv = itemView.findViewById(R.id.menuPriceTv);
        }
    }
}
