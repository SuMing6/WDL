package com.wdl.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wdl.myapplication.R;
import com.wdl.myapplication.adapter.TalkTmAdapter;
import com.wdl.myapplication.bean.HomePageGoodsBean;
import com.wdl.myapplication.bean.TalkTmBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class TalkFragment extends Fragment implements MyContract.MyView.TalkFragment {

    XRecyclerView xRecyclerView ;
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);

    List<TalkTmBean.DataBean> goodslist = new ArrayList<>();
    private TalkTmAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_talk, null);
        xRecyclerView = view.findViewById(R.id.Talk_XRecyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        xRecyclerView.setLayoutManager(linearLayoutManager);

        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);

        adapter = new TalkTmAdapter(getActivity(),goodslist);
        xRecyclerView.setAdapter(adapter);
        adapter.setSetOnClickItem(new TalkTmAdapter.setOnClickItem() {
            @Override
            public void onGreat(int id) {
                Intent intent = new Intent(getActivity(),HomepageGoodsInfoActivity.class);
                //Log.e("图片啊",id+"");
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


        myPresenter.PTalkTm(1);
    }

    @Override
    public void ShowTalk(Object o) {
        //Toast.makeText(getContext(),"说哦"+o,Toast.LENGTH_SHORT).show();
        xRecyclerView.loadMoreComplete();
        xRecyclerView.refreshComplete();
        TalkTmBean talkTmBean = (TalkTmBean) o;
        goodslist.addAll(talkTmBean.getData());
        adapter.notifyDataSetChanged();
    }
}
