package com.example.midpraktikummobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;

import java.util.ArrayList;

public class DisplayOrderActivity extends AppCompatActivity {
    private ArrayList<MenuModel> menuModels;
    private RecyclerView displayOrderRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order);
        displayOrderRv = findViewById(R.id.displayOrderRv);
        displayOrderRv.setHasFixedSize(true);
        displayOrderRv.setLayoutManager(new LinearLayoutManager(this));

        menuModels = getIntent().getParcelableArrayListExtra("menus");

        ArrayList<MenuModel> selectedMenu = new ArrayList<>();

        for (int i = 0; i < menuModels.size()-1; i++) {
            if (menuModels.get(i).isSelected()){
                selectedMenu.add(menuModels.get(i));
                System.out.println(selectedMenu.get(i).getMenuName());
            }
        }

        DisplayOrderAdapter displayOrderAdapter = new DisplayOrderAdapter(selectedMenu);
        displayOrderRv.setAdapter(displayOrderAdapter);
    }
}