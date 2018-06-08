package com.example.com.xiaoniba987.ui.shipin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseFragment;
import com.example.com.xiaoniba987.ui.shipin.fragment.FuJinFragment;
import com.example.com.xiaoniba987.ui.shipin.fragment.ReMenShiPinFragment;
import com.example.com.xiaoniba987.ui.tuijian.fragment.GuanZhuFragment;
import com.example.com.xiaoniba987.ui.tuijian.fragment.ReMenFragment;
import com.example.com.xiaoniba987.utils.TitleActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李小龙 on 2018/6/5.
 */

public class ShiPingFragment extends BaseFragment {
    private View view;
    private TabLayout mTab;
    private ViewPager mViewpager;
    private List<String> list;
    private List<Fragment> fragmentList;
    private TitleActivity mTitleTemplate;
    private DrawerLayout mDl;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tuijianfragment, container, false);
        initView(view);

        return view;


    }
    @Override
    public int getContentLayout() {
        return R.layout.tuijianfragment;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewpager = (ViewPager) view.findViewById(R.id.viewpager);
        //添加数据
        getData();
    }
    public void getData() {
        list = new ArrayList<>();
        fragmentList = new ArrayList<>();
        list.add("热门");
        list.add("附近");
        TextView textView = new TextView(getActivity());
        textView.setTextSize(20);

        //创建fragment
        FuJinFragment fuJinFragment = new FuJinFragment();
        ReMenShiPinFragment reMenShiPinFragment = new ReMenShiPinFragment();
        fragmentList.add(reMenShiPinFragment);
        fragmentList.add(fuJinFragment);

        //适配器
        mViewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);

            }
        });
        mTab.setupWithViewPager(mViewpager);
        mViewpager.setOffscreenPageLimit(2);//预加载
    }

}
