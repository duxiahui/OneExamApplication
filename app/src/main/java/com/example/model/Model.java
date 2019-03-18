package com.example.model;





import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {


    private static Model model;
    private InfoRet infoRet;


    public void SetInfoRet(InfoRet infoRet){
        this.infoRet = infoRet;

    }


    public void GetInfos(String BaseUrl , String path , Map<String,String> map){

        Retrofit build = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        CallBackRet callBackRet = build.create(CallBackRet.class);
        Call<Bean> beanCall = callBackRet.GetInfo(path, map);
        beanCall.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {

                infoRet.SucceeFulRet(response.body());

            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                infoRet.FailRet("失败");
            }
        });


    }


    public static Model getInstance(){

        if(model == null){
            model = new Model();
        }
        return  model;
    }

}
