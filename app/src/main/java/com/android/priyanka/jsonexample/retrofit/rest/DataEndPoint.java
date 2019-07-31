package com.android.priyanka.jsonexample.retrofit.rest;

import com.android.priyanka.jsonexample.retrofit.model.DataModelRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface DataEndPoint {

    @POST("jsonparsetutorial.txt")
    Call<List<DataModelRetrofit>> getData();


    @POST("jsonparsetutorial.txt")
    Call<DataModelRetrofit> getDataList();
}
