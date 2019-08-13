package com.wdl.myapplication.oderall;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdl.myapplication.R;
import com.wdl.myapplication.activity.OrderAllActivity;
import com.wdl.myapplication.bean.MyOrderFkBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;

public class OderAllFKFragment extends Fragment implements MyContract.MyView.OderAllFKFragment {

    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_all_fk, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myPresenter.PMyOderFk(0);

    }

    @Override
    public void ShowMyOderFk(Object o) {
        MyOrderFkBean myOrderFkBean = (MyOrderFkBean) o;
        Log.e("订单状态",myOrderFkBean.getCode()+"-"+myOrderFkBean.getData());
    }
}
