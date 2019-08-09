package com.wdl.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wdl.myapplication.R;
import com.wdl.myapplication.bean.HomePageHotBean;

import java.util.List;

public class HomePageHotAdapter extends RecyclerView.Adapter<HomePageHotAdapter.holder> {
    private final Context context;
    private final List<HomePageHotBean.DataBean> hotlist;
    HomePagetuijAdapter.setOnClickItem setOnClickItem;

    public HomePageHotAdapter(Context context, List<HomePageHotBean.DataBean> hotlist) {
        this.context = context ;
        this.hotlist = hotlist ;
    }

    @NonNull
    @Override
    public HomePageHotAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_homepage_hot, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageHotAdapter.holder holder, final int position) {
        holder.simpleDraweeView.setImageURI(hotlist.get(position).getPic());
        holder.name.setText(hotlist.get(position).getTitle());
        holder.pop.setText(hotlist.get(position).getSku());
        holder.price.setText(hotlist.get(position).getPrice());
        holder.priceold.setText(hotlist.get(position).getPrice_old());

        //点击事件
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickItem.onGreat(hotlist.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotlist.size();
    }

    //点击事件，接口回调
    public void setSetOnClickItem(HomePagetuijAdapter.setOnClickItem item){
        setOnClickItem = item;
    }
    public interface setOnClickItem{
        void onGreat(int id);
    }

    class holder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView ;
        TextView name , pop , price , priceold ;
        RelativeLayout relativeLayout ;
        public holder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.adapter_homepage_hot_SimpleDraweeView);
            name = itemView.findViewById(R.id.adapter_homepage_hot_name);
            pop = itemView.findViewById(R.id.adapter_homepage_hot_pop);
            price = itemView.findViewById(R.id.adapter_homepage_hot_price);
            priceold = itemView.findViewById(R.id.adapter_homepage_hot_priceold);
            relativeLayout = itemView.findViewById(R.id.adapter_homepage_hot_RelativeLayout);
        }
    }
}
