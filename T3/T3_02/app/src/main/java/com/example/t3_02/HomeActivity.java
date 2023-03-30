package com.example.t3_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private ImageView profileImage;
    private TextView usernameText, scoreText;
    private Button playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernameText = findViewById(R.id.usernameText);
        profileImage = findViewById(R.id.profileImage);

        User user = getIntent().getParcelableExtra("User");
        usernameText.setText(user.getUsername());
        profileImage.setImageURI(user.getProfileImage());

        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });

    }
}