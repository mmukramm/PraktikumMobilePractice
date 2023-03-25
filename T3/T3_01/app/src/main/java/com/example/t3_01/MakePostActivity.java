package com.example.t3_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;

public class MakePostActivity extends AppCompatActivity {
    Button uploadBtn;
    EditText captionForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post);
        uploadBtn = findViewById(R.id.uploadBtn);
        captionForm = findViewById(R.id.captionForm);
        uploadBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, DisplayPostActivity.class));
        });
    }
}