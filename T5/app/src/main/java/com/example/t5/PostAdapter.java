package com.example.t5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t5.Models.PostModel;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private final ArrayList<PostModel> posts;

    public PostAdapter(ArrayList<PostModel> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        PostModel post = posts.get(position);
        holder.contentImageIv.setImageBitmap(post.getImage());
        holder.contentDescTv.setText(post.getDescription());
        holder.headerLl.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), ProfileActivity.class);
            v.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView homeProfileIv, contentImageIv;
        TextView usernameTv, aliasnameTv, contentDescTv;
        LinearLayout headerLl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            homeProfileIv = itemView.findViewById(R.id.homeProfileIv);
            contentImageIv = itemView.findViewById(R.id.contentImageIv);
            headerLl = itemView.findViewById(R.id.headerLl);
            usernameTv = itemView.findViewById(R.id.usernameTv);
            aliasnameTv = itemView.findViewById(R.id.aliasnameTv);
            contentDescTv = itemView.findViewById(R.id.contentDescTv);
        }
    }
}
