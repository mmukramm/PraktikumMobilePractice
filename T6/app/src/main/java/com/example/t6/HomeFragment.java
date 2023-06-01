package com.example.t6;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t6.DataSource.PostData;
import com.example.t6.Models.PostModel;

import java.util.ArrayList;
import java.util.Deque;

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

        Bundle bundle = getArguments();

        if (bundle!=null){
            PostModel postModel = bundle.getParcelable("postModel");
            PostData.postModels.push(postModel);
        }

        Deque<PostModel> postData = PostData.postModels;
        posts = new ArrayList<>(postData);

        noPostTv.setVisibility(View.GONE);

        homeContentRv.setHasFixedSize(true);
        homeContentRv.setLayoutManager(new LinearLayoutManager(getContext()));

        PostAdapter postAdapter = new PostAdapter(posts, getContext());
        homeContentRv.setAdapter(postAdapter);

    }

    void setView() {
        homeContentRv = getView().findViewById(R.id.homeContentRv);
        noPostTv = getView().findViewById(R.id.noPostTv);
        posts = new ArrayList<>();
    }
}