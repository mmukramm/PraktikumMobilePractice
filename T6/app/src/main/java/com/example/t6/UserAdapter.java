package com.example.t6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t6.Models.UserModel;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private ArrayList<UserModel> userModels;
    private Context context;

    public UserAdapter(ArrayList<UserModel> userModels, Context context) {
        this.userModels = userModels;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_content_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        UserModel user = userModels.get(position);
        holder.userProfile_iv.setImageDrawable(context.getDrawable(user.getProfileImage()));
        holder.username_tv.setText(user.getUsername());
        holder.fullname_tv.setText(user.getFullname());
        holder.userCardContainer_cv.setOnClickListener(v -> {
            Intent i = new Intent(context, ProfileActivity.class);
            i.putExtra("User", user);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        if (userModels == null) return 0;
        return userModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userProfile_iv;
        TextView username_tv, fullname_tv;
        CardView userCardContainer_cv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userProfile_iv = itemView.findViewById(R.id.userProfile_iv);
            username_tv = itemView.findViewById(R.id.username_tv);
            fullname_tv = itemView.findViewById(R.id.fullname_tv);
            userCardContainer_cv = itemView.findViewById(R.id.userCardContainer_cv);
        }
    }
}
