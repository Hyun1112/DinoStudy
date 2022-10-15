package com.example.dinostudy.repository;

import com.example.dinostudy.model.CheckUserEmailResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceApi {

    @POST("/android/googleIdToken")
    Call<CheckUserEmailResponse> sendGoogleIdToken(@Body String userEmail);

}
