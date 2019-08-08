package com.wdl.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wdl.myapplication.R;
import com.wdl.myapplication.adapter.HomepageGoodsInfoAdapter;
import com.wdl.myapplication.bean.HomePageGoodsInfoBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomepageGoodsInfoActivity extends AppCompatActivity implements MyContract.MyView.HomepageGoodsInfoActivity {

    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);
    private Banner banner;
    List<String> strings = new ArrayList<String>();
    List<String> string = new ArrayList<String>();
    private TextView name,points,sales,market_price,shop_price,rate ,jia,jian,back,buy,buy2,spec_list;
    private EditText num;
    private RecyclerView recyclerView;
    private HomepageGoodsInfoAdapter adapter_imager;
    private HomePageGoodsInfoBean homePageGoodsInfoBean;
    private RelativeLayout relativeLayout ,relativeLayout_show ;
    private ScrollView scrollView;
    private int s;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }*/
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


        setContentView(R.layout.activity_homepage_goods_info);

        banner = findViewById(R.id.Homepage_goods_info_Banner);
        name = findViewById(R.id.Homepage_goods_info_name);
        points = findViewById(R.id.Homepage_goods_info_points);
        sales = findViewById(R.id.Homepage_goods_info_sales);
        market_price = findViewById(R.id.Homepage_goods_info_market_price);
        shop_price = findViewById(R.id.Homepage_goods_info_shop_price);
        rate = findViewById(R.id.homepage_goods_info_shangpinpingjianum);
        recyclerView = findViewById(R.id.homepage_goods_info_RecyclerView_image);
        relativeLayout = findViewById(R.id.homepage_goods_info_pinlun);
        back = findViewById(R.id.Homepage_goods_info_back);
        scrollView = findViewById(R.id.Homepage_goods_info_ScrollView);
        buy = findViewById(R.id.Homepage_goods_info_bay);
        buy2 = findViewById(R.id.Homepage_goods_info_bay1);
        spec_list = findViewById(R.id.Homepage_goods_info_spec_list);
        relativeLayout_show = findViewById(R.id.RelativeLayout_show);
        linearLayout = findViewById(R.id.Homepage_goods_info_LinearLayout);

        //选择规格
        spec();
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomepageGoodsInfoActivity.this,"购买",Toast.LENGTH_SHORT).show();
            }
        });
        //Scrollview显示在最底层
        scrollview();
        //返回
        back();
        //  点击跳转评论页面
        pinlun();
        //加减器
        count();
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        myPresenter.PHomePageGoodsInfo(id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }




    @Override
    public void ShowGoodsInfo(Object o) {
        //Log.e("详情数据",o.toString());
        homePageGoodsInfoBean = (HomePageGoodsInfoBean) o;
        String base_url = homePageGoodsInfoBean.getBase_url();
        //采取最后一个斜杠
        String substring = base_url.substring(0, base_url.length() - 1);

        strings.addAll(homePageGoodsInfoBean.getInfo().getDetail());
        for (int i = 0; i < homePageGoodsInfoBean.getInfo().getDetail().size(); i++) {
            string.add(substring+strings.get(i));
        }
        //Log.e("轮播图",string.toString());
        banner.isAutoPlay(true).setDelayTime(2000).setImages(string).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
        name.setText(homePageGoodsInfoBean.getInfo().getName());
        points.setText(homePageGoodsInfoBean.getInfo().getPoints()+"积分");
        sales.setText("已售："+ homePageGoodsInfoBean.getInfo().getSales());
        market_price.setText("￥ "+ homePageGoodsInfoBean.getInfo().getMarket_price());
        shop_price.setText("￥ "+ homePageGoodsInfoBean.getInfo().getShop_price());
        market_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        rate.setText("("+ homePageGoodsInfoBean.getInfo().getRate()+"人评价)");

        adapter_imager = new HomepageGoodsInfoAdapter(HomepageGoodsInfoActivity.this,homePageGoodsInfoBean);
        recyclerView.setAdapter(adapter_imager);

        adapter_imager.notifyDataSetChanged();
    }

    //方法
    private void count() {
        jia = findViewById(R.id.Homepage_goods_info_jia);
        jian = findViewById(R.id.Homepage_goods_info_jian);
        num = findViewById(R.id.Homepage_goods_info_num);
        num.clearFocus();
        //输入框获取焦点
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setFocusable(true);
                num.setFocusableInTouchMode(true);
                num.requestFocus();
            }
        });
        s = Integer.parseInt(num.getText().toString());
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s++;
                num.setText(s+"");
            }
        });
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s>0){
                    s--;
                    num.setText(s+"");
                }
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

    private void pinlun() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageGoodsInfoActivity.this,HomepageGoodsInfoCommentActivity.class);
                intent.putExtra("id",homePageGoodsInfoBean.getInfo().getId());
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

    private void spec() {
        spec_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.clearFocus();
                linearLayout.setEnabled(false);
                relativeLayout_show.setVisibility(View.VISIBLE);

                relativeLayout_show.setFocusable(true);
                relativeLayout_show.setFocusableInTouchMode(true);
                relativeLayout_show.requestFocus();
            }
        });
        scrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout_show.setVisibility(View.GONE);
            }
        });
        buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomepageGoodsInfoActivity.this,"购买2",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
