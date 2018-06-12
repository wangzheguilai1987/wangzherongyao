package com.example.com.xiaoniba987.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.xiaoniba987.R;

public class LoginActivity_ extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImg;
    private ImageView mQq;
    private ImageView mWeixin;
    private LinearLayout mLl;
    /**
     * 其他登陆方式
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mQq = (ImageView) findViewById(R.id.qq);
        mQq.setOnClickListener(this);
        mWeixin = (ImageView) findViewById(R.id.weixin);
        mWeixin.setOnClickListener(this);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.qq:
                break;
            case R.id.weixin:
                break;
            case R.id.tv:
                Intent intent = new Intent(LoginActivity_.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
