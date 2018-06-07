package com.example.com.xiaoniba987.ui.tuijian.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.bean.VideosBean;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Lenovo on 2018/6/6.
 */

public class RenMenAdapter extends RecyclerView.Adapter<RenMenAdapter.RenMenHolder>{
    List<VideosBean.DataBean> data;
    Context context;
    public RenMenAdapter(List<VideosBean.DataBean> data, Context context) {
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public RenMenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= View.inflate(context, R.layout.rement_item,null);
        RenMenHolder renMenHolder = new RenMenHolder(view);
        return renMenHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RenMenHolder holder, int position) {
        holder.drawee_view.setImageURI(Uri.parse(data.get(position).getUser().getIcon()));
        holder.text_name.setText(data.get(position).getUser().getNickname());
        holder.text_time.setText(data.get(position).getCreateTime());
        holder.text_title.setText(data.get(position).getWorkDesc());
        holder.jcVideoPlayerStandard.TOOL_BAR_EXIST = false;
        holder.jcVideoPlayerStandard.setUp(data.get(position).getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "播放视频的标题，可以为空");

        Glide.with(context).load(data.get(position).getVideoUrl())
                .into( holder.jcVideoPlayerStandard.thumbImageView);
        holder.jcVideoPlayerStandard.widthRatio = 4;//播放比例
        holder.jcVideoPlayerStandard.heightRatio = 3;
    }


    @Override
    public int getItemCount() {
        if (data!=null) {
            return data.size();
        }
        return 0;
    }

    class RenMenHolder extends RecyclerView.ViewHolder {
        private FloatingActionButton talk_item_floating_a;
        private FloatingActionButton talk_item_floating_b;
        private SimpleDraweeView drawee_view;
        private TextView text_name;
        private TextView text_time;
        private TextView text_title;
        private JCVideoPlayerStandard jcVideoPlayerStandard;

        public RenMenHolder(View itemView) {
            super(itemView);
            drawee_view = itemView.findViewById(R.id.drawee_view);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
            talk_item_floating_a = itemView.findViewById(R.id.talk_item_floating_a);
            talk_item_floating_b = itemView.findViewById(R.id.talk_item_floating_b);
            text_title = itemView.findViewById(R.id.text_title);
            jcVideoPlayerStandard = itemView.findViewById(R.id.videoplayer);
        }
    }
}

