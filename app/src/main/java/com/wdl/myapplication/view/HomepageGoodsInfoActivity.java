package com.wdl.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wdl.myapplication.R;
import com.wdl.myapplication.adapter.HomepageGoodsInfoAdapter;
import com.wdl.myapplication.bean.HomePageGoodsInfoBean;
import com.wdl.myapplication.bean.HomePageGoodsInfoByBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomepageGoodsInfoActivity extends AppCompatActivity implements MyContract.MyView.HomepageGoodsInfoActivity {

    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);
    private Banner banner;
    private TextView name,points,sales,market_price,shop_price,rate ,jia,jian,back,buy,spec_list;
    private RecyclerView recyclerView;
    private RelativeLayout relativeLayout ;
    private ScrollView scrollView;
    private LinearLayout linearLayout;
    private HomePageGoodsInfoBean homePageGoodsInfoBean;
    List<String> strings = new ArrayList<>();

    int screenWidth;//屏幕宽度
    int screenHeight;//屏幕高度
    private int height;
    private PopupWindow popupWindow;
    private WindowManager windowManager;
    private View contentView;

    private TextView pop_name,pop_kc;
    private Banner pop_banner;
    private HomePageGoodsInfoBean.DataBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CQS();
        setContentView(R.layout.activity_homepage_goods_info);

        windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        screenWidth = display.getWidth();
        screenHeight = display.getHeight();

        banner = findViewById(R.id.Homepage_goods_info_Banner);
        name = findViewById(R.id.Homepage_goods_info_name);
        sales = findViewById(R.id.Homepage_goods_info_sales);
        market_price = findViewById(R.id.Homepage_goods_info_market_price);
        shop_price = findViewById(R.id.Homepage_goods_info_shop_price);
        rate = findViewById(R.id.homepage_goods_info_shangpinpingjianum);
        recyclerView = findViewById(R.id.homepage_goods_info_RecyclerView_image);
        relativeLayout = findViewById(R.id.homepage_goods_info_pinlun);
        back = findViewById(R.id.Homepage_goods_info_back);
        scrollView = findViewById(R.id.Homepage_goods_info_ScrollView);
        buy = findViewById(R.id.Homepage_goods_info_bay);
        spec_list = findViewById(R.id.Homepage_goods_info_spec_list);
        linearLayout = findViewById(R.id.Homepage_goods_info_popup);


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LogingActivity.myLoginBean.getData()!=null){
                    myPresenter.PHomePageGoodsInfoBy(homePageGoodsInfoBean.getData().getId(),homePageGoodsInfoBean.getData().getSid(),1);
                }else {
                    Toast.makeText(HomepageGoodsInfoActivity.this,"请先登录",Toast.LENGTH_SHORT).show();
                }
            }
        });
        spec();
        //Scrollview显示在最底层
        scrollview();
        //返回
        back();
        //  点击跳转评论页面
        pinlun();
        //加减器
        //count();
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");


        myPresenter.PHomePageGoodsInfo(id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


    }




    @Override
    public void ShowGoodsInfo(Object o) {

        homePageGoodsInfoBean = (HomePageGoodsInfoBean) o;
        data = homePageGoodsInfoBean.getData();
        String pic = homePageGoodsInfoBean.getData().getPic();

        strings.addAll(Collections.singleton(pic));
        banner.isAutoPlay(true).setDelayTime(2500).setImages(strings).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();

        name.setText(data.getTitle());

        HomepageGoodsInfoAdapter Adapter = new HomepageGoodsInfoAdapter(this, homePageGoodsInfoBean);
        recyclerView.setAdapter(Adapter);

        shop_price.setText(data.getPrice()+"");
        market_price.setText(data.getPrice_old()+"");
        market_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);


    }

    @Override
    public void ShowGoodsInfoBy(Object o) {
        HomePageGoodsInfoByBean homePageGoodsInfoByBean = (HomePageGoodsInfoByBean) o;
        //Log.e("啊啊啊啊",homePageGoodsInfoByBean.getMsg());
            Toast.makeText(this,""+homePageGoodsInfoByBean.getMsg(),Toast.LENGTH_SHORT).show();
    }


    private void spec() {
        contentView = LayoutInflater.from(HomepageGoodsInfoActivity.this).inflate(R.layout.popup_window_homepage_good_info, null);
        spec_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                height = linearLayout.getHeight();
                popupWindow = new PopupWindow(contentView,screenWidth , 2200, true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.setOutsideTouchable(true);
                popupWindow.setTouchable(true);
                popupWindow.showAsDropDown(linearLayout,0 ,height );
                //变色
                bgAlpha(0.618f);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        bgAlpha(1.0f);
                    }
                });

                pop_banner = contentView.findViewById(R.id.Homepage_goods_info_ImageView);
                pop_name = contentView.findViewById(R.id.Homepage_goods_info_name1);
                pop_kc = contentView.findViewById(R.id.Homepage_goods_info_name2);

                pop_banner.isAutoPlay(true).setDelayTime(1000).setImages(strings).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();
                pop_name.setText(data.getTitle());
                pop_kc.setText("库存"+homePageGoodsInfoBean.getData().getSku()+"件");
            }
        });

    }
    private  void bgAlpha(float f){
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.alpha = f;
        getWindow().setAttributes(layoutParams);
    }

    private void back() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void pinlun() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageGoodsInfoActivity.this,HomepageGoodsInfoCommentActivity.class);
                intent.putExtra("id",homePageGoodsInfoBean.getData().getId());
                startActivity(intent);
            }
        });
    }
    private void scrollview() {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
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
