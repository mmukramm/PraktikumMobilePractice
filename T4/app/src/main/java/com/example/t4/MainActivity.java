package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView homeChatRv;
    private ArrayList<UserModel> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeChatRv = findViewById(R.id.homeChatRv);
        homeChatRv.setHasFixedSize(true);

        userList.addAll(UserData.getUser());

        homeChatRv.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        UserHomeAdapter userHomeAdapter = new UserHomeAdapter(userList);
        homeChatRv.setAdapter(userHomeAdapter);
    }
}