package com.example.rider.contract;

import com.example.rider.model.MyModel;

import java.util.Map;

public interface MyContract {
    interface MyModel{
        void doGet(String url, Class cls, Map<String, String> map, com.example.rider.model.MyModel.MyCallBack myCallBack);
        void doPost(String url, Class cls, Map<String, String> map, com.example.rider.model.MyModel.MyCallBack myCallBack);
    }
    interface MyPresenter{
        void PHomePage();
    }
    interface MyView{
        interface HomePageFragment{
            void ShowHomepage();
        }
    }
}
