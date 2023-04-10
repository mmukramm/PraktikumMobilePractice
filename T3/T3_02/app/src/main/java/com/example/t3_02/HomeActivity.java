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
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernameText = findViewById(R.id.usernameText);
        profileImage = findViewById(R.id.profileImage);
        playButton = findViewById(R.id.playButton);
        scoreText = findViewById(R.id.scoreText);
        user = getIntent().getParcelableExtra("User");

        String getBestScore = getIntent().getStringExtra("bestscore");
        if (getBestScore != null){
            int bestScore = Integer.parseInt(getBestScore);
            playButton.setText("Play Again!");
            if (bestScore > user.getScore()){
                user.setScore(bestScore);
            }
            scoreText.setText(String.valueOf(user.getScore()));
        }

        usernameText.setText(user.getUsername());
        profileImage.setImageURI(user.getProfileImage());

        playButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("User", user);
            startActivity(i);
            finish();
        });
    }
}