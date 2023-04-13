package com.example.t4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ChatModel implements Serializable {
    private int receiver;
    private String message;
    private String timestamp;

    public ChatModel(int receiver, String message, String timestamp) {
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
    }


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
}
