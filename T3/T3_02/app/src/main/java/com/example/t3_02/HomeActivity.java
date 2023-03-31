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
    private Boolean played = false;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernameText = findViewById(R.id.usernameText);
        profileImage = findViewById(R.id.profileImage);
        playButton = findViewById(R.id.playButton);
        scoreText = findViewById(R.id.scoreText);

        String getBestScore = getIntent().getStringExtra("bestscore");
        System.out.println(getBestScore);

        if (getBestScore != null && Integer.valueOf(getBestScore) > Integer.valueOf(scoreText.getText().toString())){
            played = true;
            scoreText.setText(getBestScore);
        }

        user = getIntent().getParcelableExtra("User");
        usernameText.setText(user.getUsername());
        profileImage.setImageURI(user.getProfileImage());
        if (played){
            playButton.setText("Play Again!");
        }

        playButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("User", user);
            startActivity(i);
            finish();
        });

    }
}