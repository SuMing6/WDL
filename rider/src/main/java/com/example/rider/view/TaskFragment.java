package com.example.rider.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rider.R;
import com.example.rider.adapter.TaskPagerAdapter;

import java.util.ArrayList;

public class TaskFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task,null);

        tabLayout = view.findViewById(R.id.my_task_TabLayout);
        viewPager = view.findViewById(R.id.my_task_ViewPager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        ArrayList<String> list_Title = new ArrayList<>();
        fragmentList.add(new TaskPickFragment());
        fragmentList.add(new TaskDeliveryFragment());
        fragmentList.add(new TaskOverFragment());
        list_Title.add("待取货");
        list_Title.add("配送中");
        list_Title.add("已完成");

        viewPager.setAdapter(new TaskPagerAdapter(getChildFragmentManager(),getActivity(),fragmentList,list_Title));
        tabLayout.setupWithViewPager(viewPager);//此方法就是让tablayout和ViewPager联动

    }
}
