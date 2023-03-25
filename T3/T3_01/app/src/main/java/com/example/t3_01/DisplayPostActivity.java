package com.example.t3_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayPostActivity extends AppCompatActivity {
    private ImageView userProfileImg, postImage;
    private TextView usernameTv, displayCaptionTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_post);
        postImage = findViewById(R.id.postImage);
        displayCaptionTv = findViewById(R.id.displayCaptionTv);
        userProfileImg = findViewById(R.id.userProfileImg);
        usernameTv = findViewById(R.id.usernameTv);
        userProfileImg.setImageURI((Uri) getIntent().getParcelableExtra("UserProfile"));
        usernameTv.setText(getIntent().getStringExtra("UserUsername"));
        postImage.setImageURI((Uri) getIntent().getParcelableExtra("PostImage"));
        displayCaptionTv.setText(getIntent().getStringExtra("Caption"));
    }
}