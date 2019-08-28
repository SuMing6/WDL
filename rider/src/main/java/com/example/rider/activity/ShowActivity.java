package com.example.rider.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.example.rider.R;
import com.example.rider.view.HomePageFragment;
import com.example.rider.view.MyFragment;
import com.example.rider.view.TaskFragment;

public class ShowActivity extends AppCompatActivity {

    private FragmentManager manager;
    private HomePageFragment homePageFragment;
    private TaskFragment taskFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XNAJ();
        setContentView(R.layout.activity_show);

        RadioGroup radioGroup = findViewById(R.id.show_RadioGroup);

        homePageFragment = new HomePageFragment();
        taskFragment = new TaskFragment();
        myFragment = new MyFragment();

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.show_FrameLayout, homePageFragment)
                .add(R.id.show_FrameLayout, taskFragment)
                .add(R.id.show_FrameLayout, myFragment)
                .show(homePageFragment)
                .hide(taskFragment)
                .hide(myFragment)
                .commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (i){
                    case R.id.show_homepage:
                        transaction
                                .show(homePageFragment)
                                .hide(taskFragment)
                                .hide(myFragment);
                        break;
                    case R.id.show_task:
                        transaction
                                .show(taskFragment)
                                .hide(homePageFragment)
                                .hide(myFragment);
                        break;
                    case R.id.show_my:
                        transaction
                                .show(myFragment)
                                .hide(taskFragment)
                                .hide(homePageFragment);
                        break;
                }
                transaction.commit();
            }
        });

    }
    private void XNAJ() {
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
    }
}
