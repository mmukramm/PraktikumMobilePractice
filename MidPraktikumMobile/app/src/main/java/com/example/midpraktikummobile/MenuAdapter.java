package com.example.midpraktikummobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private ArrayList<MenuModel> menuList;

    public MenuAdapter(ArrayList<MenuModel> menuList) {
        this.menuList = menuList;
    }


    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        MenuModel menu = menuList.get(position);

        holder.menuNameTv.setText(menu.getMenuName());
        holder.menuDescTv.setText(menu.getMenuDesc());
        holder.menuPriceTv.setText(menu.getMenuPrice());

//        if (menu.getMenuType().equals("makanan")) {
//            holder.menuImageIv.setImageDrawable();
//        }
        holder.addBtn.setOnClickListener(v -> {
            menu.setSelected(true);
            Toast.makeText(v.getContext(), menu.getMenuName() + " added to your orders", Toast.LENGTH_SHORT).show();
            holder.addBtn.setEnabled(false);
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView menuNameTv, menuDescTv, menuPriceTv;
        ImageView menuImageIv;
        Button addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuNameTv = itemView.findViewById(R.id.menuNameTv);
            menuDescTv = itemView.findViewById(R.id.menuDescTv);
            menuPriceTv = itemView.findViewById(R.id.menuPriceTv);
            menuImageIv = itemView.findViewById(R.id.menuImageIv);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
