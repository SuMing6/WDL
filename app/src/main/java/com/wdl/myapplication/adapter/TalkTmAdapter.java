package com.wdl.myapplication.adapter;

import android.content.Context;
import android.graphics.Paint;
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
import com.wdl.myapplication.bean.TalkTmBean;

import java.util.List;

public class TalkTmAdapter extends RecyclerView.Adapter<TalkTmAdapter.holder> {
    private final Context context;
    private final List<TalkTmBean.DataBean> goodslist;
    TalkTmAdapter.setOnClickItem setOnClickItem;

    public TalkTmAdapter(Context context, List<TalkTmBean.DataBean> goodslist) {
        this.context = context ;
        this.goodslist = goodslist ;
    }

    @NonNull
    @Override
    public TalkTmAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_talk_tm, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TalkTmAdapter.holder holder, final int position) {

        String img = goodslist.get(position).getPic();
        String market_price = goodslist.get(position).getPrice_old();
        String name = goodslist.get(position).getTitle();
        String shop_price = goodslist.get(position).getPrice();

        holder.simpleDraweeView.setImageURI(img);
        holder.name.setText(name);
        holder.price.setText("￥"+goodslist.get(position).getPrice_old());
        holder.shouhou.setText("已售 "+market_price);
        holder.price_old.setText("￥"+shop_price);
        holder.price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);

        //点击事件
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickItem.onGreat(goodslist.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodslist.size();
    }
    //点击事件，接口回调
    public void setSetOnClickItem(setOnClickItem item){
        setOnClickItem = item;
    }
    public interface setOnClickItem{
        void onGreat(int id);
    }

    class holder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView ;
        TextView name , price ,shouhou,price_old;
        RelativeLayout relativeLayout ;

        public holder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.adapter_Talk_tm_RelativeLayout);
            simpleDraweeView = itemView.findViewById(R.id.adapter_Talk_tm_SimpleDraweeView);
            name = itemView.findViewById(R.id.adapter_Talk_tm_name);
            price = itemView.findViewById(R.id.adapter_Talk_tm_price);
            shouhou = itemView.findViewById(R.id.adapter_Talk_tm_shouhou);
            price_old = itemView.findViewById(R.id.adapter_Talk_tm_price_old);
        }
    }
}
