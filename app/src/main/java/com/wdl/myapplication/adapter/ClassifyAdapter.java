package com.wdl.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wdl.myapplication.R;
import com.wdl.myapplication.bean.ClassifyBean;

import java.util.List;

public class ClassifyAdapter extends RecyclerView.Adapter<ClassifyAdapter.holder> {

    private final Context context;
    private final List<ClassifyBean.DataBean> dataBeans;

    public ClassifyAdapter(Context context, List<ClassifyBean.DataBean> dataBeans) {
        this.context = context ;
        this.dataBeans = dataBeans ;
    }

    @NonNull
    @Override
    public ClassifyAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_classif, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassifyAdapter.holder holder, int position) {
        holder.textView.setText(dataBeans.get(position).getName());
        holder.simpleDraweeView.setImageURI(dataBeans.get(position).getPic());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class holder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView;
        TextView textView ;
        public holder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.adapter_classify_SimpleDraweeView);
            textView = itemView.findViewById(R.id.adapter_classify_name);

        }
    }
}
