package com.example.t4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ChatModel implements Parcelable{
    private int receiver;
    private String message;
    private String timestamp;

    public ChatModel(int receiver, String message, String timestamp) {
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
    }


    protected ChatModel(Parcel in) {
        receiver = in.readInt();
        message = in.readString();
        timestamp = in.readString();
    }

    public static final Creator<ChatModel> CREATOR = new Creator<ChatModel>() {
        @Override
        public ChatModel createFromParcel(Parcel in) {
            return new ChatModel(in);
        }

        @Override
        public ChatModel[] newArray(int size) {
            return new ChatModel[size];
        }
    };

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(receiver);
        parcel.writeString(message);
        parcel.writeString(timestamp);
    }
}
