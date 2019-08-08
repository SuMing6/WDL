package com.wdl.myapplication.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdl.myapplication.R;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;

public class ClassifyFragment extends Fragment implements MyContract.MyView.ClassifyFragment {

    private RecyclerView left,right;
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);

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

        myPresenter.PClassifyFragment();
    }

    @Override
    public void ShowClassifyFragment(Object o) {

    }
}
