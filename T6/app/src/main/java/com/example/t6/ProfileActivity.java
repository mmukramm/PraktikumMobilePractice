package com.example.t6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.t6.Models.UserModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {
    private ImageView profileImage_iv;
    private TextView username_tv, fullName_tv;
    private LinearLayout profileContainer_ll;
    private ProgressBar profileProgress_pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage_iv = findViewById(R.id.profileImage_iv);
        username_tv = findViewById(R.id.username_tv);
        fullName_tv = findViewById(R.id.fullName_tv);
        profileContainer_ll = findViewById(R.id.profileContainer_ll);
        profileProgress_pb = findViewById(R.id.profileProgress_pb);

        profileContainer_ll.setVisibility(LinearLayout.GONE);

        UserModel user = getIntent().getParcelableExtra("User");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            try {
                Thread.sleep(1000);
                handler.post(() -> {
                    profileContainer_ll.setVisibility(LinearLayout.VISIBLE);
                    profileProgress_pb.setVisibility(ProgressBar.GONE);
                    profileImage_iv.setImageDrawable(getDrawable(user.getProfileImage()));
                    username_tv.setText(user.getUsername());
                    fullName_tv.setText(user.getFullname());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }
}