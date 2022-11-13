package com.example.dinostudy.repository;

import com.example.dinostudy.model.AddTodoData;
import com.example.dinostudy.model.AddTodoResponse;
import com.example.dinostudy.model.CheckEmailData;
import com.example.dinostudy.model.CheckEmailResponse;

import com.example.dinostudy.model.CreateTodoData;
import com.example.dinostudy.model.CreateTodoResponse;
import com.example.dinostudy.model.DeleteTodoData;
import com.example.dinostudy.model.DeleteTodoResponse;
import com.example.dinostudy.model.ReadTodoData;
import com.example.dinostudy.model.ReadTodoResponse;
import com.example.dinostudy.model.EditTodoData;
import com.example.dinostudy.model.EditTodoResponse;
import com.example.dinostudy.model.UpdateCheckTodoData;
import com.example.dinostudy.model.UpdateCheckTodoResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {

    @POST("/user/checkEmail")
    Call<CheckEmailResponse> checkUserEmail (@Body CheckEmailData data);

    @POST("/todo/create")
    Call<CreateTodoResponse> createTodoData (@Body CreateTodoData data);

    @POST("/todo/read")
    Call<ReadTodoResponse> readTodoData (@Body ReadTodoData data);

    @POST("/todo/add")
    Call<AddTodoResponse> addTodoData (@Body AddTodoData data);

    @POST("/todo/edit")
    Call<EditTodoResponse> editTodoData (@Body EditTodoData data);

    @POST("/todo/delete")
    Call<DeleteTodoResponse> deleteTodoData (@Body DeleteTodoData data);

    @POST("/todo/edit/checkbox")
    Call<UpdateCheckTodoResponse> updateCheckTodoData (@Body UpdateCheckTodoData data);
}

