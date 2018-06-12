package com.example.com.xiaoniba987.ui.bianji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.com.xiaoniba987.R;

public class BianJiActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 取消
     */
    private Button bt_quxiao;
    private ImageView image_shipin;
    private ImageView image_duanzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bian_ji);
        initView();
    }

    private void initView() {
        bt_quxiao = (Button) findViewById(R.id.bt_quxiao);
        bt_quxiao.setOnClickListener(this);
        image_shipin = (ImageView) findViewById(R.id.image_shipin);
        image_shipin.setOnClickListener(this);
        image_duanzi = (ImageView) findViewById(R.id.image_duanzi);
        image_duanzi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_quxiao:
                finish();
                break;
            case R.id.image_shipin:
                Intent intent1 = new Intent(BianJiActivity.this, PublishVideoActivity.class);
                startActivity(intent1);
                break;
            case R.id.image_duanzi:
                Intent intent = new Intent(BianJiActivity.this, PublishJokeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
