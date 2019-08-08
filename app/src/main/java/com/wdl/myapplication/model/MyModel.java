package com.wdl.myapplication.model;

import android.util.Log;

import com.google.gson.Gson;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.util.Api;
import com.wdl.myapplication.util.RetrofitUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MyModel implements MyContract.MyModel {
    MyCallBack myCallBack;

    @Override
    public void doGet(String url, final Class cls, Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getRetrofitUtil().getRetrofit(Api.class)
                .requestGet(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        Gson gson = new Gson();
                        Object o = gson.fromJson(responseBody.string(), cls);
                        myCallBack.success(o);
                        Log.e("你看看+mg",o+"");
                    }
                });
    }

    @Override
    public void doPost(String url, final Class aClass, Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getRetrofitUtil().getRetrofit(Api.class)
                .requestPost(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        Gson gson = new Gson();
                        Object o = gson.fromJson(responseBody.string(), aClass);
                        myCallBack.success(o);
                        Log.e("你看看+mp",o+"");
                    }
                });
    }

    public interface MyCallBack{
        void success(Object o);
        void onError (Object o);
    }
}
