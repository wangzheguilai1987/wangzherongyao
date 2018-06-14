package com.example.com.xiaoniba987.ui.shipin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseActivity;
import com.example.com.xiaoniba987.bean.VideoDetailBean;
import com.example.com.xiaoniba987.httpcompoter.DaggerHttpComponent;
import com.example.com.xiaoniba987.ui.celakuang.My_GuanZhu;
import com.example.com.xiaoniba987.ui.shipin.contract.VideoDetailContract;
import com.example.com.xiaoniba987.ui.shipin.presenter.VideoDetailPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoDetailActivity extends BaseActivity<VideoDetailPresenter> implements VideoDetailContract.View {
    private int wid;
    private ImageView image_back;
    private ImageView image_quxiao_1;
    private ImageView image_quxiao_2;
    private ImageView image_shoucang_1;
    private ImageView image_shoucang_2;
    private ImageView image_fenxiang;
    private SimpleDraweeView drawee_view;
    private JCVideoPlayerStandard videoplayer;
    private ImageView ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        wid = getIntent().getIntExtra("wid", 0);
        mPresenter.getVideoDetail(wid + "");
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    private void initView() {
        image_back = (ImageView) findViewById(R.id.image_back);
        image_quxiao_1 = (ImageView) findViewById(R.id.image_quxiao_1);
        image_quxiao_2 = (ImageView) findViewById(R.id.image_quxiao_2);
        image_shoucang_1 = (ImageView) findViewById(R.id.image_shoucang_1);
        image_shoucang_2 = (ImageView) findViewById(R.id.image_shoucang_2);
        image_fenxiang = (ImageView) findViewById(R.id.image_fenxiang);
        drawee_view = (SimpleDraweeView) findViewById(R.id.drawee_view);
        videoplayer = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        ll = (ImageView) findViewById(R.id.ll);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        drawee_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoDetailActivity.this, My_GuanZhu.class);
                startActivity(intent);
            }
        });
        image_quxiao_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_quxiao_1.setVisibility(View.GONE);
                image_quxiao_2.setVisibility(View.VISIBLE);
            }
        });
        image_quxiao_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_quxiao_2.setVisibility(View.GONE);
                image_quxiao_1.setVisibility(View.VISIBLE);
            }
        });
        image_shoucang_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_shoucang_1.setVisibility(View.GONE);
                image_shoucang_2.setVisibility(View.VISIBLE);
            }
        });
        image_shoucang_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_shoucang_2.setVisibility(View.GONE);
                image_shoucang_1.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public void getVideoDetailSuccess(VideoDetailBean videoDetailBean) {
        if (videoDetailBean != null) {
            VideoDetailBean.DataBean data = videoDetailBean.getData();
            Log.e("sss", data.getCover());
            drawee_view.setImageURI(data.getUser().getIcon());
            JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
            jcVideoPlayerStandard.TOOL_BAR_EXIST = false;
            jcVideoPlayerStandard.setUp(data.getVideoUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "播放视频的标题，可以为空");
            Glide.with(getApplicationContext()).load(data.getVideoUrl()).into(jcVideoPlayerStandard.thumbImageView);
            jcVideoPlayerStandard.widthRatio = 4;//播放比例
            jcVideoPlayerStandard.heightRatio = 3;

        }
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
