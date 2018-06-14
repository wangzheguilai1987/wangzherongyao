package com.example.com.xiaoniba987.ui.bianji;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.com.xiaoniba987.R;

public class PublishJokeActivity extends AppCompatActivity {

    /**
     * 取消
     */
    private Button bt_quxiao;
    /**
     * 发表
     */
    private Button bt_fabiao;
    private LinearLayout ll;
    /**
     * 请输入内容，禁止输入色情，暴力等违反国家的内容，违法者以封号处理！
     */
    private EditText et_duanzi;
    private ImageView image_icon;
    private PopupWindow pop;
    private LinearLayout ll_popup;
    private View parentView;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentView = getLayoutInflater().inflate(R.layout.activity_publish_joke, null);
        setContentView(parentView);
        initView();

    }

    private void initView() {
        bt_quxiao = (Button) findViewById(R.id.bt_quxiao);
        bt_fabiao = (Button) findViewById(R.id.bt_fabiao);
        ll = (LinearLayout) findViewById(R.id.ll);
        et_duanzi = (EditText) findViewById(R.id.et_duanzi);
        image_icon = (ImageView) findViewById(R.id.image_icon);
        content = et_duanzi.getText().toString().trim();
        bt_fabiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PublishJokeActivity.this, PublishActivity.class);
                intent.putExtra("content",content);
                startActivity(intent);
            }
        });

        bt_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitPopWindow();
                pop.showAtLocation(ll, Gravity.BOTTOM, 0, 0);
            }
        });

    }
    private void InitPopWindow() {
        pop = new PopupWindow(PublishJokeActivity.this);

        View view = getLayoutInflater().inflate(R.layout.popwindow_layout, null);

        ll_popup = (LinearLayout) view.findViewById(R.id.ll_popup);

        pop.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        pop.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setContentView(view);

        RelativeLayout parent = (RelativeLayout) view.findViewById(R.id.parent);
        Button bt1 = (Button) view
                .findViewById(R.id.item_baocun);
        Button bt2 = (Button) view
                .findViewById(R.id.item_bubaocun);
        Button bt3 = (Button) view
                .findViewById(R.id.item_cancel);
        parent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pop.dismiss();
                ll_popup.clearAnimation();
                finish();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pop.dismiss();
                ll_popup.clearAnimation();
                finish();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pop.dismiss();
                ll_popup.clearAnimation();
                finish();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pop.dismiss();
                ll_popup.clearAnimation();
                finish();
            }
        });
    }
}
