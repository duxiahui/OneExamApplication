package com.example.model;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CallBackRet {
    @GET("{path}")
    Call<Bean> GetInfo(@Path("path") String path , @QueryMap Map<String,String> map);



}
