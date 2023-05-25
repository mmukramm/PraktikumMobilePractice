package com.example.t7.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("data")
    private List<UserResponse> data;
    public List<UserResponse> getData() {
        return data;
    }
}
