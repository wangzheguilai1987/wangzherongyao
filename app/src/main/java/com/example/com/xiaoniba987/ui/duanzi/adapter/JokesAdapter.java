package com.example.com.xiaoniba987.ui.duanzi.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.bean.JokesBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * Created by Lenovo on 2018/6/6.
 */

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.JokesHolder>{
    Context context;
    List<JokesBean.DataBean> data;
    public JokesAdapter(Context context, List<JokesBean.DataBean> data) {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public JokesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.jokes_item,null);
        JokesHolder holder=new JokesHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull JokesHolder holder, int position) {
        holder.drawee_view.setImageURI(data.get(position).getUser().getIcon());
        holder.text_name.setText(data.get(position).getUser().getNickname());
        holder.text_time.setText(data.get(position).getCreateTime());
        holder.text.setText(data.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        if (data!=null) {
            return data.size();
        }
        return 0;
    }
    class JokesHolder extends RecyclerView.ViewHolder {
        private FloatingActionButton talk_item_floating_a;
        private FloatingActionButton talk_item_floating_b;
        private SimpleDraweeView drawee_view;
        private TextView text_name;
        private TextView text_time;
        private TextView text;
        public JokesHolder(View itemView) {
            super(itemView);
            drawee_view = itemView.findViewById(R.id.drawee_view);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
            talk_item_floating_a = itemView.findViewById(R.id.talk_item_floating_a);
            talk_item_floating_b = itemView.findViewById(R.id.talk_item_floating_b);
            text = itemView.findViewById(R.id.text);
        }
    }
}
