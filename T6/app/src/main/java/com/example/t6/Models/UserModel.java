package com.example.t6.Models;

import android.graphics.Bitmap;

public class UserModel {
    private String username;
    private int profileImage;

    public UserModel(String username, int profileImage) {
        this.username = username;
        this.profileImage = profileImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }
}
