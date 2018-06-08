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
import com.example.com.xiaoniba987.httpcompoter.DaggerHttpComponent;
import com.example.com.xiaoniba987.ui.shipin.VideoDetailActivity;
import com.example.com.xiaoniba987.ui.shipin.adapter.FuJinShiPinAdapter;
import com.example.com.xiaoniba987.ui.shipin.adapter.RenMenShiPinAdapter;
import com.example.com.xiaoniba987.ui.shipin.contract.VideosContract;
import com.example.com.xiaoniba987.ui.shipin.presenter.VideosPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * Created by Lenovo on 2018/6/7.
 */

public class FuJinFragment extends BaseFragment<VideosPresenter> implements VideosContract.View {
    private View view;
    private RecyclerView rv;
    private SmartRefreshLayout smart_refresh;
    private int page=1;
    private double latitude=39.1;
    private double longitude=32.1;

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
        mPresenter.getNearVideos(String.valueOf(page), latitude+"",longitude+"");
        smart_refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mPresenter.getNearVideos(String.valueOf(page), latitude+"",longitude+"");
                smart_refresh.finishLoadMore(2000);
            }
        });
        smart_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page++;
                mPresenter.getNearVideos(String.valueOf(page), latitude+"",longitude+"");
                smart_refresh.finishRefresh(2000);
            }
        });
    }

    @Override
    public void getHotVideosSuccess(HotVideosBean hotVideosBean) {

    }

    @Override
    public void getNearVideosSuccess(final NearVideosBean nearVideosBean) {
        if (nearVideosBean!=null) {
            List<NearVideosBean.DataBean> data = nearVideosBean.getData();
            FuJinShiPinAdapter fuJinShiPinAdapter = new FuJinShiPinAdapter(data, getActivity());
            rv.setAdapter(fuJinShiPinAdapter);
            fuJinShiPinAdapter.setOnClickListeners(new FuJinShiPinAdapter.Listeners() {
                @Override
                public void setOnClickListeners(int position) {
                    Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                    intent.putExtra("wid",nearVideosBean.getData().get(position).getWid());
                    startActivity(intent);
                }
            });
        }
    }
}
