package com.example.midpraktikummobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView itemRv;
    private Button orderBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemRv = findViewById(R.id.itemRv);
        itemRv.setHasFixedSize(true);
        itemRv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<MenuModel> menuModels = DataSource.getMenu();

        MenuAdapter menuAdapter = new MenuAdapter(menuModels);
        itemRv.setAdapter(menuAdapter);

        orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(v -> {
            Intent i = new Intent(this, DisplayOrderActivity.class);
            i.putParcelableArrayListExtra("menus", menuModels);
            startActivity(i);
        });

    }
}