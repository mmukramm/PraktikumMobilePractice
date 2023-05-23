package com.example.t6.Models;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PostModel implements Parcelable {
    private UserModel user;
    private Bitmap image;
    private String description;

    public PostModel(UserModel user, Bitmap image, String description) {
        this.user = user;
        this.image = image;
        this.description = description;
    }

    protected PostModel(Parcel in) {
        image = in.readParcelable(Bitmap.class.getClassLoader());
        description = in.readString();
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(image, flags);
        dest.writeString(description);
    }
}
