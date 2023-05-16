package com.example.t5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ImageView homeIcon, addIcon, personIcon;
    private View.OnClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fragmentContainer, new HomeFragment()).commit();
        listener = v -> { setClick(v); };
        setView();
    }

    private void setClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        if (v == homeIcon){
            Log.d("Icon Debug", "Home Page");
            fm.beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
        }
        if (v == addIcon){
            Log.d("Icon Debug", "Add Page");
            fm.beginTransaction().replace(R.id.fragmentContainer, new AddPostFragment()).commit();
        }
        if (v == personIcon){
            Log.d("Icon Debug", "Profile Page");
            fm.beginTransaction().replace(R.id.fragmentContainer, new ProfileFragment()).commit();
        }
    }

    void setView(){
        homeIcon = findViewById(R.id.homeIcon);
        addIcon = findViewById(R.id.addIcon);
        personIcon = findViewById(R.id.personIcon);
        homeIcon.setOnClickListener(listener);
        addIcon.setOnClickListener(listener);
        personIcon.setOnClickListener(listener);
    }
}