package com.example.t3_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DisplayScoreActivity extends AppCompatActivity {
    private TextView scoreTv, bestScoreTv;
    private Button backHomeButton;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);
        scoreTv = findViewById(R.id.scoreTv);
        bestScoreTv = findViewById(R.id.bestScoreTv);
        backHomeButton = findViewById(R.id.backHomeButton);

        user = getIntent().getParcelableExtra("User");
        System.out.println("Display : " + user.getUsername());

        String score = getIntent().getStringExtra("score");
        String bestScore = bestScoreTv.getText().toString();

        scoreTv.setText(score);

        if (Integer.valueOf(score) > Integer.valueOf(bestScore)){
            bestScoreTv.setText(score);
        }

        backHomeButton.setOnClickListener(v -> {
            Intent i = new Intent(this, HomeActivity.class);
            if (Integer.valueOf(score) > Integer.valueOf(bestScore)){
                i.putExtra("bestscore", score);
            }
            i.putExtra("User", user);
            startActivity(i);
            finish();
        });
    }
}