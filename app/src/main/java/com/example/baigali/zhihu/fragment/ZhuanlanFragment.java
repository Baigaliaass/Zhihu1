package com.example.baigali.zhihu.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.baigali.zhihu.R;
import com.example.baigali.zhihu.adapter.ZhuanAdapter;
import com.example.baigali.zhihu.baen.Zhuanlan;
import com.example.baigali.zhihu.base.BaseFagment;
import com.example.baigali.zhihu.preneseter.ZhuanP;
import com.example.baigali.zhihu.view.ZhuanV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanlanFragment extends BaseFagment<ZhuanV, ZhuanP> implements ZhuanV {


    @BindView(R.id.Re)
    RecyclerView mRe;
    private ArrayList<Zhuanlan.DataBean> mList;
    private ZhuanAdapter mZhuanAdapter;

    @Override
    protected ZhuanP initPresenter() {
        return new ZhuanP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhuanlan;
    }

    @Override
    protected void initData() {
        mPresenter.getData();

    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        mZhuanAdapter = new ZhuanAdapter(mList);
        mRe.setAdapter(mZhuanAdapter);
        //网格方式
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRe.setLayoutManager(layoutManager);

    }


    @Override
    public void setData(Zhuanlan bean) {
        mList.addAll(bean.getData());
        mZhuanAdapter.setData(bean);
        mZhuanAdapter.notifyDataSetChanged();
    }
}
