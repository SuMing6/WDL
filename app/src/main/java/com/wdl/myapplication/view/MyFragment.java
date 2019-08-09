package com.wdl.myapplication.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wdl.myapplication.R;

import java.io.Serializable;

public class MyFragment extends Fragment implements Serializable {

    RelativeLayout my_dizhi , my_shoucang , my_haoyou , my_youhui , my_qianbao , my_login ;
    ImageView imageView ;
    TextView text_name ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_my, null);
        my_dizhi = view.findViewById(R.id.my_dizhi);
        my_shoucang = view.findViewById(R.id.my_shoucang);
        my_haoyou = view.findViewById(R.id.my_haoyou);
        my_youhui = view.findViewById(R.id.my_youhui);
        my_qianbao = view.findViewById(R.id.my_qianbao);
        my_login = view.findViewById(R.id.my_login);
        imageView = view.findViewById(R.id.my_touxiang);
        text_name = view.findViewById(R.id.my_touname);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //地址
        //imageView.setImageURI(Uri.parse(LogingActivity.myLoginBean.getData().getHeadpic()));
        //if (LogingActivity.myLoginBean.getData().getNick()!= null){
            //text_name.setText(LogingActivity.myLoginBean.getData().getNick());
        //}
        my_dizhi();
        my_login();
    }
    //登录
    private void my_login() {
        my_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LogingPwdActivity.class);
                startActivity(intent);
            }
        });
    }

    private void my_dizhi() {

    }
}
