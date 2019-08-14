package com.wdl.myapplication.util;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.RemoteViews;

import com.facebook.drawee.backends.pipeline.Fresco;/*
import com.wdl.myapplication.greendao.DaoBeanDao;
import com.wdl.myapplication.greendao.DaoMaster;
import com.wdl.myapplication.greendao.DaoSession;*/
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;
import com.wdl.myapplication.R;

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

        UMConfigure.init(this, "5d5359b30cafb2e6ba00076c", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "eb7748e2fab9fda615d4c6b67c66cc53");
//获取消息推送代理示例
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                //Log.i("推送","注册成功：deviceToken：-------->  " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                //Log.e("推送","注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });

       /* UmengMessageHandler messageHandler = new UmengMessageHandler() {

            *//**
             * 自定义通知栏样式的回调方法
             *//*
            @Override
            public Notification getNotification(Context context, UMessage msg) {
                switch (msg.builder_id) {
                    case 1:
                        Notification.Builder builder = new Notification.Builder(context);
                        RemoteViews myNotificationView = new RemoteViews(context.getPackageName(),
                                R.layout.notification_view);
                        myNotificationView.setTextViewText(R.id.notification_title, msg.title);
                        myNotificationView.setTextViewText(R.id.notification_text, msg.text);
                        myNotificationView.setImageViewBitmap(R.id.notification_large_icon, getLargeIcon(context, msg));
                        myNotificationView.setImageViewResource(R.id.notification_small_icon,
                                getSmallIconId(context, msg));
                        builder.setContent(myNotificationView)
                                .setSmallIcon(getSmallIconId(context, msg))
                                .setTicker(msg.ticker)
                                .setAutoCancel(true);

                        return builder.getNotification();
                    default:
                        //默认为0，若填写的builder_id并不存在，也使用默认。
                        return super.getNotification(context, msg);
                }
            }
        };
        mPushAgent.setMessageHandler(messageHandler);

        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler(){

            @Override
            public void dealWithCustomAction(Context context, UMessage msg){
                //Log.e("推送","click");
            }

        };

        mPushAgent.setNotificationClickHandler(notificationClickHandler);
*/
    }
}
