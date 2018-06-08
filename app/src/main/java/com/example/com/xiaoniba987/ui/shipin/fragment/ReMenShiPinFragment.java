package com.example.com.xiaoniba987.ui.shipin.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.xiaoniba987.R;
import com.example.com.xiaoniba987.base.BaseFragment;
import com.example.com.xiaoniba987.bean.HotVideosBean;
import com.example.com.xiaoniba987.bean.NearVideosBean;
import com.example.com.xiaoniba987.bean.VideosBean;
import com.example.com.xiaoniba987.httpcompoter.DaggerHttpComponent;
import com.example.com.xiaoniba987.ui.shipin.VideoDetailActivity;
import com.example.com.xiaoniba987.ui.shipin.adapter.RenMenShiPinAdapter;
import com.example.com.xiaoniba987.ui.shipin.contract.VideosContract;
import com.example.com.xiaoniba987.ui.shipin.presenter.VideosPresenter;
import com.example.com.xiaoniba987.ui.tuijian.adapter.RenMenAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * Created by Lenovo on 2018/6/7.
 */

public class ReMenShiPinFragment extends BaseFragment<VideosPresenter> implements VideosContract.View {
    private View view;
    private RecyclerView rv;
    private SmartRefreshLayout smart_refresh;
    private int page=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remenshipin_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    public int getContentLayout() {
        return R.layout.remenshipin_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {

        rv = (RecyclerView) view.findViewById(R.id.rv);
        smart_refresh = (SmartRefreshLayout) view.findViewById(R.id.smart_refresh);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mPresenter.getHotVideos(String.valueOf(page));
        smart_refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mPresenter.getHotVideos(String.valueOf(page));
                smart_refresh.finishLoadMore(2000);
            }
        });
        smart_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page++;
                mPresenter.getHotVideos(String.valueOf(page));
                smart_refresh.finishRefresh(2000);
            }
        });
    }

    @Override
    public void getHotVideosSuccess(final HotVideosBean hotVideosBean) {
        if (hotVideosBean!=null) {
            List<HotVideosBean.DataBean> data = hotVideosBean.getData();
            RenMenShiPinAdapter renMenShiPinAdapter = new RenMenShiPinAdapter(data, getActivity());
            rv.setAdapter(renMenShiPinAdapter);
            renMenShiPinAdapter.setOnClickListeners(new RenMenShiPinAdapter.Listeners() {
                @Override
                public void setOnClickListeners(int position) {
                    Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                    intent.putExtra("wid",hotVideosBean.getData().get(position).getWid());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void getNearVideosSuccess(NearVideosBean nearVideosBean) {

    }
}
