package com.example.com.xiaoniba987.ui;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import com.bumptech.glide.Glide;
import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.fragment.DuanZiFragment;
import com.example.com.xiaoniba987.fragment.QuTuFragment;
import com.example.com.xiaoniba987.fragment.ShiPingFragment;
import com.example.com.xiaoniba987.ui.celakuang.My_GuanZhu;
import com.example.com.xiaoniba987.ui.login.LoginActivity_;
import com.example.com.xiaoniba987.ui.tuijian.TuiJianFragment;
import com.example.com.xiaoniba987.utils.SharedPreferencesUtils;
import com.example.com.xiaoniba987.utils.TitleActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private TitleActivity mTitleTemplate;
    private BottomTabBar mTabar;
    private DrawerLayout mDl;
    private ImageView mDimg;
    private SimpleDraweeView mCesdv;
    private ListView mLv;
    private RelativeLayout mLeft;
    private BottomTabBar btab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取组件
        initView();

        //加载fragment
        initFragment();

        //抽屉事件
        initDrwLaout();


    }

    //抽屉事件
    private void initDrwLaout() {
        // 1创建数据
        final List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "我的关注");
        map1.put("image", R.drawable.raw_1499933216);

        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "我的收藏");
        map2.put("image", R.drawable.raw_1499947358);

        HashMap<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "搜索好友");
        map3.put("image", R.drawable.raw_1499946865);

        HashMap<String, Object> map4 = new HashMap<String, Object>();
        map4.put("name", "消息通知");
        map4.put("image", R.drawable.raw_1499947389);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        String uid = (String) SharedPreferencesUtils.getParam(MainActivity.this, "uid", "-1");
        String name = (String) SharedPreferencesUtils.getParam(MainActivity.this, "name", "");
        String iconUrl = (String) SharedPreferencesUtils.getParam(MainActivity.this, "iconUrl", "");
        if (uid.equals("-1")){

        }else {
            Glide.with(this).load(iconUrl).into(mCesdv);
        }

        // 2创建适配器
        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.drawerlist_item, new String[] { "name", "image" },
                new int[] { R.id.tv_name, R.id.img });

        // 3 填充
        mLv.setAdapter(adapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(MainActivity.this,My_GuanZhu.class);
                        startActivity(intent);
                        break;
                }
            }
        });


    }

    //加载fragment
    private void initFragment() {
        btab.init(getSupportFragmentManager())
                .setImgSize(100, 100)
                .setFontSize(12)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("推荐", R.drawable.tuijian2, R.drawable.tuijian1, TuiJianFragment.class)
                .addTabItem("段子", R.drawable.duanzi2, R.drawable.duanzi1, DuanZiFragment.class)
                .addTabItem("视频", R.drawable.shipin2, R.drawable.shipin1, ShiPingFragment.class)
                .addTabItem("趣图", R.drawable.tuijian2, R.drawable.tuijian1, QuTuFragment.class)
                .isShowDivider(false);
    }

    //获取组件
    private void initView() {
        mTitleTemplate = (TitleActivity) findViewById(R.id.title_);
        mTabar = (BottomTabBar) findViewById(R.id.tabar);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        mDimg = (ImageView) findViewById(R.id.dimg);
        mCesdv = (SimpleDraweeView) findViewById(R.id.cesdv);
        mLv = (ListView) findViewById(R.id.lv);
        mLeft = (RelativeLayout) findViewById(R.id.left1);
        btab = findViewById(R.id.tabar);
        mTitleTemplate.setOnItemTitleClickListener(new TitleActivity.OnItemTitleClickListener() {
            @Override
            public void onClickleft(View v) {
                mDl.openDrawer(Gravity.LEFT);
            }

            @Override
            public void onClickrigth(View v) {

            }
        });

        mDimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LoginActivity_.class);
                startActivity(intent);
            }
        });

    }


}
