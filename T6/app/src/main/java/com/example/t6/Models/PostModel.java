package com.example.t6.Models;

import android.graphics.Bitmap;

public class PostModel {
    private UserModel user;
    private Bitmap image;
    private String description;

    public PostModel(UserModel user, Bitmap image, String description) {
        this.user = user;
        this.image = image;
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
