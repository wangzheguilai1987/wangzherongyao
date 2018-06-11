package com.example.com.xiaoniba987.base;

/**
 * Created by 李小龙 on 2018/6/5.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;


                                                                          //视图     抽取的公共方法
public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase,BaseContract.BaseView{

    @Inject  //不能忘
    protected T mPresenter;

    @Override//绑定
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        inject();

        //绑定
        if (mPresenter!=null) {
            mPresenter.attchView(this);
        }
    }

  @Override
  public void initView(View view) {

  }

  @Override//解绑
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        mPresenter.detachView();
    }

    @Override//显示进度条
    public void showLoading() {

    }

    @Override//关闭进度条
    public void dismissLoading() {

    }
}
