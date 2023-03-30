package com.example.t3_02;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

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

public class RegisterActivity extends AppCompatActivity {
    private ImageView profileImage;
    private EditText usernameET;
    private Button submitButton;
    private Uri selectedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameET = findViewById(R.id.usernameET);

        profileImage = findViewById(R.id.profileImage);
        profileImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            mGetContent.launch(intent);
        });

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(v -> {
            String username = usernameET.getText().toString();
            User user = new User(username, selectedImage);
            Intent i = new Intent(this, HomeActivity.class).addFlags(FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("User", user);
            startActivity(i);
        });
    }

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    selectedImage = data.getData();
                    if (selectedImage != null) {
                        profileImage.setImageURI(selectedImage);
                    }
                }
            });
}