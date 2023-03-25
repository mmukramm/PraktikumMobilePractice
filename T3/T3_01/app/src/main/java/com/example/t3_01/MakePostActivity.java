package com.example.t3_01;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.Toast;

public class MakePostActivity extends AppCompatActivity {
    Button uploadBtn;
    EditText captionForm;
    ImageView imageToUpload;
    Boolean isImageSelected = false;
    Uri postImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post);
        uploadBtn = findViewById(R.id.uploadBtn);
        captionForm = findViewById(R.id.captionForm);
        imageToUpload = findViewById(R.id.imageToUpload);
        imageToUpload.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            mGetContent.launch(intent);
        });
        uploadBtn.setOnClickListener(v -> {
            if (isImageSelected == false) {
                Toast.makeText(this, "At least you upload an image", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent i = new Intent(getApplicationContext(), DisplayPostActivity.class);
            i.putExtra("PostImage", postImage);
            i.putExtra("Caption", captionForm.getText().toString());
            i.putExtra("UserUsername", getIntent().getStringExtra("UserUsername"));
            i.putExtra("UserProfile", (Uri) getIntent().getParcelableExtra("UserProfile"));
            startActivity(i);
        });
    }

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    postImage = data.getData();
                    if (postImage != null) {
                        isImageSelected = true;
                        imageToUpload.setImageURI(postImage);
                    }
                }
            }
    );
}