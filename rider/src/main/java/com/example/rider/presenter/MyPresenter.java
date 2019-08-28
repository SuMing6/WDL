package com.example.rider.presenter;

import com.example.rider.contract.MyContract;
import com.example.rider.model.MyModel;

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

    @Override
    public void PHomePage() {

    }
}
