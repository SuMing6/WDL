package com.wdl.myapplication.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wdl.myapplication.R;
import com.wdl.myapplication.adapter.ShoppingCarAdapter;
import com.wdl.myapplication.bean.ShoppingCarBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment implements MyContract.MyView.ShoppingFragment {

    RecyclerView recyclerView ;
    TextView textView ;
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);
    List<ShoppingCarBean.DataBean> dataBeans = new ArrayList<>();
    private ShoppingCarBean shoppingCarBean;
    private ShoppingCarAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_shopping, null);
        recyclerView = view.findViewById(R.id.Shopping_RecyclerView);
        textView = view.findViewById(R.id.Shopping_text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myPresenter.PShopping_Car();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        /*adapter = new ShoppingCarAdapter(getContext(),shoppingCarBean);*/
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void ShowShoppingCar(Object o) {
        shoppingCarBean = (ShoppingCarBean) o;
        //Log.e("购物车",shoppingCarBean.getCode()+""+shoppingCarBean.getData());
        if (shoppingCarBean.getData()!=null){
            textView.setVisibility(View.GONE);
            adapter.notifyDataSetChanged();
        }else {
            textView.setVisibility(View.VISIBLE);
            //Toast.makeText(getContext(),"请先添加购物车",Toast.LENGTH_SHORT).show();
        }
    }
}
