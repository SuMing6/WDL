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

import com.wdl.myapplication.R;
import com.wdl.myapplication.adapter.ClassifyAdapter;
import com.wdl.myapplication.bean.ClassifyBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class ClassifyFragment extends Fragment implements MyContract.MyView.ClassifyFragment {

    TextView left ;
    private RecyclerView right;
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);
    List<ClassifyBean.DataBean> dataBeans = new ArrayList<>();
    private ClassifyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_classify, null);
        left = view.findViewById(R.id.Classify_left);
        right = view.findViewById(R.id.Classify_right);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myPresenter.PClassifyFragment(0);

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),3);
        right.setLayoutManager(linearLayoutManager);

        adapter = new ClassifyAdapter(getActivity(),dataBeans);
        right.setAdapter(adapter);

    }

    @Override
    public void ShowClassifyFragment(Object o) {
        ClassifyBean classifyBean = (ClassifyBean) o;
        dataBeans.addAll(classifyBean.getData());
        //Log.e("啊啊啊啊",classifyBean.getData()+"");
        adapter.notifyDataSetChanged();
        for (int i = 0; i < classifyBean.getData().size(); i++) {
            left.setText(classifyBean.getData().get(i).getName());
        }
    }
}
