package com.example.com.xiaoniba987.ui.tuijian.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseFragment;
import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.VideosBean;
import com.example.com.xiaoniba987.httpcompoter.DaggerHttpComponent;
import com.example.com.xiaoniba987.ui.tuijian.adapter.RenMenAdapter;
import com.example.com.xiaoniba987.ui.tuijian.contract.TuiContract;
import com.example.com.xiaoniba987.ui.tuijian.presenter.TuiPresenter;
import com.example.com.xiaoniba987.utils.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李小龙 on 2018/6/5.
 */

public class ReMenFragment extends BaseFragment<TuiPresenter> implements TuiContract.View {
    private View view;
    private Banner banner;
    private RecyclerView rv;
    private SmartRefreshLayout smart_refresh;
    private String uid = "2797";
    private String type = "1";
    private int page = 1;
    private String msg1;
    private String msg2;
    private String msg3;
    private List<VideosBean.DataBean> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remen_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    public int getContentLayout() {
        return R.layout.remen_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        smart_refresh = (SmartRefreshLayout) view.findViewById(R.id.smart_refresh);
        banner = (Banner) view.findViewById(R.id.banner);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mPresenter.getAd();
        mPresenter.getVideos(uid, type, String.valueOf(page));
        smart_refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page = 1;
                mPresenter.getVideos(uid, type, String.valueOf(page));
                smart_refresh.finishLoadMore(2000);
            }
        });
        smart_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page++;
                mPresenter.getVideos(uid, type, String.valueOf(page));
                smart_refresh.finishRefresh(2000);
            }
        });
    }

    @Override
    public void getAdSuccess(AdBean adBean) {
        Log.d("ddd", adBean.getData().get(0).getTitle());
        List<AdBean.DataBean> data = adBean.getData();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getIcon());
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(list);
        banner.start();
    }

    @Override
    public void getVideosSuccess(VideosBean videosBean) {
        if (videosBean != null) {
            data = videosBean.getData();
            RenMenAdapter renMenAdapter = new RenMenAdapter(data, getActivity(), mPresenter, msg1, msg2, msg3);
            rv.setAdapter(renMenAdapter);
        }
    }

    @Override
    public void praiseSuccess(String msg1) {
        if (msg1.equals("已点赞") && msg1.equals("已点赞过")) {
            RenMenAdapter renMenAdapter = new RenMenAdapter(data, getActivity(), mPresenter, msg1, msg2, msg3);
            rv.setAdapter(renMenAdapter);
        }
    }

    @Override
    public void addFavoriteSuccess(String msg2) {
        if (msg2.equals("收藏成功")) {
            RenMenAdapter renMenAdapter = new RenMenAdapter(data, getActivity(), mPresenter, msg1, msg2, msg3);
            rv.setAdapter(renMenAdapter);
        }
    }

    @Override
    public void cancelFavoriteSuccess(String msg3) {
        if (msg3.equals("已取消")) {
            RenMenAdapter renMenAdapter = new RenMenAdapter(data, getActivity(), mPresenter, msg1, msg2, msg3);
            rv.setAdapter(renMenAdapter);
        }
    }
}
