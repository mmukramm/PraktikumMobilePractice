package com.example.t7;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.t7.api.UserResponse;

import java.util.ArrayList;

import kotlinx.coroutines.channels.ProduceKt;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<UserResponse> users;

    public UserAdapter (ArrayList<UserResponse> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        UserResponse user = users.get(position);
        holder.name_tv.setText(user.getFirstName()+ " " + user.getLastName());
        holder.email_tv.setText(user.getEmail());
        Glide.with(holder.itemView.getContext()).load(user.getAvatarUrl()).centerCrop().into(holder.avatar_iv);
        holder.itemCardView_cv.setOnClickListener(v -> {
            Intent i = new Intent(holder.itemView.getContext(), ProfileActivity.class);
            i.putExtra("id", user.getId());
            holder.itemView.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar_iv;
        TextView name_tv, email_tv;
        CardView itemCardView_cv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar_iv = itemView.findViewById(R.id.avatar_iv);
            name_tv = itemView.findViewById(R.id.name_tv);
            email_tv = itemView.findViewById(R.id.email_tv);
            itemCardView_cv = itemView.findViewById(R.id.itemCardView_cv);
        }
    }
}
