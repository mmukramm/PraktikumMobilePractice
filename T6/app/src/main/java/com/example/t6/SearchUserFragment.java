package com.example.t6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t6.DataSource.PostData;
import com.example.t6.Models.PostModel;
import com.example.t6.Models.UserModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchUserFragment extends Fragment {
    private ImageView clearIcon_iv;
    private TextInputEditText searchBar_et;
    private RecyclerView userContainer_rv;
    private ProgressBar progressBar_pb;
    private ArrayList<UserModel> userModels;
    private ArrayList<UserModel> filteredUserModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        clearIcon_iv = view.findViewById(R.id.clearIcon_iv);
        searchBar_et = view.findViewById(R.id.searchBar_et);
        userContainer_rv = view.findViewById(R.id.userContainer_rv);
        progressBar_pb = view.findViewById(R.id.progressBar_pb);

        clearIcon_iv.setVisibility(View.GONE);
        progressBar_pb.setVisibility(View.GONE);

        userContainer_rv.setHasFixedSize(true);
        userContainer_rv.setLayoutManager(new LinearLayoutManager(getContext()));

        userModels = new ArrayList<>(setUserModels());

        searchBar_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Unused Method
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearIcon_iv.setVisibility(View.VISIBLE);
                progressBar_pb.setVisibility(View.VISIBLE);
                userContainer_rv.setVisibility(View.GONE);

                String searchValue = searchBar_et.getText().toString();
                filteredUserModels = new ArrayList<>();

                if (searchValue.isEmpty()) {
                    clearIcon_iv.setVisibility(View.GONE);
                    progressBar_pb.setVisibility(View.GONE);
                    filteredUserModels = null;
                } else {
                    for (UserModel item : userModels) {
                        if (item.getUsername().toLowerCase().contains(searchValue.toLowerCase()) || item.getFullname().toLowerCase().contains(searchValue.toLowerCase()))
                            filteredUserModels.add(item);
                    }
                }

                Executor executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());
                executor.execute(() -> {
                    try {
                        Thread.sleep(500);
                        handler.post(() -> {
                            progressBar_pb.setVisibility(View.GONE);
                            userContainer_rv.setVisibility(View.VISIBLE);
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                UserAdapter userAdapter = new UserAdapter(filteredUserModels, getContext());
                userContainer_rv.setAdapter(userAdapter);

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        clearIcon_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText search_et = view.findViewById(R.id.searchBar_et);
                search_et.setText("");
            }
        });
    }

    private ArrayList<UserModel> setUserModels() {
        Deque<PostModel> postData = PostData.postModels;
        ArrayList<UserModel> userModelsDump = new ArrayList<>();
        for (PostModel item : postData) {
            if (!userModelsDump.contains(item.getUser())) userModelsDump.add(item.getUser());
        }
        return userModelsDump;
    }
}