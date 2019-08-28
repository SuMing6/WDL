package com.example.rider.util;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;

import com.example.rider.activity.MainActivity;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.Locale;

public class App extends Application {

    private SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        boolean China = sp.getBoolean("China", false);
        if (China == true){
            changeAppLanguage(Locale.SIMPLIFIED_CHINESE);
        }else {
            changeAppLanguage(Locale.UK);
        }


    }

    /**
     * 更改应用语言
     *
     * @param locale
     */
    public void changeAppLanguage(Locale locale) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Configuration configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        getResources().updateConfiguration(configuration, metrics);
        //重新启动Activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
