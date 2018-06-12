package com.example.com.xiaoniba987.ui.shipin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.bean.HotVideosBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Lenovo on 2018/6/7.
 */

public class RenMenShiPinAdapter extends RecyclerView.Adapter<RenMenShiPinAdapter.RenMenShiPinHolder> {
    List<HotVideosBean.DataBean> data;
    Context context;
    private Listeners listeners;

    public RenMenShiPinAdapter(List<HotVideosBean.DataBean> data, Context context) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RenMenShiPinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.remenshipin_item, null);
        RenMenShiPinHolder holder = new RenMenShiPinHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull RenMenShiPinHolder holder, final int position) {
        holder.draweeView.setImageURI(data.get(position).getCover());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listeners.setOnClickListeners(position);
            }
        });
    }

    public void setOnClickListeners(Listeners listeners) {
        this.listeners = listeners;
    }

    public interface Listeners {

        void setOnClickListeners(int position);
    }

    class RenMenShiPinHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView draweeView;

        public RenMenShiPinHolder(View itemView) {
            super(itemView);
            draweeView = itemView.findViewById(R.id.drawee_view);
        }
    }
}
