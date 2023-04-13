package com.example.t4;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Arrays;

public class UserHomeAdapter extends RecyclerView.Adapter<UserHomeAdapter.ViewHolder>{
    private ArrayList<UserModel> users;

    public UserHomeAdapter(ArrayList<UserModel> users) { this.users = users; }

    @NonNull
    @Override
    public UserHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_chat_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHomeAdapter.ViewHolder holder, int position) {
        UserModel user = users.get(position);
        holder.usernamePreviewTv.setText(user.getName());
        holder.chatPreviewTv.setText(user.getChats().get(user.getChats().size() - 1).getMessage());
        holder.timeTv.setText(user.getChats().get(user.getChats().size() - 1).getTimestamp());
        Glide.with(holder.itemView.getContext())
                .load(user.getProfilePictureUrl())
                .apply(new RequestOptions().override(70, 70))
                .into(holder.profileIv);
        holder.itemView.setOnClickListener(view -> {
            String username = users.get(holder.getAdapterPosition()).getName();
            String profilePictureUrl = users.get(holder.getAdapterPosition()).getProfilePictureUrl();
            ArrayList<ChatModel> chats = users.get(holder.getAdapterPosition()).getChats();
            Intent intent = new Intent(holder.itemView.getContext(), ChatActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("profilePictureUrl", profilePictureUrl);
            intent.putExtra("chats", chats);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profileIv;
        TextView usernamePreviewTv, chatPreviewTv, timeTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileIv = itemView.findViewById(R.id.profileIv);
            usernamePreviewTv = itemView.findViewById(R.id.usernamePreviewTv);
            chatPreviewTv = itemView.findViewById(R.id.chatPreviewTv);
            timeTv = itemView.findViewById(R.id.timeTv);
        }
    }
}
