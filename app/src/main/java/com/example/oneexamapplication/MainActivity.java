package com.example.oneexamapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.Presenter.PresenterManager;
import com.example.model.Bean;
import com.example.view.ViewInfo;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ViewInfo {

    private String BaseUrl = "http://www.qubaobei.com/ios/cf/";
     private   String path = "dish_list.php";

     private RecyclerView mMain_rv;
     private Myadapter myadapter;
     int a ;
    Map<String ,String> map = new HashMap<>();
    PresenterManager presenterManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMain_rv = findViewById(R.id.mMain_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMain_rv.setLayoutManager(linearLayoutManager);
        myadapter = new Myadapter(MainActivity.this);
        mMain_rv.setAdapter(myadapter);
        map.put("stage_id","1");
        map.put("limit","20");
        map.put("page","1");
        presenterManager  = new PresenterManager(this);

    }

    @Override
    public void SussccRet(Bean bean) {

        String food_str = bean.getData().get(0).getFood_str();
        Log.e("s",food_str+bean.getData().size());

        myadapter.ReFrsh(bean.getData());


    }

    @Override
    public void FailtRet(String ret) {

    }

    public void onclick(View view) {

        presenterManager.GetInfo(BaseUrl,path,map);


    }
}
