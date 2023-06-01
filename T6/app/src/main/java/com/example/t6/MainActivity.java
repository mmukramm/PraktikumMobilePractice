package com.example.t6;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.t6.DataSource.PostData;
import com.example.t6.Models.PostModel;
import com.example.t6.Models.UserModel;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ImageView homeIcon, addIcon, personIcon, searchIcon;
    private FragmentManager fm = getSupportFragmentManager();
    private TextView menuTitleTv;
    private final Deque<PostModel> postModels = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        setData();
        PostData.postModels = postModels;

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

    private void setData() {
        UserModel user1 = new UserModel("Haaland", "Erling Haaland", R.drawable.haaland);
        Uri uri1 = Uri.parse("android.resource://com.example.t6/drawable/haaland");
        postModels.add(new PostModel(user1, uri1, "Kembali bertapa setelah 4-0"));

        UserModel user2 = new UserModel("De Bruyne", "Kevin De Bruyne", R.drawable.debruyne);
        Uri uri2 = Uri.parse("android.resource://com.example.t6/drawable/debruyne");
        postModels.add(new PostModel(user2, uri2, "4? Wah.... 4"));

        UserModel user3 = new UserModel("Mbappe", "Kylian Mbappeh", R.drawable.mbappe);
        Uri uri3 = Uri.parse("android.resource://com.example.t6/drawable/mbappe");
        postModels.add(new PostModel(user3, uri3, "Aaaah, ketekku basaah"));

        UserModel user4 = new UserModel("Ronaldo", "Cristiano Ronaldo", R.drawable.ronaldo);
        Uri uri4 = Uri.parse("android.resource://com.example.t6/drawable/ronaldo");
        postModels.add(new PostModel(user4, uri4, "Satuu, duaa, tigaa, SUIUIIUIIUUUUUIIII"));

        UserModel user5 = new UserModel("Messi", "Lionel Messi", R.drawable.messi);
        Uri uri5 = Uri.parse("android.resource://com.example.t6/drawable/messi");
        postModels.add(new PostModel(user5, uri5, "Kabooor, mamaah aku takuuut"));
    }
}