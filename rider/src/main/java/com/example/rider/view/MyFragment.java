package com.example.rider.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.rider.R;
import com.example.rider.activity.AddressActivity;
import com.example.rider.activity.MoneyActivity;
import com.example.rider.activity.PhoneActivity;
import com.example.rider.activity.SMRZActivity;

public class MyFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //我的钱包
        Money();
        //我的地址
        Address();
        //我的手机号
        Phone();
        //实名制认证
        SMZ();

    }

    private void SMZ() {
        RelativeLayout my_SMZ = view.findViewById(R.id.my_SMZ);
        my_SMZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实名制认证
                Intent intent = new Intent(getContext(), SMRZActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Phone() {
        RelativeLayout my_phone = view.findViewById(R.id.my_phone);
        my_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //我的手机号
                Intent intent = new Intent(getContext(), PhoneActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Address() {
        RelativeLayout my_dizhi = view.findViewById(R.id.my_dizhi);
        my_dizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //我的住址
                Intent intent = new Intent(getContext(), AddressActivity.class);
                startActivity(intent);
            }
        });

    }

    private void Money() {
        RelativeLayout my_qianbao = view.findViewById(R.id.my_qianbao);
        my_qianbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //我的钱包
                Intent intent = new Intent(getContext(), MoneyActivity.class);
                startActivity(intent);
            }
        });
    }
}
