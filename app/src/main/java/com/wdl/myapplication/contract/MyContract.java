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
        void PHomePageGoodsInfo(int id );
        void PHomePageGoodsInfoComment(int gid,int start, int num);
        void PClassifyFragment();


    }

    interface MyView{
        interface HomePageActivity{
            void ShowBander(Object o);
            void ShowIntegral(Object o);
            void ShowGoods(Object o);
        }
        interface HomepageGoodsInfoActivity{
            void ShowGoodsInfo(Object o);
        }
        //评论
        interface HomepageGoodsInfoCommentActivity{
            void ShowGoodsInfoComment(Object o);
        }
        //分类
        interface ClassifyFragment{
            void ShowClassifyFragment(Object o);
        }

    }

}
