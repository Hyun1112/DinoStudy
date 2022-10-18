package com.example.dinostudy.viewModel;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dinostudy.model.CheckUserEmailRequest;
import com.example.dinostudy.model.CheckUserEmailResponse;
import com.example.dinostudy.repository.RetrofitClient;
import com.example.dinostudy.repository.ServiceApi;

import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    public MutableLiveData<CheckUserEmailResponse> resultCode = new MutableLiveData<>();
    public MutableLiveData<String> userIdLiveData = new MutableLiveData<>();
    public ServiceApi service;
    // ServiceApi service = RetrofitClient.getClient().create(ServiceApi.class);
    //protected ServiceApi service;
    //private SharedPreferences pref;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        service = RetrofitClient.getClient().create(ServiceApi.class);
        //service  = RetrofitClient.getClient(application).create(ServiceApi.class);
        //pref = application.getSharedPreferences();

    }

    //서버에서 응답받는 코드 -> 응답코드 받아서 성공/실패여부 확인?
    public void checkUserEmail(String userEmail){
        System.out.println("#4 checkUserEmail 메서드 실행");
        System.out.println("email: "+ userEmail);
        //이 아래 실행이 안됨
        service.checkUserEmail(new CheckUserEmailRequest(userEmail)).enqueue(new Callback<CheckUserEmailResponse>() {
            @Override
            public void onResponse(Call<CheckUserEmailResponse> call, Response<CheckUserEmailResponse> response) {
                CheckUserEmailResponse result = response.body();
                resultCode.postValue(result);
                System.out.println("#5 서버에서 받은 code값"+ result.getCode());
            }

            @Override
            public void onFailure(Call<CheckUserEmailResponse> call, Throwable t) {
                System.out.println("fail");
                t.printStackTrace();
            }
        });
    }

//    public String getLoginMethod(){
//        return pref.getLoginMethod();
//    }
//
//    public void getLoginSession() {
//        String userId = " ";
//        Iterator<String> iterator = pref.getCookies().iterator();
//        if (iterator != null) {
//            while (iterator.hasNext()) {
//                userId = iterator.next();
//                userId = userId.split(";")[0].split("=")[1];
//                Log.d("SESSION", "getLoginSession: " +userId);
//            }
//        }
//        userIdLiveData.postValue(userId);
//    }

}