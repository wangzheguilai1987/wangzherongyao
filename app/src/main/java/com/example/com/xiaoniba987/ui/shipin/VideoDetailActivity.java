package com.example.com.xiaoniba987.ui.shipin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoDetailActivity extends BaseActivity implements View.OnClickListener {

    private ImageView image_back;
    private ImageView image_shoucang;
    private ImageView image_quxiao;
    private ImageView image_fenxiang;
    //**************************************
    private SimpleDraweeView drawee_view;
    private JCVideoPlayerStandard videoplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {

        image_back = (ImageView) findViewById(R.id.image_back);
        image_back.setOnClickListener(this);
        image_shoucang = (ImageView) findViewById(R.id.image_shoucang);
        image_shoucang.setOnClickListener(this);
        image_quxiao = (ImageView) findViewById(R.id.image_quxiao);
        image_quxiao.setOnClickListener(this);
        image_fenxiang = (ImageView) findViewById(R.id.image_fenxiang);
        image_fenxiang.setOnClickListener(this);
        drawee_view = (SimpleDraweeView) findViewById(R.id.drawee_view);
        videoplayer = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.image_back:
                break;
            case R.id.image_shoucang:
                break;
            case R.id.image_quxiao:
                break;
            case R.id.image_fenxiang:
                break;
        }
    }
}
