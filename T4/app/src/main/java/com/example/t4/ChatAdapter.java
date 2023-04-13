package com.example.t4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private ArrayList<ChatModel> chatModels;

    public ChatAdapter (ArrayList<ChatModel> chatModels){
        this.chatModels = chatModels;
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_chat_balloon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        ChatModel chatModel = chatModels.get(position);
        holder.chatTv.setText(chatModel.getMessage());
        holder.timeTv.setText(chatModel.getTimestamp());
    }

    @Override
    public int getItemCount() { return chatModels.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView chatTv, timeTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chatTv = itemView.findViewById(R.id.chatTv);
            timeTv = itemView.findViewById(R.id.timeTv);
        }
    }
}
