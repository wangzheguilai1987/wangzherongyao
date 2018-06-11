package com.example.com.xiaoniba987.ui.duanzi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseActivity;
import com.example.com.xiaoniba987.bean.JokeDetailBean;
import com.example.com.xiaoniba987.httpcompoter.DaggerHttpComponent;
import com.example.com.xiaoniba987.ui.duanzi.contract.JokeDetailContract;
import com.example.com.xiaoniba987.ui.duanzi.presenter.JokeDetailPresenter;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class JokeDetailActivity extends BaseActivity<JokeDetailPresenter> implements View.OnClickListener,JokeDetailContract.View {

    private ImageView drawee_view;
    /**
     * 牛奶
     */
    private TextView text_name;
    /**
     * 2000000.00
     */
    private TextView text_time;
    private FloatingActionButton talk_item_floating_a;
    private FloatingActionButton talk_item_floating_b;
    private FloatingActionButton talk_item_floating_xihuan;
    private FloatingActionsMenu talk_item_floating;
    /**
     * 天气妹妹
     */
    private TextView text_title;
    private ImageView drawee_view1;
    private ImageView image_back;
    private int jid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        jid = getIntent().getIntExtra("jid", -1);
        if (jid!=-1) {
            mPresenter.getJokeDetail(jid + "");
        }

    }
    @Override
    public int getContentLayout() {
        return R.layout.activity_joke_detail;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    private void initView() {
        drawee_view = (ImageView) findViewById(R.id.drawee_view);
        text_name = (TextView) findViewById(R.id.text_name);
        text_time = (TextView) findViewById(R.id.text_time);
        talk_item_floating_a = (FloatingActionButton) findViewById(R.id.talk_item_floating_a);
        talk_item_floating_a.setOnClickListener(this);
        talk_item_floating_b = (FloatingActionButton) findViewById(R.id.talk_item_floating_b);
        talk_item_floating_b.setOnClickListener(this);
        talk_item_floating_xihuan = (FloatingActionButton) findViewById(R.id.talk_item_floating_xihuan);
        talk_item_floating_xihuan.setOnClickListener(this);
        talk_item_floating = (FloatingActionsMenu) findViewById(R.id.talk_item_floating);
        talk_item_floating.setOnClickListener(this);
        text_title = (TextView) findViewById(R.id.text_title);
        drawee_view1 = (ImageView) findViewById(R.id.drawee_view1);
        image_back = (ImageView) findViewById(R.id.image_back);
        image_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.talk_item_floating_a:
                break;
            case R.id.talk_item_floating_b:
                break;
            case R.id.talk_item_floating_xihuan:
                break;
            case R.id.talk_item_floating:
                break;
            case R.id.image_back:
                finish();
                break;
        }
    }

    @Override
    public void getJokeDetailSuccess(JokeDetailBean jokeDetailBean) {
        JokeDetailBean.DataBean data = jokeDetailBean.getData();
        Log.e("dddd",data.getContent());
        Glide.with(this).load(data.getUser().getIcon()).into(drawee_view);
        Glide.with(this).load(data.getImgUrls()).into(drawee_view1);
        text_name.setText(data.getUser().getNickname());
        text_time.setText(data.getCreateTime());
        text_title.setText(data.getContent());
    }
}
