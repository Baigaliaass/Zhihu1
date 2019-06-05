package com.example.baigali.zhihu.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.baigali.zhihu.R;
import com.example.baigali.zhihu.adapter.RibaoAdapter;
import com.example.baigali.zhihu.baen.Ribao;
import com.example.baigali.zhihu.base.BaseFagment;
import com.example.baigali.zhihu.preneseter.RibaoP;
import com.example.baigali.zhihu.view.RibaoV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RibaoFragment extends BaseFagment<RibaoV, RibaoP> implements RibaoV {


    @BindView(R.id.Re)
    RecyclerView mRe;

    private RibaoAdapter mRibaoAdapter;

    @Override
    protected RibaoP initPresenter() {
        return new RibaoP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ribao;
    }

    @Override
    protected void initView() {
        super.initView();
        ArrayList<Ribao.StoriesBean> storiesBeans = new ArrayList<>();
        ArrayList<Ribao.TopStoriesBean> topStoriesBeans = new ArrayList<>();
        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRibaoAdapter = new RibaoAdapter(storiesBeans,topStoriesBeans);
        mRe.setAdapter(mRibaoAdapter);

    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void setData(Ribao bean) {
        mRibaoAdapter.setData(bean);
    }
}
