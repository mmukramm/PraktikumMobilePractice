package com.example.t6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView homeIcon, addIcon, personIcon, searchIcon;
    private FragmentManager fm = getSupportFragmentManager();
    private TextView menuTitleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();

        HomeFragment homeFragment = new HomeFragment();
        SearchUserFragment searchUserFragment = new SearchUserFragment();
        AddPostFragment addFragment = new AddPostFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        Fragment fragment1 = fm.findFragmentByTag(HomeFragment.class.getSimpleName());
        Fragment fragment2 = fm.findFragmentByTag(SearchUserFragment.class.getSimpleName());
        Fragment fragment3 = fm.findFragmentByTag(AddPostFragment.class.getSimpleName());
        Fragment fragment4 = fm.findFragmentByTag(ProfileFragment.class.getSimpleName());

        if (!(fragment1 instanceof HomeFragment))
            fm.beginTransaction().add(R.id.fragmentContainer, new HomeFragment(), HomeFragment.class.getSimpleName())
                    .commit();

        homeIcon.setOnClickListener(v -> selectFragment(fragment1, homeFragment, "Inigaram"));
        searchIcon.setOnClickListener(v -> selectFragment(fragment2, searchUserFragment, "Search User"));
        addIcon.setOnClickListener(v -> selectFragment(fragment3, addFragment, "Add Post"));
        personIcon.setOnClickListener(v -> selectFragment(fragment4, profileFragment, "Profile"));
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
        searchIcon = findViewById(R.id.searchIcon);
        menuTitleTv = findViewById(R.id.menuTitleTv);
    }
}