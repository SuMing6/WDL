package com.wdl.myapplication.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdl.myapplication.R;
import com.wdl.myapplication.adapter.ShoppingCarAdapter;
import com.wdl.myapplication.bean.ShoppingCarBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment implements MyContract.MyView.ShoppingFragment {

    RecyclerView recyclerView ;
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);
    List<ShoppingCarBean.DataBean> dataBeans = new ArrayList<>();
    private ShoppingCarAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_shopping, null);
        recyclerView = view.findViewById(R.id.Shopping_RecyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        myPresenter.PShopping_Car();

        adapter = new ShoppingCarAdapter(getActivity(),dataBeans);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void ShowShoppingCar(Object o) {
        ShoppingCarBean shoppingCarBean = (ShoppingCarBean) o;
        if (shoppingCarBean.getCode()==0){
            dataBeans.addAll(shoppingCarBean.getData());
            adapter.notifyDataSetChanged();
        }
    }
}
