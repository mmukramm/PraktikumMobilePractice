package com.example.t3_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button submitBtn;
    private ImageView userProfileImg;
    EditText captionForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitBtn = findViewById(R.id.submitBtn);
        userProfileImg = findViewById(R.id.userProfileImg);

        submitBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, MakePostActivity.class));
        });

    }
}