package com.example.t4;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.Arrays;

public class UserHomeAdapter extends RecyclerView.Adapter<UserHomeAdapter.ViewHolder>{
    private ArrayList<UserModel> users;
    private UserModel myAccount;

    public UserHomeAdapter(ArrayList<UserModel> users, UserModel myAccount) {
        this.users = users;
        this.myAccount = myAccount;
    }

    @NonNull
    @Override
    public UserHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_chat_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHomeAdapter.ViewHolder holder, int position) {
        UserModel user = users.get(position);

        ArrayList<ChatModel> chats = users.get(holder.getAdapterPosition()).getChats();
        for (int i = 0; i < myAccount.getChats().size(); i++) {
            if ( users.get(holder.getAdapterPosition()).getIdUser() == myAccount.getChats().get(i).getReceiver() ) {
                chats.add(myAccount.getChats().get(i));
            }
        }

        holder.usernamePreviewTv.setText(user.getName());
        holder.chatPreviewTv.setText(chats.get(chats.size() - 1).getMessage());
        holder.timeTv.setText(user.getChats().get(user.getChats().size() - 1).getTimestamp());
        Glide.with(holder.itemView.getContext())
                .load(user.getProfilePictureUrl())
                .apply(new RequestOptions().override(100, 100))
                .centerCrop()
                .into(holder.profileIv);

        holder.profileIv.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), ProfilePictureActivity.class);
            intent.putExtra("username", user.getName());
            intent.putExtra("profilePictureUrl", user.getProfilePictureUrl());
            holder.itemView.getContext().startActivity(intent);
        });

        holder.itemView.setOnClickListener(view -> {
            String username = users.get(holder.getAdapterPosition()).getName();
            String profilePictureUrl = users.get(holder.getAdapterPosition()).getProfilePictureUrl();
            String phoneNumber = users.get(holder.getAdapterPosition()).getPhoneNumber();
            String status = users.get(holder.getAdapterPosition()).getStatus();

            Intent intent = new Intent(holder.itemView.getContext(), ChatActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("phoneNumber", phoneNumber);
            intent.putExtra("status", status);
            intent.putExtra("profilePictureUrl", profilePictureUrl);
            intent.putParcelableArrayListExtra("chats", chats);
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
