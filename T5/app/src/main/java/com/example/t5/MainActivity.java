package com.example.t5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ImageView homeIcon, addIcon, personIcon;
    private FragmentManager fm = getSupportFragmentManager();
    private TextView menuTitleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();

        HomeFragment homeFragment = new HomeFragment();
        AddPostFragment addFragment = new AddPostFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        Fragment fragment1 = fm.findFragmentByTag(HomeFragment.class.getSimpleName());
        Fragment fragment2 = fm.findFragmentByTag(AddPostFragment.class.getSimpleName());
        Fragment fragment3 = fm.findFragmentByTag(ProfileFragment.class.getSimpleName());

        if (!(fragment1 instanceof HomeFragment))
            fm.beginTransaction().add(R.id.fragmentContainer, new HomeFragment(), HomeFragment.class.getSimpleName())
                    .commit();

        homeIcon.setOnClickListener(v -> selectFragment(fragment1, homeFragment, "Inigaram"));
        addIcon.setOnClickListener(v -> selectFragment(fragment2, addFragment, "Add Post"));
        personIcon.setOnClickListener(v -> selectFragment(fragment3, profileFragment, "Profile"));
    }

    private void selectFragment(Fragment fr, Fragment newFragment, String title) {
        menuTitleTv.setText(title);
        if (!(fr instanceof HomeFragment))
            fm.beginTransaction().replace(R.id.fragmentContainer, newFragment, HomeFragment.class.getSimpleName())
                    .commit();
    }

    void setView() {
        homeIcon = findViewById(R.id.homeIcon);
        addIcon = findViewById(R.id.addIcon);
        personIcon = findViewById(R.id.personIcon);
        menuTitleTv = findViewById(R.id.menuTitleTv);
    }
}