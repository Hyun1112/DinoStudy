package com.example.dinostudy.model;

import com.google.gson.annotations.SerializedName;

public class CheckUserEmailRequest {
    @SerializedName("userEmail")
    private String userEmail;

    public CheckUserEmailRequest (String userEmail) {
        this.userEmail = userEmail;
    }
}
