package com.example.com.xiaoniba987.ui.duanzi;

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
import com.example.com.xiaoniba987.bean.JokesBean;
import com.example.com.xiaoniba987.httpcompoter.DaggerHttpComponent;
import com.example.com.xiaoniba987.ui.duanzi.adapter.JokesAdapter;
import com.example.com.xiaoniba987.ui.duanzi.contract.DuanZiContract;
import com.example.com.xiaoniba987.ui.duanzi.presenter.DuanZiPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * Created by 李小龙 on 2018/6/5.
 */

public class DuanZiFragment extends BaseFragment<DuanZiPresenter> implements DuanZiContract.View {

    private RecyclerView rv;
    private SmartRefreshLayout smart_refresh;
    private View view;
    private int page=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.duanzi_fragment, container, false);
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
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        mPresenter.getJokes(String.valueOf(page));

        smart_refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page=1;
                mPresenter.getJokes(String.valueOf(page));
                smart_refresh.finishLoadMore(2000);
            }
        });
        smart_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page++;
                mPresenter.getJokes(String.valueOf(page));
                smart_refresh.finishRefresh(2000);
            }
        });
    }

    @Override
    public void getJokesSuccess(JokesBean jokesBean) {
        List<JokesBean.DataBean> data = jokesBean.getData();
        JokesAdapter jokesAdapter = new JokesAdapter(getActivity(),data);
        rv.setAdapter(jokesAdapter);
    }
}
