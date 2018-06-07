package com.example.com.xiaoniba987.ui.login_zhuce;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.xiaoniba987.ui.MainActivity;
import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseActivity;
import com.example.com.xiaoniba987.bean.UserRegisterBean;
import com.example.com.xiaoniba987.httpcompoter.DaggerHttpComponent;
import com.example.com.xiaoniba987.module.HttpModule;
import com.example.com.xiaoniba987.ui.login.LoginActivity;
import com.example.com.xiaoniba987.ui.login_zhuce.contract.LoginZhuceContract;
import com.example.com.xiaoniba987.ui.login_zhuce.presenter.LoginZhucePresenter;

public class LoginActiviti_1 extends BaseActivity<LoginZhucePresenter> implements LoginZhuceContract.View,View.OnClickListener {

    private ImageView mImg2;
    private TextView mTvWangji;
    private ImageView mImg1;
    private EditText mEtName;
    private EditText mEtPass;
    private Button mBtnZhuce;
    private TextView mTvYouke;
    private String mobile;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    //获取组件
    private void initView() {
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg2.setOnClickListener(this);
        mTvWangji = (TextView) findViewById(R.id.tv_wangji);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mImg1.setOnClickListener(this);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPass = (EditText) findViewById(R.id.et_pass);
        mBtnZhuce = (Button) findViewById(R.id.btn_zhuce);
        mBtnZhuce.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
    }

    @Override//点击事件
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img2:
                Intent intent = new Intent(LoginActiviti_1.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.img1:
                break;
            case R.id.btn_zhuce:
                mobile = mEtName.getText().toString();
                password = mEtPass.getText().toString();
                mPresenter.login_zhuce(mobile, password);

                break;
            case R.id.tv_youke:
                Intent intent1=new Intent(LoginActiviti_1.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override//布局
    public int getContentLayout() {
        return R.layout.activity_login_activiti_1;
    }

    @Override//注入
    public void inject() {
        DaggerHttpComponent
                .builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override//成功回调方法
    public void loginSuccess_zhuce(UserRegisterBean userRegisterBean) {
        Log.d("aaaaaaaaa",userRegisterBean.getCode()+"");

        Toast.makeText(LoginActiviti_1.this, userRegisterBean.getMsg(), Toast.LENGTH_SHORT).show();
        if (userRegisterBean.getCode().equals("0")){
            Intent intent = getIntent();
            intent.putExtra("mobile", mobile);
            intent.putExtra("password",password);
            setResult(1, intent);
            finish();
        }
    }
}
