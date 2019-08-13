package com.wdl.myapplication.presenter;

import android.util.Log;

import com.wdl.myapplication.bean.ClassifyBean;
import com.wdl.myapplication.bean.GetUserBean;
import com.wdl.myapplication.bean.HomePageBanderBean;
import com.wdl.myapplication.bean.HomePageGoodsBean;
import com.wdl.myapplication.bean.HomePageGoodsInfoBean;
import com.wdl.myapplication.bean.HomePageGoodsInfoByBean;
import com.wdl.myapplication.bean.HomePageHotBean;
import com.wdl.myapplication.bean.HomePageIntegralBean;
import com.wdl.myapplication.bean.MyLoginBean;
import com.wdl.myapplication.bean.MyLoginYzmBean;
import com.wdl.myapplication.bean.MyOrderFkBean;
import com.wdl.myapplication.bean.ShoppingCarBean;
import com.wdl.myapplication.bean.TalkTmBean;
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
    //热销
    @Override
    public void PHomePagehot() {
        final MyContract.MyView.HomePageActivity homePageActivity = (MyContract.MyView.HomePageActivity) t;
        myModel.doPost(Port.Homepage_hot, HomePageHotBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                homePageActivity.Showhot(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }

    @Override
    public void PHomePageGoodsInfo(int aid) {
        final MyContract.MyView.HomepageGoodsInfoActivity homepageGoodsInfoActivity = (MyContract.MyView.HomepageGoodsInfoActivity) t;
        map.put("aid", String.valueOf(aid));
        myModel.doGet(Port.Homepage_GoodsUrlInfo, HomePageGoodsInfoBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                homepageGoodsInfoActivity.ShowGoodsInfo(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }

    @Override
    public void PHomePageGoodsInfoBy(int cid, int gid, int num) {
        final MyContract.MyView.HomepageGoodsInfoActivity homepageGoodsInfoActivity = (MyContract.MyView.HomepageGoodsInfoActivity) t;
        map.put("cid", String.valueOf(cid));
        map.put("gid", String.valueOf(gid));
        map.put("num", String.valueOf(num));
        myModel.doGet(Port.Homepage_GoodsUrlInfoBy, HomePageGoodsInfoByBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                homepageGoodsInfoActivity.ShowGoodsInfoBy(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }

    @Override
    public void PTalkTm(int page) {
        final MyContract.MyView.TalkFragment talkFragment = (MyContract.MyView.TalkFragment) t;
        map.put("aid", String.valueOf(page));
        myModel.doGet(Port.TalkTm, TalkTmBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                talkFragment.ShowTalk(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }

    @Override
    public void PShopping_Car() {
        final MyContract.MyView.ShoppingFragment shoppingFragment = (MyContract.MyView.ShoppingFragment) t;
        myModel.doGet(Port.ShoppingCar, ShoppingCarBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                shoppingFragment.ShowShoppingCar(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }

    //验证码
    @Override
    public void PMyLoginYzm(String phone) {
        final MyContract.MyView.LogingActivity logingActivity = (MyContract.MyView.LogingActivity) t;
        map.put("phone", String.valueOf(phone));
        myModel.doGet(Port.My_LoginYzm, MyLoginYzmBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                logingActivity.ShowGetYzm(o);
            }

            @Override
            public void onError(Object o) {
            }
        });
    }

    @Override
    public void PMyLogin(String phone, String code) {
        final MyContract.MyView.LogingActivity logingActivity = (MyContract.MyView.LogingActivity) t;
        map.put("phone", phone);
        map.put("code", String.valueOf(code));
        myModel.doGet(Port.My_Login, MyLoginBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                logingActivity.ShowLogin(o);
            }

            @Override
            public void onError(Object o) {
            }
        });
    }

    @Override
    public void PMyUser() {
        final MyContract.MyView.MyFragment myFragment = (MyContract.MyView.MyFragment) t;
        myModel.doGet(Port.My_User, GetUserBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                myFragment.ShowMyFragment(o);
            }

            @Override
            public void onError(Object o) {
            }
        });
    }

    @Override
    public void PMySetUpUser() {
        final MyContract.MyView.SetUpActivity setUpActivity = (MyContract.MyView.SetUpActivity) t;
        myModel.doGet(Port.My_User, GetUserBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                setUpActivity.ShowUser(o);
            }
            @Override
            public void onError(Object o) {
            }
        });
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
    public void PClassifyFragment(int fid) {
        final MyContract.MyView.ClassifyFragment classifyFragment = (MyContract.MyView.ClassifyFragment) t;
        myModel.doGet(Port.Classify, ClassifyBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                classifyFragment.ShowClassifyFragment(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }

    @Override
    public void PMyOderFk(int type) {
        final MyContract.MyView.OderAllFKFragment oderAllFKFragment = (MyContract.MyView.OderAllFKFragment) t;
        map.put("type", String.valueOf(type));
        myModel.doGet(Port.My_Oder_Fk, MyOrderFkBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                oderAllFKFragment.ShowMyOderFk(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }
}
