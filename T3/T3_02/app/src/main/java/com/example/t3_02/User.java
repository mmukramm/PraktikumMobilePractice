package com.example.t3_02;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private String username;
    private int score;
    private Uri profileImage;

    public User(String username, int score, Uri profileImage) {
        this.username = username;
        this.score = score;
        this.profileImage = profileImage;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public Uri getProfileImage() { return profileImage; }

    public void setProfileImage(Uri profileImage) { this.profileImage = profileImage; }

    protected User(Parcel in) {
        username = in.readString();
        score = in.readInt();
        profileImage = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeInt(score);
        dest.writeParcelable(profileImage, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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

}
