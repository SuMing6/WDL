package com.wdl.myapplication.util;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.function.Consumer;

import io.reactivex.plugins.RxJavaPlugins;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
