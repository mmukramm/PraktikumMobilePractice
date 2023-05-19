package com.example.t5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t5.DataSource.PostData;
import com.example.t5.Models.PostModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView homeContentRv;
    private TextView noPostTv;
    private ArrayList<PostModel> posts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setView();

        posts = PostData.getPosts();
        homeContentRv.setVisibility(View.GONE);
        if (posts.size() != 0){
            noPostTv.setVisibility(View.GONE);

            homeContentRv.setVisibility(View.VISIBLE);
            homeContentRv.setHasFixedSize(true);
            homeContentRv.setLayoutManager(new LinearLayoutManager(getContext()));

            PostAdapter postAdapter = new PostAdapter(posts);
            homeContentRv.setAdapter(postAdapter);
        }

    }

    void setView(){
        homeContentRv = getView().findViewById(R.id.homeContentRv);
        noPostTv = getView().findViewById(R.id.noPostTv);
        posts = new ArrayList<>();
    }
}