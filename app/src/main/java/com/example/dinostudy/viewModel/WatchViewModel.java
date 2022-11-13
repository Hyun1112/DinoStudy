package com.example.dinostudy.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

//import com.example.dinostudy.model.CheckWatchData;
//import com.example.dinostudy.model.CheckWatchResponse;
import com.example.dinostudy.repository.RetrofitClient;
import com.example.dinostudy.repository.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WatchViewModel extends AndroidViewModel {
    //public MutableLiveData<CheckWatchResponse> resultCode = new MutableLiveData<>();

    ServiceApi service;
    //private SharedPreferences pref;


    public WatchViewModel(@NonNull Application application) {
        super(application);
        service = RetrofitClient.getClient().create(ServiceApi.class);
        //pref = application.getSharedPreferences();

    }

//    //서버에서 응답받는 코드 -> 응답코드 받아서 성공/실패여부 확인?
//    public void checkWatch(CheckWatchData data){
//        System.out.println("********* checkWatchData *********");
//
//        service.checkWatchData(data).enqueue(new Callback<CheckWatchResponse>() {
//            @Override
//            public void onResponse(Call<CheckWatchResponse> call, Response<CheckWatchResponse> response) {
//                CheckWatchResponse result = response.body();
//                resultCode.postValue(result);
//                System.out.println("code: "+ result.getCode());
//            }
//
//            @Override
//            public void onFailure(Call<CheckWatchResponse> call, Throwable t) {
//                System.out.println("fail");
//                t.printStackTrace();
//            }
//        });
//    }

//    public void createWatch(CreateWatchData data){
//        System.out.println("********* createWatchData *********");
//
//        service.createWatchData(data).enqueue(new Callback<CreateWatchResponse>() {
//            @Override
//            public void onResponse(Call<CreateWatchResponse> call, Response<CreateWatchResponse> response) {
//                CreateWatchResponse result = response.body();
//                createResult.postValue(result);
//                System.out.println("create resultCode: "+ result.getCode());
//            }
//
//            @Override
//            public void onFailure(Call<CreateWatchResponse> call, Throwable t) {
//                System.out.println("fail");
//                t.printStackTrace();
//            }
//        });
//    }

}