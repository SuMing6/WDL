package com.wdl.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wdl.myapplication.R;
import com.wdl.myapplication.bean.HomePageGoodsInfoBean;
import com.wdl.myapplication.data.Port;
import com.wdl.myapplication.view.HomepageGoodsInfoActivity;

import java.util.ArrayList;
import java.util.List;

public class HomepageGoodsInfoAdapter extends RecyclerView.Adapter<HomepageGoodsInfoAdapter.holder> {
    private final Context context;
    private final HomePageGoodsInfoBean string;

    public HomepageGoodsInfoAdapter(Context context, HomePageGoodsInfoBean string) {
        this.context = context ;
        this.string = string ;
    }

    @NonNull
    @Override
    public HomepageGoodsInfoAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_homepage_goods_info_image, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageGoodsInfoAdapter.holder holder, int position) {



        holder.simpleDraweeView.setImageURI(string.getData().getPics().get(position));
    }

    @Override
    public int getItemCount() {
        return string.getData().getPics().size();
    }

    class holder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView ;
        ImageView imageView ;
        public holder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.adapter_homepage_goods_info_image_SimpleDraweeView);
            //imageView = itemView.findViewById(R.id.adapter_homepage_goods_info_image_imageview);
        }
    }
}
