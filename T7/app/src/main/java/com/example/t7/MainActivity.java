package com.example.t7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.t7.api.ApiConfig;
import com.example.t7.api.DataResponse;
import com.example.t7.api.UserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar_pb;
    private RecyclerView userContainer_rv;
    private LinearLayout reloadSection_ll;
    private ImageView reload_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userContainer_rv = findViewById(R.id.userContainer_rv);
        progressBar_pb = findViewById(R.id.progressBar_pb);
        reloadSection_ll = findViewById(R.id.reloadSection_ll);
        reload_iv = findViewById(R.id.reload_iv);

        reloadSection_ll.setVisibility(LinearLayout.GONE);

        reload_iv.setOnClickListener(v -> {
            reloadSection_ll.setVisibility(LinearLayout.GONE);
            progressBar_pb.setVisibility(ProgressBar.VISIBLE);
            showData();
        });

        showData();
    }

    private void showData() {
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(getMainLooper());
        executor.execute(() -> {
            //Background work here
            Call<DataResponse> client = ApiConfig.getApiService().getUser("12");
            handler.post(() -> {
                //UI Thread work here
                client.enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse>
                            response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                progressBar_pb.setVisibility(ProgressBar.GONE);
                                List<UserResponse> userResponse = response.body().getData();

                                ArrayList<UserResponse> userResponses = new ArrayList<>(userResponse);

                                for (int i = 0; i < userResponses.size(); i++) {
                                    System.out.println(userResponses.get(i).getFirstName());
                                }

                                userContainer_rv.setHasFixedSize(true);
                                userContainer_rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                                UserAdapter userAdapter = new UserAdapter(userResponses);
                                userContainer_rv.setAdapter(userAdapter);

                            }} else {
                            if (response.body() != null) {
                                Log.e("MainActivity", "onFailure: " + response.message());
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {
                        progressBar_pb.setVisibility(ProgressBar.GONE);
                        reloadSection_ll.setVisibility(LinearLayout.VISIBLE);

                        Log.e("MainActivity", "onFailure: " + t.getMessage());
                    }
                });

            });
        });
    }
}