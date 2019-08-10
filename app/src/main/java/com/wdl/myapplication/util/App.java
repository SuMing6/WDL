package com.wdl.myapplication.util;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.drawee.backends.pipeline.Fresco;/*
import com.wdl.myapplication.greendao.DaoBeanDao;
import com.wdl.myapplication.greendao.DaoMaster;
import com.wdl.myapplication.greendao.DaoSession;*/

public class App extends Application {

/*
    public static DaoBeanDao daoBeanDao;*/

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        /*DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.this,"Ymh.db");
        //获取可写数据库
        SQLiteDatabase database = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(database);
        //获取Dao对象管理者
        DaoSession mDaoSession = daoMaster.newSession();

        daoBeanDao = mDaoSession.getDaoBeanDao();*/

    }
}
