package com.wdl.myapplication.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TextView;

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
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
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
                .add(R.id.main_FrameLayout, talkFragment)
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
                    case R.id.main_button3 :
                        transaction.show(talkFragment)
                                .hide(homePageFragment)
                                .hide(classifyFragment)
                                .hide(shoppingFragment)
                                .hide(myFragment);
                        break;
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
