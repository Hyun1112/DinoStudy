package com.example.dinostudy.repository;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient{
    private final static String BASE_URL = "http://ec2-13-125-156-137.ap-northeast-2.compute.amazonaws.com:3002";
    private static Retrofit retrofit = null;

    private RetrofitClient() {
    }

    public static Retrofit getClient(Application application) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // 요청을 보낼 base url을 설정한다.
                    .addConverterFactory(GsonConverterFactory.create()) // JSON 파싱을 위한 GsonConverterFactory를 추가한다.
                    .build();
        }
        return retrofit;
    }
}