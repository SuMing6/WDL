package com.wdl.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.wdl.myapplication.R;
import com.wdl.myapplication.adapter.OrderAllPagerAdapter;
import com.wdl.myapplication.oderall.OderAllFKFragment;
import com.wdl.myapplication.oderall.OderAllFhFragment;
import com.wdl.myapplication.oderall.OderAllPJFragment;
import com.wdl.myapplication.oderall.OderAllSHFragment;
import com.wdl.myapplication.view.MyAddDiZhiActivity;
import com.wdl.myapplication.view.MyDiZhiActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderAllActivity extends AppCompatActivity {

    TextView my_order_all_back ;
    TabLayout tabLayout ;
    ViewPager viewPager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CQS();
        setContentView(R.layout.activity_order_all);
        my_order_all_back = findViewById(R.id.my_order_all_back);
        tabLayout = findViewById(R.id.my_order_all_TabLayout);
        viewPager = findViewById(R.id.my_order_all_ViewPager);
        my_order_all_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        ArrayList<String> list_Title = new ArrayList<>();
        fragmentList.add(new OderAllFKFragment());
        fragmentList.add(new OderAllFhFragment());
        fragmentList.add(new OderAllSHFragment());
        fragmentList.add(new OderAllPJFragment());
        fragmentList.add(new OderAllSHFragment());
        list_Title.add("待付款");
        list_Title.add("待发货");
        list_Title.add("待收货");
        list_Title.add("待评价");
        list_Title.add("退款退货");
        /*String sID=getIntent().getStringExtra("page");
        int id=Integer.parseInt(sID);*/
        viewPager.setAdapter(new OrderAllPagerAdapter(getSupportFragmentManager(),OrderAllActivity.this,fragmentList,list_Title));
        tabLayout.setupWithViewPager(viewPager);//此方法就是让tablayout和ViewPager联动

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
