package com.example.com.xiaoniba987.base;

/**
 * Created by 李小龙 on 2018/6/5.
 */

import android.view.View;

public interface IBase {
    //视图
    int getContentLayout();
    void  inject();
    void initView(View view);

}
