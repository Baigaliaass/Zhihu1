package com.example.baigali.zhihu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Adapter;

import com.example.baigali.zhihu.adapter.VpAdapter;
import com.example.baigali.zhihu.base.BaseActivity;
import com.example.baigali.zhihu.fragment.RemenFragment;
import com.example.baigali.zhihu.fragment.RibaoFragment;
import com.example.baigali.zhihu.fragment.ZhuanlanFragment;
import com.example.baigali.zhihu.preneseter.MainP;
import com.example.baigali.zhihu.view.MainV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @Date //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                           O\  =  /O
 * //                        ____/`---'\____
 * //                      .'  \\|     |//  `.
 * //                     /  \\|||  :  |||//  \
 * //                     /  _||||| -:- |||||-  \
 * //                     |   | \\\  -  /// |   |
 * //                    | \_|  ''\---/''  |   |
 * //                    \  .-\__  `-`  ___/-. /
 * //                  ___`. .'  /--.--\  `. . __
 * //                ."" '<  `.___\_<|>_/___.'  >'"".
 * //              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * //               \  \ `-.   \_ __\ /__ _/   .-` /  /
 * //          ======`-.____`-.___\_____/___.-`____.-'======
 * //                             `=---='
 * //         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * //                    佛祖保佑        永无BUG
 * //            佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 * //                                        --白嘎力
 */

public class MainActivity extends BaseActivity<MainV, MainP> implements MainV {


    @BindView(R.id.mTab)
    TabLayout mTab;
    @BindView(R.id.mVp)
    ViewPager mVp;

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ArrayList<Fragment> fragment = new ArrayList<>();
        fragment.add(new RibaoFragment());
        fragment.add(new ZhuanlanFragment());
        fragment.add(new RemenFragment());
        mTab.addTab(mTab.newTab().setText("日报"));
        mTab.addTab(mTab.newTab().setText("专栏"));
        mTab.addTab(mTab.newTab().setText("热门"));
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(),fragment);
        mVp.setAdapter(vpAdapter);
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
    }
}
