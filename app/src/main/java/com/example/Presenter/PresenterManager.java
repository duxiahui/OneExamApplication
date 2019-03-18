package com.example.Presenter;

import com.example.model.Bean;
import com.example.model.CallBackRet;
import com.example.model.InfoRet;
import com.example.model.Model;
import com.example.view.ViewInfo;

import java.util.Map;

public class PresenterManager implements InfoRet {


    private ViewInfo viewInfo;

    public PresenterManager(ViewInfo viewInfo){
        Model.getInstance().SetInfoRet(this);
        this.viewInfo = viewInfo;
    }


    public void GetInfo(String BaseUrl , String path , Map<String,String> map ){
        Model.getInstance().GetInfos(BaseUrl,path,map);
    }






    @Override
    public void SucceeFulRet(Bean bean) {

        viewInfo.SussccRet(bean);
    }

    @Override
    public void FailRet(String ret) {
        viewInfo.FailtRet(ret);

    }
}
