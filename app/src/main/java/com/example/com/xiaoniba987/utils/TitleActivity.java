package com.example.com.xiaoniba987.utils;

/**
 * Created by 李小龙 on 2018/6/5.
 */

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.xiaoniba987.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class TitleActivity extends LinearLayout {
    public TitleActivity(Context context) {
        this(context,null);
    }

    public TitleActivity(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleActivity(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview(context);
    }
    //1定义一个接口
    public interface OnItemTitleClickListener{
        void onClickleft(View v);
        void onClickrigth(View v);

    }
    private OnItemTitleClickListener onItemTitleClickListener;
    public void setOnItemTitleClickListener(OnItemTitleClickListener onItemTitleClickListener){
        this.onItemTitleClickListener=onItemTitleClickListener;

    }
    private void initview(Context context) {
        View view = View.inflate(context, R.layout.title_item, this);
        SimpleDraweeView sdv = view.findViewById(R.id.sdv);
        TextView tv_title = view.findViewById(R.id.tv_title);
        SimpleDraweeView xie = view.findViewById(R.id.xie);
        sdv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemTitleClickListener.onClickleft(v);
            }
        });
        xie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemTitleClickListener.onClickrigth(v);
            }
        });
    }
}
