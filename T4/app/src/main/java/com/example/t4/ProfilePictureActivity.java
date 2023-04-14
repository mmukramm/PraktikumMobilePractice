package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfilePictureActivity extends AppCompatActivity {
    private ImageView backBtn, profileIv;
    private TextView usernamePreviewTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_picture);

        backBtn = findViewById(R.id.backBtn);
        usernamePreviewTv = findViewById(R.id.usernamePreviewTv);
        profileIv = findViewById(R.id.profileIv);

        String username = getIntent().getStringExtra("username");
        String profilePictureUrl = getIntent().getStringExtra("profilePictureUrl");

        Glide.with(getApplicationContext())
                .load(profilePictureUrl)
                .into(profileIv);

        usernamePreviewTv.setText(username);
        backBtn.setOnClickListener(v -> finish());
    }
}