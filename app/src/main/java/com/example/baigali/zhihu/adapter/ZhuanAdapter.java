package com.example.baigali.zhihu.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.baigali.zhihu.R;
import com.example.baigali.zhihu.baen.Zhuanlan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Date 2019/3/27 8:55
 * //                            _ooOoo_
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
public class ZhuanAdapter extends RecyclerView.Adapter<ZhuanAdapter.ViewHodler>{
    private Zhuanlan mData;
    private Context mContext;
    private ArrayList<Zhuanlan.DataBean> mList;

    public ZhuanAdapter(ArrayList<Zhuanlan.DataBean> list) {

        mList = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.zhuan_item, null);
        return new ViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        Zhuanlan.DataBean dataBean = mList.get(position);
        Glide.with(mContext).load(dataBean.getThumbnail()).into(holder.mImg);
        holder.mName.setText(dataBean.getName());
        holder.mXin.setText(dataBean.getDescription());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(Zhuanlan data) {
        mData = data;
    }


    public class ViewHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.section_bg)
        ImageView mImg;
        @BindView(R.id.section_kind)
        TextView mName;
        @BindView(R.id.section_des)
        TextView mXin;
        public ViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
