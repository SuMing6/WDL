package com.wdl.myapplication.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.wdl.myapplication.R;
import com.wdl.myapplication.view.ClassifyFragment;
import com.wdl.myapplication.view.HomePageFragment;
import com.wdl.myapplication.view.MyFragment;
import com.wdl.myapplication.view.ShoppingFragment;
import com.wdl.myapplication.view.TalkFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private HomePageFragment homePageFragment;
    private ClassifyFragment classifyFragment;
    private TalkFragment talkFragment;
    private ShoppingFragment shoppingFragment;
    private MyFragment myFragment;

    ///
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //虚拟按键
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    //为避免底部导航栏覆盖注释掉这一行
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }



        setContentView(R.layout.activity_main);



        RadioGroup radioGroup = findViewById(R.id.main_RadioGroup);

        homePageFragment = new HomePageFragment();
        classifyFragment = new ClassifyFragment();
        talkFragment = new TalkFragment();
        shoppingFragment = new ShoppingFragment();
        myFragment = new MyFragment();

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.main_FrameLayout, homePageFragment)
                .add(R.id.main_FrameLayout, classifyFragment)
                //.add(R.id.main_FrameLayout, talkFragment)
                .add(R.id.main_FrameLayout, shoppingFragment)
                .add(R.id.main_FrameLayout, myFragment)
                .show(homePageFragment)
                .hide(classifyFragment)
                .hide(talkFragment)
                .hide(shoppingFragment)
                .hide(myFragment)
                .commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.main_button1 :
                        transaction.show(homePageFragment)
                                .hide(classifyFragment)
                                .hide(talkFragment)
                                .hide(shoppingFragment)
                                .hide(myFragment);
                        break;
                    case R.id.main_button2 :
                        transaction.show(classifyFragment)
                                .hide(homePageFragment)
                                .hide(talkFragment)
                                .hide(shoppingFragment)
                                .hide(myFragment);
                        break;
                    /*case R.id.main_button3 :
                        transaction.show(talkFragment)
                                .hide(homePageFragment)
                                .hide(classifyFragment)
                                .hide(shoppingFragment)
                                .hide(myFragment);
                        break;*/
                    case R.id.main_button4 :
                        transaction.show(shoppingFragment)
                                .hide(homePageFragment)
                                .hide(classifyFragment)
                                .hide(talkFragment)
                                .hide(myFragment);
                        break;
                    case R.id.main_button5 :
                        transaction.show(myFragment)
                                .hide(homePageFragment)
                                .hide(classifyFragment)
                                .hide(talkFragment)
                                .hide(shoppingFragment);
                        break;
                }
                transaction.commit();
            }
        });

    }


}
