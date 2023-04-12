package com.example.t4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.android.material.internal.ParcelableSparseArray;

import java.util.ArrayList;

public class UserModel implements Parcelable {
    private int idUser;
    private String name, phoneNumber, status, profilePictureUrl;
    private ArrayList<ChatModel> chats;

    public UserModel(int idUser, String name, String phoneNumber, String status, String profilePictureUrl, ArrayList<ChatModel> chats) {
        this.idUser = idUser;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.profilePictureUrl = profilePictureUrl;
        this.chats = chats;
    }

    protected UserModel(Parcel in) {
        idUser = in.readInt();
        name = in.readString();
        phoneNumber = in.readString();
        status = in.readString();
        profilePictureUrl = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public ArrayList<ChatModel> getChats() {
        return chats;
    }

    public void setChats(ArrayList<ChatModel> chats) {
        this.chats = chats;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(idUser);
        parcel.writeString(name);
        parcel.writeString(phoneNumber);
        parcel.writeString(status);
        parcel.writeString(profilePictureUrl);
    }
}
