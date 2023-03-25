package com.example.t3_01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView userProfileImg;
    private TextInputEditText fullNameEt, usernameEt;
    private Uri selectedImage;
    private Boolean isImageSelected = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitBtn = findViewById(R.id.submitBtn);
        userProfileImg = findViewById(R.id.userProfileImg);
        fullNameEt = findViewById(R.id.fullNameEt);
        usernameEt = findViewById(R.id.usernameEt);
        userProfileImg.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            mGetContent.launch(intent);
        });

        submitBtn.setOnClickListener(v -> {
            if (isImageSelected == false) {
                Toast.makeText(this, "Choose profile first", Toast.LENGTH_SHORT).show();
                return;
            } else if (fullNameEt.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter full name", Toast.LENGTH_SHORT).show();
                return;
            } else if (usernameEt.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
                return;
            } else if (usernameEt.getText().toString().contains(" ")) {
                usernameEt.setError("Username cannot contain space");
                return;
            }
            Intent i = new Intent(getApplicationContext(), MakePostActivity.class);
            i.putExtra("UserUsername", usernameEt.getText().toString());
            i.putExtra("UserProfile", selectedImage);
            startActivity(i);
        });
    }

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    selectedImage = data.getData();
                    if (selectedImage != null) {
                        isImageSelected = true;
                        userProfileImg.setImageURI(selectedImage);
                    }
                }
            }
    );
}