package com.example.com.xiaoniba987.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.xiaoniba987.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImg2;
    /**
     * 注册账号
     */
    private TextView mTvZhuce;
    private ImageView mImg1;
    private EditText mName;
    private EditText mPass;
    /**
     * 登陆
     */
    private Button mBtnTijiao;
    /**
     * 忘记密码
     */
    private TextView mTvWangjimima;
    /**
     * 游客登陆
     */
    private TextView mTvYouke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg2.setOnClickListener(this);
        mTvZhuce = (TextView) findViewById(R.id.tv_zhuce);
        mTvZhuce.setOnClickListener(this);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
        mBtnTijiao = (Button) findViewById(R.id.btn_tijiao);
        mBtnTijiao.setOnClickListener(this);
        mTvWangjimima = (TextView) findViewById(R.id.tv_wangjimima);
        mTvWangjimima.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img2:
                Intent  intent=new Intent(LoginActivity.this, LoginActivity_.class);
                startActivity(intent);
                break;
            case R.id.tv_zhuce:
                break;
            case R.id.btn_tijiao:
                break;
            case R.id.tv_wangjimima:
                break;
            case R.id.tv_youke:
                break;
        }
    }
}
