package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ChatActivity extends AppCompatActivity {
    private LinearLayout chatHeader;
    private RecyclerView chatRecyclerView;
    private ImageView profileChatIv, backBtn;
    private TextView nameTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        profileChatIv = findViewById(R.id.profileChatIv);
        nameTv = findViewById(R.id.nameTv);
        backBtn = findViewById(R.id.backBtn);
        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        chatHeader = findViewById(R.id.chatHeader);

        String username = getIntent().getStringExtra("username");
        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        String status = getIntent().getStringExtra("status");
        String profilePictureUrl = getIntent().getStringExtra("profilePictureUrl");

        chatHeader.setOnClickListener(v -> {
            Intent i = new Intent(ChatActivity.this, ProfileActivity.class);
            i.putExtra("username", username);
            i.putExtra("phoneNumber", phoneNumber);
            i.putExtra("status", status);
            i.putExtra("profilePictureUrl", profilePictureUrl);
            startActivity(i);
        });

        ArrayList<ChatModel> chats = getIntent().getParcelableArrayListExtra("chats");
        Collections.sort(chats, Comparator.comparing(ChatModel::getTimestamp));
        for (int i = 0; i < chats.size(); i++) {
            System.out.println(chats.get(i).getMessage());
        }

        Glide.with(getApplicationContext())
                .load(profilePictureUrl)
                .apply(new RequestOptions().override(70, 70))
                .centerCrop()
                .into(profileChatIv);
        nameTv.setText(username);

        chatRecyclerView.setHasFixedSize(true);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() { return true; }
        });

        ChatAdapter chatAdapter = new ChatAdapter(chats);
        chatRecyclerView.setAdapter(chatAdapter);

        backBtn.setOnClickListener(v -> finish());
    }
}
