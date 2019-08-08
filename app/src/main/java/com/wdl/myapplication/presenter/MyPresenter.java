package com.wdl.myapplication.presenter;

import android.util.Log;

import com.wdl.myapplication.bean.ClassifyBean;
import com.wdl.myapplication.bean.HomePageBanderBean;
import com.wdl.myapplication.bean.HomePageGoodsBean;
import com.wdl.myapplication.bean.HomePageGoodsInfoBean;
import com.wdl.myapplication.bean.HomePageIntegralBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.data.Port;
import com.wdl.myapplication.model.MyModel;
import com.wdl.myapplication.view.HomepageGoodsInfoActivity;

import java.util.HashMap;
import java.util.Map;

public class MyPresenter<T> implements MyContract.MyPresenter {
    MyContract.MyModel myModel ;
    T t ;
    private final Map<String, String> map;

    public MyPresenter(T tt){
        t = tt ;
        this.map = new HashMap<>();
        myModel = new MyModel();
    }

    //首页轮播图
    @Override
    public void PHomePageBander() {
        final MyContract.MyView.HomePageActivity homePageActivity = (MyContract.MyView.HomePageActivity) t;
        myModel.doPost(Port.Homepage_BanderUrl, HomePageBanderBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                homePageActivity.ShowBander(o);
            }

            @Override
            public void onError(Object o) {
                //Log.e("错误",o.toString());
            }
        });
    }
    //首页为您推荐
    @Override
    public void PHomePageIntegral() {
        final MyContract.MyView.HomePageActivity homePageActivity = (MyContract.MyView.HomePageActivity) t;
        myModel.doPost(Port.Homepage_IntegralUrl, HomePageIntegralBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                homePageActivity.ShowIntegral(o);
            }

            @Override
            public void onError(Object o) {
                //Log.e("错误",o.toString());
            }
        });
    }
    //首页为您推荐
    @Override
    public void PHomePageGoods() {
        final MyContract.MyView.HomePageActivity homePageActivity = (MyContract.MyView.HomePageActivity) t;
        myModel.doPost(Port.Homepage_GoodsUrl, HomePageGoodsBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                homePageActivity.ShowGoods(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }
    //详情页面
    @Override
    public void PHomePageGoodsInfo(int id) {
        /*final HomepageGoodsInfoActivity homepageGoodsInfoActivity = (HomepageGoodsInfoActivity) t;
        map.put("id", String.valueOf(id));
        myModel.doPost(Port.Homepage_GoodsUrlInfo, HomePageGoodsInfoBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                homepageGoodsInfoActivity.ShowGoodsInfo(o);
            }

            @Override
            public void onError(Object o) {

            }
        });*/
    }
    //详情页评论
    @Override
    public void PHomePageGoodsInfoComment(int gid, int start, int num) {
       /* MyContract.MyView.HomepageGoodsInfoCommentActivity homepageGoodsInfoCommentActivity = (MyContract.MyView.HomepageGoodsInfoCommentActivity) t;
        map.put("gid", String.valueOf(gid));
        map.put("start", String.valueOf(start));
        map.put("num", String.valueOf(num));
        myModel.doPost(Port.Homepage_GoodsUrlInfocomment, null, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {

            }

            @Override
            public void onError(Object o) {

            }
        });*/
    }
    //分类
    @Override
    public void PClassifyFragment() {
        /*final MyContract.MyView.ClassifyFragment classifyFragment = (MyContract.MyView.ClassifyFragment) t;
        myModel.doGet(Port.Classify, ClassifyBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                classifyFragment.ShowClassifyFragment(o);

            }

            @Override
            public void onError(Object o) {

            }
        });*/
    }
}
