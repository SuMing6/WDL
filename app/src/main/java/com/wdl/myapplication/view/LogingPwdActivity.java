package com.wdl.myapplication.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.wdl.myapplication.R;

public class LogingPwdActivity extends AppCompatActivity {

    TextView textView ,my_loginpwd_back,my_loginpwd_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CQS();
        setContentView(R.layout.activity_loging_pwd);

        yzm();
        back();
        register();
    }

    private void register() {
        my_loginpwd_reg = findViewById(R.id.my_loginpwd_reg);
        my_loginpwd_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogingPwdActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void back() {
        my_loginpwd_back = findViewById(R.id.my_loginpwd_back);
        my_loginpwd_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void yzm() {
        textView = findViewById(R.id.my_loginpwd_yzm);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogingPwdActivity.this,LogingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void CQS() {
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
