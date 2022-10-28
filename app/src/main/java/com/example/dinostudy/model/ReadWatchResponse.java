package com.example.dinostudy.model;

import com.google.gson.annotations.SerializedName;

public class ReadWatchResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("subject")
    private String subject;

    @SerializedName("time")
    private String time;

    public int getCode() {
        return code;
    }

    public String getSubject() {
        return subject;
    }

    public String getTime() {
        return time;
    }
}
