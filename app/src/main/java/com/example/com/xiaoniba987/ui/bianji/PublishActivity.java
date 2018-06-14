package com.example.com.xiaoniba987.ui.bianji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.ui.duanzi.JokeDetailActivity;

public class PublishActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linear1;
    private LinearLayout linear2;
    /**
     * 前去查看!!
     */
    private Button bt_chakan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        initView();
    }

    private void initView() {
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        bt_chakan = (Button) findViewById(R.id.bt_chakan);
        bt_chakan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_chakan:
                finish();
                break;
        }
    }
}
