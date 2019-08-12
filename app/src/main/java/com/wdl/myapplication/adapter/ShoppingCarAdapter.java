package com.wdl.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wdl.myapplication.R;
import com.wdl.myapplication.bean.ShoppingCarBean;

import java.util.List;

public class ShoppingCarAdapter extends RecyclerView.Adapter<ShoppingCarAdapter.holder> {
    private final Context context;
    private final ShoppingCarBean dataBeans;

    public ShoppingCarAdapter(Context context, ShoppingCarBean dataBeans) {
        this.context = context ;
        this.dataBeans = dataBeans ;
    }

    @NonNull
    @Override
    public ShoppingCarAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_shopping_car, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCarAdapter.holder holder, int position) {

        //holder.name.setText(dataBeans.get(position).getChanpin().getTitle());
        holder.guige.setText(dataBeans.getData().get(position).getGuige().getName());
        holder.price.setText(dataBeans.getData().get(position).getPrice());
        holder.simpleDraweeView.setImageURI(dataBeans.getData().get(position).getChanpin().getPic());
    }

    @Override
    public int getItemCount() {
        return dataBeans.getData().size();
    }

    class holder extends RecyclerView.ViewHolder {
        RadioButton radioButton ;
        SimpleDraweeView simpleDraweeView ;
        TextView name , guige , price ;
        public holder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Shopping_car_name);
            guige = itemView.findViewById(R.id.Shopping_car_guige);
            price = itemView.findViewById(R.id.Shopping_car_price);
            radioButton = itemView.findViewById(R.id.Shopping_car_Radio);
            simpleDraweeView = itemView.findViewById(R.id.Shopping_car_SimpleDraweeView);
        }
    }
}
