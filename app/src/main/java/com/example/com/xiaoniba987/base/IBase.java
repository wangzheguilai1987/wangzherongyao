package com.example.com.xiaoniba987.base;

import android.view.View;

/**
 * Created by 李小龙 on 2018/6/5.
 */

public interface IBase {
    //视图
    int getContentLayout();

    void inject();

    void initView(View view);

}
