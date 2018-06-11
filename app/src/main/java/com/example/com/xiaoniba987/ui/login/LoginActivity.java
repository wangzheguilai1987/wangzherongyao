package com.example.com.xiaoniba987.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseActivity;
import com.example.com.xiaoniba987.bean.UserBean;
import com.example.com.xiaoniba987.httpcompoter.DaggerHttpComponent;
import com.example.com.xiaoniba987.ui.MainActivity;
import com.example.com.xiaoniba987.ui.login.contract.LoginContract;
import com.example.com.xiaoniba987.ui.login.presenter.LoginPresenter;
import com.example.com.xiaoniba987.ui.login_zhuce.LoginActiviti_1;
import com.example.com.xiaoniba987.utils.SharedPreferencesUtils;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View, View.OnClickListener {

    private ImageView mImg2;
    private TextView mTvZhuce;
    private ImageView mImg1;
    private EditText mName;
    private EditText mPass;
    private Button mBtnTijiao;
    private TextView mTvWangjimima;
    private TextView mTvYouke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

    }

    //获取组件
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

    @Override//点击事件
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img2:
                Intent intent = new Intent(LoginActivity.this, LoginActivity_.class);
                startActivity(intent);
                break;
            case R.id.tv_zhuce:
                Intent intent1 = new Intent(LoginActivity.this, LoginActiviti_1.class);
                startActivityForResult(intent1, 1);
                break;
            case R.id.btn_tijiao:
                String mobile = mName.getText().toString();
                String password = mPass.getText().toString();
                Log.d("哈哈", "onClick: " + mobile + "  " + password);
                mPresenter.login(mobile, password);
                break;
            case R.id.tv_wangjimima:
                break;
            case R.id.tv_youke:
                break;
        }
    }

    @Override//布局
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override//注入
    public void inject() {
        DaggerHttpComponent
                .builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {

    }

    @Override//成功回调的方法
    public void loginSuccess(UserBean userBean) {
        Log.d("xxxxxxxxxxxxx", userBean.getMsg());
        Toast.makeText(LoginActivity.this,userBean.getMsg()+"",Toast.LENGTH_SHORT).show();

        if (userBean.getCode().equals("0")) {
            SharedPreferencesUtils.setParam(LoginActivity.this, "uid", userBean.getData().getUid() + "");
            SharedPreferencesUtils.setParam(LoginActivity.this, "name", userBean.getData().getUsername() + "");
            SharedPreferencesUtils.setParam(LoginActivity.this, "iconUrl", userBean.getData().getIcon() + "");
            SharedPreferencesUtils.setParam(LoginActivity.this, "token", userBean.getData().getToken() + "");
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void loginError(String err) {
        Log.d("哈哈", "loginError: " + err);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            String mobile1 = data.getStringExtra("mobile");
            String password1 = data.getStringExtra("password");
            mName.setText(mobile1);
            mPass.setText(password1);
        }
    }
}
