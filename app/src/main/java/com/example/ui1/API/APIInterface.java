package com.example.ui1.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    String BASE_URL="https://corona.lmao.ninja/v3/COVID-19/";
    @GET("countries")
    Call<List<ModelClass>> getLocalData();

    String BASE_URL1="https://corona.lmao.ninja/v3/COVID-19/";
    @GET("all")
    Call<ModelClass1> getGlobalData();
}
