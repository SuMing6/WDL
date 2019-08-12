package com.wdl.myapplication.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wdl.myapplication.R;
import com.wdl.myapplication.bean.GetUserBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.greendao.DaoBean;/*
import com.wdl.myapplication.greendao.DaoBeanDao;*/
import com.wdl.myapplication.presenter.MyPresenter;
import com.wdl.myapplication.util.App;

import java.io.Serializable;
import java.util.List;

public class MyFragment extends Fragment implements MyContract.MyView.MyFragment {

    TextView my_shezhi ;
    RelativeLayout my_dizhi , my_shoucang , my_haoyou , my_youhui , my_qianbao , my_login ;
    private ImageView imageView ;
    private TextView text_name ;
    private String tel;
    private String headpic;
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_my, null);
        my_dizhi = view.findViewById(R.id.my_dizhi);
        my_shoucang = view.findViewById(R.id.my_shoucang);
        my_haoyou = view.findViewById(R.id.my_haoyou);
        my_youhui = view.findViewById(R.id.my_youhui);
        my_qianbao = view.findViewById(R.id.my_qianbao);
        imageView = view.findViewById(R.id.my_touxiang);
        text_name = view.findViewById(R.id.my_touname);
        my_shezhi = view.findViewById(R.id.my_shezhi);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (LogingActivity.myLoginBean.getData()!=null){
            text_name.setText(LogingActivity.myLoginBean.getData().getTel());
            imageView.setImageURI(Uri.parse(LogingActivity.myLoginBean.getData().getHeadpic()));
        }else {
            Intent intent = new Intent(getContext(),LogingActivity.class);
            startActivity(intent);
        }
        imageViewUpdata();
        //钱包
        my_qianbao();
        //优惠
        my_youhui();
        //邀请好友
        my_haoyou();
        //收藏
        my_shoucang();
        //设置
        my_shezhi();
        //地址
        my_dizhi();
    }

    private void imageViewUpdata() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void my_shoucang() {
        my_shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MyShouCangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void my_haoyou() {
        my_haoyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MyHaoYouActivity.class);
                startActivity(intent);
            }
        });
    }

    private void my_youhui() {
        my_youhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MyYouHuiActivity.class);
                startActivity(intent);
            }
        });
    }

    private void my_qianbao() {
        my_qianbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MyMoneyActivity.class);
                startActivity(intent);
            }
        });
    }

    private void my_shezhi() {
        my_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LogingActivity.myLoginBean.getData()!= null){
                    /*Intent intent = new Intent();
                    startActivity(intent);*/
                }else {
                    Toast.makeText(getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //登录
    private void my_login() {
        my_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LogingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void my_dizhi() {
        my_dizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MyDiZhiActivity.class);
                startActivity(intent);
            }
        });
    }
    //是否第一次加载
    private boolean isFirstLoading = true;

    @Override
    public void ShowMyFragment(Object o) {
        GetUserBean getUserBean = (GetUserBean) o;
        Toast.makeText(getContext(),"当前数据"+getUserBean.toString(),Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(),"当前名称"+getUserBean.getData().getTel(),Toast.LENGTH_SHORT).show();
            imageView.setImageURI(Uri.parse(getUserBean.getData().getHeadpic()));
            text_name.setText(getUserBean.getData().getTel());

    }
   /* @Override
    public void onResume() {
        super.onResume();

        if (!isFirstLoading) {
            //如果不是第一次加载，刷新数据
        }

        isFirstLoading = false;
    }*/

    @Override
    public void onResume() {
        super.onResume();

    }
}
