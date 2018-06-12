package com.example.com.xiaoniba987.ui.qutu;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.bean.VideosBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Lenovo on 2018/6/11.
 */

public class QuTuAdapter extends RecyclerView.Adapter<QuTuAdapter.QuTuHolder> {
    List<VideosBean.DataBean> data;
    Context context;

    public QuTuAdapter(List<VideosBean.DataBean> data, Context context) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public QuTuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.qutuitem, null);
        QuTuHolder renMenHolder = new QuTuHolder(view);
        return renMenHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuTuHolder holder, int position) {
        holder.drawee_view.setImageURI(Uri.parse(data.get(position).getUser().getIcon()));
        holder.text_name.setText(data.get(position).getUser().getNickname());
        holder.text_time.setText(data.get(position).getCreateTime());
        holder.text_title.setText(data.get(position).getWorkDesc());
        holder.drawee_view1.setImageURI(data.get(position).getCover());
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    class QuTuHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView drawee_view;
        private TextView text_name;
        private TextView text_time;
        private TextView text_title;
        private ImageView member_send_good;
        private ImageView image_shoucang;
        private ImageView image_fenxiang;
        private SimpleDraweeView drawee_view1;

        public QuTuHolder(View itemView) {
            super(itemView);
            drawee_view = itemView.findViewById(R.id.drawee_view);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
            text_title = itemView.findViewById(R.id.text_title);
            drawee_view1 = itemView.findViewById(R.id.drawee_view1);
            member_send_good = itemView.findViewById(R.id.member_send_good);
            image_shoucang = itemView.findViewById(R.id.image_shoucang);
            image_fenxiang = itemView.findViewById(R.id.image_fenxiang);
        }
    }
}
