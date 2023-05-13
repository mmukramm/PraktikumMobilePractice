package com.example.t5.Models;

import android.graphics.Bitmap;

public class PostModel {
    private Bitmap image;
    private String description;

    public PostModel(Bitmap image, String description) {
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
}
