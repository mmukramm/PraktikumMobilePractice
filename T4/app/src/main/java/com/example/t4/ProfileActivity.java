package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ProfileActivity extends AppCompatActivity {
    private TextView usernameTv, phoneNumberTv, statusTv;
    private ImageView profilePictureIv, backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameTv = findViewById(R.id.usernameTv);
        phoneNumberTv = findViewById(R.id.phoneNumberTv);
        statusTv = findViewById(R.id.statusTv);
        backBtn = findViewById(R.id.backBtn);
        profilePictureIv = findViewById(R.id.profilePictureIv);

        String username = getIntent().getStringExtra("username");
        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        String status = getIntent().getStringExtra("status");
        String profilePictureUrl = getIntent().getStringExtra("profilePictureUrl");

        usernameTv.setText(username);
        phoneNumberTv.setText(phoneNumber);
        statusTv.setText(status);
        Glide.with(getApplicationContext())
                .load(profilePictureUrl)
                .centerCrop()
                .into(profilePictureIv);

        backBtn.setOnClickListener(v -> finish());

        profilePictureIv.setOnClickListener(v -> {
            Intent i = new Intent(ProfileActivity.this, ProfilePictureActivity.class);
            i.putExtra("username", username);
            i.putExtra("profilePictureUrl", profilePictureUrl);
            startActivity(i);
        });
    }
}