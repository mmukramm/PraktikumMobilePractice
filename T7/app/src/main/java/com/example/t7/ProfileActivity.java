package com.example.t7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.t7.api.ApiConfig;
import com.example.t7.api.SingleUserDataResponse;
import com.example.t7.api.UserResponse;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    private ImageView avatar_iv;
    private TextView name_tv, email_tv;
    private ProgressBar progressBar_pb;
    private CardView cardViewContainer_cv;
    private LinearLayout reloadSection_ll;
    private ImageView reload_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        avatar_iv = findViewById(R.id.avatar_iv);
        name_tv = findViewById(R.id.name_tv);
        email_tv = findViewById(R.id.email_tv);
        cardViewContainer_cv = findViewById(R.id.cardViewContainer_cv);
        progressBar_pb = findViewById(R.id.progressBar_pb);
        reloadSection_ll = findViewById(R.id.reloadSection_ll);
        reload_iv = findViewById(R.id.reload_iv);

        cardViewContainer_cv.setVisibility(CardView.GONE);

        int id = getIntent().getIntExtra("id", 0);

        reloadSection_ll.setVisibility(LinearLayout.GONE);
        reload_iv.setOnClickListener(v -> {
            reloadSection_ll.setVisibility(LinearLayout.GONE);
            progressBar_pb.setVisibility(ProgressBar.VISIBLE);
            showData(id);
        });

        showData(id);
    }

    private void showData(int id) {
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(getMainLooper());

        executor.execute(() -> {
            //Background work here
            Call<SingleUserDataResponse> client = ApiConfig.getApiService().getUserById(String.valueOf(id));
            handler.post(() -> {
                //UI Thread work here
                client.enqueue(new Callback<SingleUserDataResponse>() {
                    @Override
                    public void onResponse(Call<SingleUserDataResponse> call, Response<SingleUserDataResponse>
                            response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                cardViewContainer_cv.setVisibility(CardView.VISIBLE);
                                progressBar_pb.setVisibility(ProgressBar.GONE);
                                UserResponse userResponse = response.body().getData();
                                Glide.with(ProfileActivity.this)
                                        .load(userResponse.getAvatarUrl())
                                        .centerCrop()
                                        .into(avatar_iv);
                                name_tv.setText(userResponse.getFirstName() + " " + userResponse.getLastName());
                                email_tv.setText(userResponse.getEmail());
                            }
                        } else {
                            Log.e("TAG", "onFailure: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<SingleUserDataResponse> call, Throwable t) {
                        Log.e("TAG", "onFailure: " + t.getMessage());
                        cardViewContainer_cv.setVisibility(CardView.GONE);
                        progressBar_pb.setVisibility(ProgressBar.GONE);
                        reloadSection_ll.setVisibility(LinearLayout.VISIBLE);
                    }
                });
            });
        });
    }
}