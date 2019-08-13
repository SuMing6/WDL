package com.wdl.myapplication.contract;


import com.wdl.myapplication.model.MyModel;

import java.util.Map;

public interface MyContract {

    interface MyModel{
        void doGet(String url, Class cls, Map<String, String> map, com.wdl.myapplication.model.MyModel.MyCallBack myCallBack);
        void doPost(String url, Class cls, Map<String, String> map, com.wdl.myapplication.model.MyModel.MyCallBack myCallBack);
    }

    interface MyPresenter{
        void PHomePageBander();
        void PHomePageIntegral();
        void PHomePageGoods();
        void PHomePagehot();
        void PHomePageGoodsInfo(int aid);
        void PHomePageGoodsInfoBy(int cid,int gid,int num);


        void PTalkTm(int page);

        void PShopping_Car();

        void PMyLoginYzm(String phone);
        void PMyLogin(String phone,String code);
        void PMyUser();
        void PMySetUpUser();



        void PHomePageGoodsInfoComment(int gid,int start, int num);
        void PClassifyFragment(int fid);

        void PMyOderFk(int type);


    }

    interface MyView{
        interface HomePageActivity{
            void ShowBander(Object o);
            void ShowIntegral(Object o);
            void ShowGoods(Object o);
            void Showhot(Object o);
        }
        //详情页面
        interface HomepageGoodsInfoActivity{
            void ShowGoodsInfo(Object o);
            void ShowGoodsInfoBy(Object o);
        }
        //分类
        interface ClassifyFragment{
            void ShowClassifyFragment(Object o);
        }

        //购物车展示
        interface ShoppingFragment{
            void ShowShoppingCar(Object o);
        }
        //我的页面
        interface MyFragment{
            void ShowMyFragment(Object o);
        }
        //评论
        interface HomepageGoodsInfoCommentActivity{
            void ShowGoodsInfoComment(Object o);
        }
        //登录_验证码
        interface LogingActivity{
            void ShowGetYzm(Object o);
            void ShowLogin(Object o);
        }
        interface TalkFragment{
            void ShowTalk(Object o);
        }
        interface SetUpActivity{
            void ShowUser(Object o);
        }
        interface OderAllFKFragment{
            void ShowMyOderFk(Object o);
        }

    }

}
