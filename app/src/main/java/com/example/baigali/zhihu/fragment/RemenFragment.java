package com.example.baigali.zhihu.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.baigali.zhihu.R;
import com.example.baigali.zhihu.adapter.RemenAdapter;
import com.example.baigali.zhihu.baen.Remen;
import com.example.baigali.zhihu.base.BaseFagment;
import com.example.baigali.zhihu.preneseter.RemenP;
import com.example.baigali.zhihu.view.RemenV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemenFragment extends BaseFagment<RemenV, RemenP> implements RemenV {


    @BindView(R.id.Re)
    RecyclerView mRe;
    private RemenAdapter mRemenAdapter;
    private ArrayList<Remen.RecentBean> mRecentBeans;

    @Override
    protected RemenP initPresenter() {
        return new RemenP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_remen;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData();
    }

    @Override
    protected void initView() {
        super.initView();
        mRecentBeans = new ArrayList<>();
        mRemenAdapter = new RemenAdapter(mRecentBeans);
        mRe.setAdapter(mRemenAdapter);
        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void setData(Remen bean) {
        mRecentBeans.addAll(bean.getRecent());
        mRemenAdapter.setData(bean);
        mRemenAdapter.notifyDataSetChanged();
    }
}
