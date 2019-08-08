package com.wdl.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wdl.myapplication.R;
import com.wdl.myapplication.bean.HomePageIntegralBean;

import java.util.List;

public class HomePageJiFenAdapter extends RecyclerView.Adapter<HomePageJiFenAdapter.holder> {
    private final Context context;
    private final List<HomePageIntegralBean.DataBean> integerList;

    public HomePageJiFenAdapter(Context context, List<HomePageIntegralBean.DataBean> integerList) {
        this.context = context ;
        this.integerList = integerList ;
    }

    @NonNull
    @Override
    public HomePageJiFenAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_homepage_jifen, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageJiFenAdapter.holder holder, int position) {
        String name = integerList.get(position).getTitle();
        String shop_price = integerList.get(position).getPrice();
        String img = integerList.get(position).getPic();
        holder.name.setText(name);
        holder.price.setText("￥"+shop_price);
        holder.simpleDraweeView.setImageURI(img);

    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }

    class holder extends RecyclerView.ViewHolder {

        TextView name , price ;
        SimpleDraweeView simpleDraweeView ;
        public holder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.adapter_homepage_jifen_name);
            price = itemView.findViewById(R.id.adapter_homepage_price);
            simpleDraweeView = itemView.findViewById(R.id.adapter_homepage_jifen_SimpleDraweeView);
        }
    }
}
