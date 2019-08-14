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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.message.PushAgent;
import com.wdl.myapplication.R;
import com.wdl.myapplication.activity.MainActivity;
import com.wdl.myapplication.bean.ClassifyBean;
import com.wdl.myapplication.bean.MyLoginBean;
import com.wdl.myapplication.bean.MyLoginYzmBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.greendao.DaoBean;
import com.wdl.myapplication.presenter.MyPresenter;
import com.wdl.myapplication.util.App;
import com.wdl.myapplication.util.RetrofitUtil;

public class LogingActivity extends AppCompatActivity implements MyContract.MyView.LogingActivity {

    public static MyLoginBean myLoginBean = new MyLoginBean();
    EditText ed_phone , loging_yzm ;
    TextView  loging_getyzm , back,loging_pwd , my_login_reg;
    Button  loging_login ;
    Intent intent = new Intent();
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);
    public static int sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CQS();
        setContentView(R.layout.activity_loging);

        PushAgent.getInstance(this).onAppStart();
        //EventBus.getDefault().register(LogingActivity.this);
        ed_phone = findViewById(R.id.loging_phone);
        loging_getyzm = findViewById(R.id.loging_getyzm);
        loging_yzm = findViewById(R.id.loging_yzm);
        loging_login = findViewById(R.id.loging_login);
        back = findViewById(R.id.my_login_back);
        loging_login();
        back();
        loging_getyzm();

        login_pwd();

        register();



    }

    private void register() {
        my_login_reg = findViewById(R.id.my_login_reg);
        my_login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogingActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login_pwd() {
        loging_pwd = findViewById(R.id.loging_pwd);
        loging_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(LogingActivity.this,LogingPwdActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void back() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loging_login() {
        loging_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String syzm = loging_yzm.getText().toString();
                String sphone = ed_phone.getText().toString();
                myPresenter.PMyLogin(sphone, syzm);
            }
        });
    }

    // 获取验证码
    private void loging_getyzm() {
        loging_getyzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPresenter.PMyLoginYzm(ed_phone.getText().toString());
            }
        });
    }

    // 验证码
    @Override
    public void ShowGetYzm(Object o) {
        MyLoginYzmBean myLoginYzmBean = (MyLoginYzmBean) o;
        Toast.makeText(this,myLoginYzmBean.getMsg()+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowLogin(Object o) {
        myLoginBean = (MyLoginBean) o;
        Toast.makeText(this, myLoginBean.getCode()+"",Toast.LENGTH_SHORT).show();
        if (myLoginBean.getCode()==0){
            sid = myLoginBean.getData().getSid();
            intent.setClass(LogingActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, myLoginBean.getCode()+"登录失败",Toast.LENGTH_SHORT).show();
        }
    }

    private void CQS() {
        /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  //设置为全屏
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//状态栏字体颜色设置为黑色这个是Android 6.0才出现的属性   默认是白色
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);//设置为透明色
            window.setNavigationBarColor(Color.TRANSPARENT);
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }*/
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
