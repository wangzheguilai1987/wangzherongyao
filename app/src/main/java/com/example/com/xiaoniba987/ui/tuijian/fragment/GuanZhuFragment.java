package com.example.com.xiaoniba987.ui.tuijian.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseFragment;
import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.PraiseBean;
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

public class GuanZhuFragment extends BaseFragment<TuiPresenter> implements TuiContract.View {
    private View view;
    private Banner banner;
    private RecyclerView rv;
    private SmartRefreshLayout smart_refresh;
    private String uid = "2797";
    private String type = "2";
    private int page = 1;
    private PraiseBean praiseBean;
    private String msg1;
    private String msg2;
    private String msg3;

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
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.raw_1500002643);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(list);
        banner.start();
    }

    @Override
    public void getAdSuccess(AdBean adBean) {

    }

    @Override
    public void getVideosSuccess(VideosBean videosBean) {
        if (videosBean != null) {
            List<VideosBean.DataBean> data = videosBean.getData();
            RenMenAdapter renMenAdapter = new RenMenAdapter(data, getActivity(), mPresenter, msg1, msg2, msg3);
            rv.setAdapter(renMenAdapter);
        }
    }

    @Override
    public void praiseSuccess(String msg1) {
        msg1 = msg1;
    }

    @Override
    public void addFavoriteSuccess(String msg2) {
        msg2 = msg2;
    }

    @Override
    public void cancelFavoriteSuccess(String msg3) {
        msg3 = msg3;
    }

}
