package com.example.com.xiaoniba987.ui.tuijian.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.bean.VideosBean;
import com.example.com.xiaoniba987.ui.HongHuYeMianActivity;
import com.example.com.xiaoniba987.ui.tuijian.presenter.TuiPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Lenovo on 2018/6/6.
 */

public class RenMenAdapter extends RecyclerView.Adapter<RenMenAdapter.RenMenHolder> {
    private String msg1;
    private String msg2;
    private String msg3;
    List<VideosBean.DataBean> data;
    Context context;
    TuiPresenter mPresenter;
    private String uid = "2797";
    private boolean flag = true;

    public RenMenAdapter(List<VideosBean.DataBean> data, Context context, TuiPresenter mPresenter, String msg1, String msg2, String msg3) {
        this.context = context;
        this.msg1 = msg1;
        this.msg2 = msg2;
        this.msg3 = msg3;
        this.data = data;
        this.mPresenter = mPresenter;
    }

    @NonNull
    @Override
    public RenMenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rement_item, null);
        RenMenHolder renMenHolder = new RenMenHolder(view);
        return renMenHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RenMenHolder holder, final int position) {
        holder.drawee_view.setImageURI(Uri.parse(data.get(position).getUser().getIcon()));
        holder.text_name.setText(data.get(position).getUser().getNickname());
        holder.text_time.setText(data.get(position).getCreateTime());
        holder.text_title.setText(data.get(position).getWorkDesc());
        holder.jcVideoPlayerStandard.TOOL_BAR_EXIST = false;
        holder.jcVideoPlayerStandard.setUp(data.get(position).getVideoUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "播放视频的标题，可以为空");
        Glide.with(context).load(data.get(position).getVideoUrl()).into(holder.jcVideoPlayerStandard.thumbImageView);
        holder.jcVideoPlayerStandard.widthRatio = 4;//播放比例
        holder.jcVideoPlayerStandard.heightRatio = 3;
        holder.drawee_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HongHuYeMianActivity.class);
                context.startActivity(intent);
            }
        });
        holder.member_send_good_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.member_send_good_1.setVisibility(View.GONE);
                holder.member_send_good_2.setVisibility(View.VISIBLE);
                mPresenter.praise(uid, String.valueOf(data.get(position).getWid()));
                Toast.makeText(context, "点赞", Toast.LENGTH_SHORT).show();
            }
        });
        holder.member_send_good_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.member_send_good_2.setVisibility(View.GONE);
                holder.member_send_good_1.setVisibility(View.VISIBLE);
                Toast.makeText(context, "已取消", Toast.LENGTH_SHORT).show();
            }
        });
        holder.image_shoucang_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.image_shoucang_1.setVisibility(View.GONE);
                holder.image_shoucang_2.setVisibility(View.VISIBLE);
                mPresenter.addFavorite(uid, String.valueOf(data.get(position).getWid()));
                Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
        holder.image_shoucang_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.image_shoucang_2.setVisibility(View.GONE);
                holder.image_shoucang_1.setVisibility(View.VISIBLE);
                mPresenter.cancelFavorite(uid, String.valueOf(data.get(position).getWid()));
                Toast.makeText(context, "已取消", Toast.LENGTH_SHORT).show();
            }
        });
        holder.image_fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    class RenMenHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView drawee_view;
        private TextView text_name;
        private TextView text_time;
        private TextView text_title;
        private JCVideoPlayerStandard jcVideoPlayerStandard;
        private ImageView member_send_good_1;
        private ImageView member_send_good_2;
        private ImageView image_shoucang_1;
        private ImageView image_shoucang_2;
        private ImageView image_fenxiang;

        public RenMenHolder(View itemView) {
            super(itemView);
            drawee_view = itemView.findViewById(R.id.drawee_view);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
            text_title = itemView.findViewById(R.id.text_title);
            jcVideoPlayerStandard = itemView.findViewById(R.id.videoplayer);
            member_send_good_1 = itemView.findViewById(R.id.member_send_good_1);
            member_send_good_2 = itemView.findViewById(R.id.member_send_good_2);
            image_shoucang_1 = itemView.findViewById(R.id.image_shoucang_1);
            image_shoucang_2 = itemView.findViewById(R.id.image_shoucang_2);
            image_fenxiang = itemView.findViewById(R.id.image_fenxiang);

        }
    }
}

