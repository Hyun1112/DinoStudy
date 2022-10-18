package com.example.dinostudy.repository;

import com.example.dinostudy.model.CheckUserEmailRequest;
import com.example.dinostudy.model.CheckUserEmailResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {
    // 통신 코드
    @POST("/user/checkEmail")
    Call<CheckUserEmailResponse> checkUserEmail (@Body CheckUserEmailRequest userEmail);

}
