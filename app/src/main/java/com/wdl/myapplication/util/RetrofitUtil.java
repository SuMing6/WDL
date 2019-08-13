package com.wdl.myapplication.util;

import android.util.Log;

import com.wdl.myapplication.view.LogingActivity;

import java.io.IOException;
import java.util.function.Consumer;

import io.reactivex.plugins.RxJavaPlugins;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class RetrofitUtil {
    OkHttpClient okHttpClient ;
    static RetrofitUtil retrofitUtil ;
    private Retrofit retrofit;
    public static int sid = 0;


    private RetrofitUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("数据", message);
                //Log.e("获取登录状态", String.valueOf(LogingActivity.sid));
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("id", String.valueOf(LogingActivity.sid))
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addNetworkInterceptor(interceptor)
                .build();
    }

    public static synchronized RetrofitUtil getRetrofitUtil(){
        if (retrofitUtil == null){
            retrofitUtil = new RetrofitUtil();
        }
        return retrofitUtil;
    }

    public Retrofit retrofit(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://www.wandongli.com.cn:80/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public <T>T getRetrofit(Class<T> tClass){
        return retrofit().create(tClass);
    }
}

