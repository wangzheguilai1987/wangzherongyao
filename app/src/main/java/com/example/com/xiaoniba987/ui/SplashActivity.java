package com.example.com.xiaoniba987.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.com.xiaoniba987.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView splasha;
    private int time = 3;
    private MyHandler myHandler = new MyHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initVies();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (time == 0) {
                myHandler.removeCallbacksAndMessages(null);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            } else {
                myHandler.sendEmptyMessageDelayed(0, 1000);
            }
            time--;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeMessages(0);

        if (myHandler != null) {
            myHandler = null;
        }
    }

    private void initVies() {
        splasha = findViewById(R.id.splash);
        myHandler.sendEmptyMessage(0);
    }

}
