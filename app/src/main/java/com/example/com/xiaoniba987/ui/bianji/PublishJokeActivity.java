package com.example.com.xiaoniba987.ui.bianji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_joke);
        initView();
    }

    private void initView() {
        bt_quxiao = (Button) findViewById(R.id.bt_quxiao);
        bt_fabiao = (Button) findViewById(R.id.bt_fabiao);
        ll = (LinearLayout) findViewById(R.id.ll);
        et_duanzi = (EditText) findViewById(R.id.et_duanzi);
        image_icon = (ImageView) findViewById(R.id.image_icon);
    }
}
