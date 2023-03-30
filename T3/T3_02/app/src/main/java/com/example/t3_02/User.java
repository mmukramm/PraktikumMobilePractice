package com.example.t3_02;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private String username;
    private Uri profileImage;

    public User(String username, Uri profileImage) {
        this.username = username;
        this.profileImage = profileImage;
    }

    protected User(Parcel in) {
        username = in.readString();
        profileImage = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setProfileImage(Uri profileImage) {
        this.profileImage = profileImage;
    }

    public Uri getProfileImage() {
        return profileImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeParcelable(profileImage, i);
    }
}
