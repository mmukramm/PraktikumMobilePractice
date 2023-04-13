package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView chatRecyclerView;
    private ImageView profileChatIv;
    private TextView nameTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        profileChatIv = findViewById(R.id.profileChatIv);
        nameTv = findViewById(R.id.nameTv);
        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        String username = getIntent().getStringExtra("username");
        String profilePictureUrl = getIntent().getStringExtra("profilePictureUrl");
        ArrayList<ChatModel> chats = getIntent().getParcelableExtra("chats");
        System.out.println(chats.get(0));

        Glide.with(getApplicationContext())
                .load(profilePictureUrl)
                .apply(new RequestOptions().override(70, 70))
                .into(profileChatIv);
        nameTv.setText(username);
        ChatAdapter chatAdapter = new ChatAdapter(chats);
        chatRecyclerView.setAdapter(chatAdapter);


    }
}