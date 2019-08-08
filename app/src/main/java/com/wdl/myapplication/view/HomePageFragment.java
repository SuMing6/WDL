package com.wdl.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wdl.myapplication.R;
import com.wdl.myapplication.commonality.SpacingItemDecoration;
import com.wdl.myapplication.adapter.HomePageJiFenAdapter;
import com.wdl.myapplication.adapter.HomePagetuijAdapter;
import com.wdl.myapplication.bean.HomePageBanderBean;
import com.wdl.myapplication.bean.HomePageGoodsBean;
import com.wdl.myapplication.bean.HomePageIntegralBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment implements MyContract.MyView.HomePageActivity {

    private Banner banner;
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);
    List<HomePageBanderBean.DataBean> list = new ArrayList<>();
    List<String> integerList = new ArrayList<String>();
    private RecyclerView jifen_xRecyclerView;
    private XRecyclerView recommend_xRecyclerView;
    List<HomePageIntegralBean.DataBean> Integrallist = new ArrayList<>();
    private HomePageJiFenAdapter jifenadapter;
    List<HomePageGoodsBean.DataBean> goodslist = new ArrayList<>();
    private HomePagetuijAdapter tuijadapter;
    private NestedScrollView scrollView;
    private EditText editText;
    private TextView SYS ;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_homepage, null);
        banner = view.findViewById(R.id.homepage_Banner);
        jifen_xRecyclerView = view.findViewById(R.id.homepage_jifen_XRecyclerView);
        recommend_xRecyclerView = view.findViewById(R.id.homepage_recommend_XRecyclerView);
        scrollView = view.findViewById(R.id.homepage_ScrollView);
        editText = view.findViewById(R.id.homepage_EditText);
        SYS = view.findViewById(R.id.homepage_SYS);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editText.setFocusable(false);

        myPresenter.PHomePageBander();

        SYS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //积分商城
        jifen_xRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        myPresenter.PHomePageIntegral();
        jifenadapter = new HomePageJiFenAdapter(getActivity(),Integrallist);
        jifen_xRecyclerView.setAdapter(jifenadapter);

        //为您推荐
        recommend_xRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recommend_xRecyclerView.setPullRefreshEnabled(true);
        recommend_xRecyclerView.setLoadingMoreEnabled(true);
        myPresenter.PHomePageGoods();



        tuijadapter = new HomePagetuijAdapter(getActivity(),goodslist);
        recommend_xRecyclerView.setAdapter(tuijadapter);
        int pixelSize = getResources().getDimensionPixelSize(R.dimen.dp_20);
        recommend_xRecyclerView.addItemDecoration(new SpacingItemDecoration(pixelSize));

        /*//解决滑动冲突
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            int page = 0 ;
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    //底部加载
                    page++;
                    myPresenter.PHomePageGoods();
                }
            }

        });*/

        editText.clearFocus();
        //输入框获取焦点
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
            }
        });

        /*//点击详情页面
        tuijadapter.setSetOnClickItem(new HomePagetuijAdapter.setOnClickItem() {
            @Override
            public void onGreat(int id) {
                Intent intent = new Intent(getActivity(),HomepageGoodsInfoActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });*/

    }
    //轮播
    @Override
    public void ShowBander(Object o) {
        HomePageBanderBean homePageBanderBean = (HomePageBanderBean) o;
        //Log.e("数据v",o.toString());
        list.addAll(homePageBanderBean.getData());
        for (int i = 0; i < list.size(); i++) {
            integerList.add(list.get(i).getPic());
        }
        //Log.e("轮播图",integerList.toString());
        banner.isAutoPlay(true).setDelayTime(1000).setImages(integerList).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
    }
    //数据
    @Override
    public void ShowIntegral(Object o) {
        //Log.e("数据vv",o.toString());
        HomePageIntegralBean homePageIntegralBean = (HomePageIntegralBean) o;
        Integrallist.addAll(homePageIntegralBean.getData());

        jifenadapter.notifyDataSetChanged();
    }
    //为您推荐
    @Override
    public void ShowGoods(Object o) {
        recommend_xRecyclerView.loadMoreComplete();
        recommend_xRecyclerView.refreshComplete();
        HomePageGoodsBean homePageGoodsBean = (HomePageGoodsBean) o;
        goodslist.addAll(homePageGoodsBean.getData());
        tuijadapter.notifyDataSetChanged();

    }


}
