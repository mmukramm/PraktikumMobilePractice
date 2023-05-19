package com.example.t5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t5.DataSource.PostData;
import com.example.t5.Models.PostModel;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class AddPostFragment extends Fragment {
    private ImageView addImagePostIv;
    private TextInputEditText addDescriptionEt;
    private Button postBtn;
    private Bitmap bitmap;
    private ActivityResultLauncher<Intent> mGetContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mGetContent = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Uri postImage = data.getData();
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), postImage);
                            addImagePostIv.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        return inflater.inflate(R.layout.fragment_add_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView();

        addImagePostIv.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            mGetContent.launch(i);
        });

        postBtn.setOnClickListener(v -> {
            if (bitmap == null) {
                Toast.makeText(getContext(), "Select an Image", Toast.LENGTH_SHORT).show();
                return;
            }

            String postDescription = addDescriptionEt.getText().toString();
            PostModel postModel = new PostModel(bitmap, postDescription);

            bitmap = null;
            addImagePostIv.setImageBitmap(null);
            addDescriptionEt.setText("");

            PostData.setPost(postModel);
            getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
            Toast.makeText(getContext(), "Post Success", Toast.LENGTH_SHORT).show();
        });
    }

    private void setView() {
        addDescriptionEt = getView().findViewById(R.id.addDescriptionEt);
        addImagePostIv = getView().findViewById(R.id.addImagePostIv);
        postBtn = getView().findViewById(R.id.postBtn);
    }

}