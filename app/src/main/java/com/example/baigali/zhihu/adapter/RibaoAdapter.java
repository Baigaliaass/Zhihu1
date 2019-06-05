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
import com.example.baigali.zhihu.baen.Ribao;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

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
public class RibaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final ArrayList<Ribao.StoriesBean> mStoriesBeans;
    private final ArrayList<Ribao.TopStoriesBean> mTopStoriesBeans;
    private Context mContext;
    private static final int TYPE_BANNER = 0;
    private static final int TYPE_TIME = 1;
    private static final int TYPE_NEWS = 2;
    private String mDate = "今日要闻";
    public RibaoAdapter(ArrayList<Ribao.StoriesBean> storiesBeans, ArrayList<Ribao.TopStoriesBean> topStoriesBeans) {

        mStoriesBeans = storiesBeans;
        mTopStoriesBeans = topStoriesBeans;
    }
    @Override
    public int getItemViewType(int position) {
        if (mTopStoriesBeans.size()>0){
            if (position == 0){
                return TYPE_BANNER;
            }else if (position == 1){
                return TYPE_TIME;
            }else {
                return TYPE_NEWS;
            }
        }else {
            if (position == 0){
                return TYPE_TIME;
            }else {
                return TYPE_NEWS;
            }
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (viewType == TYPE_BANNER){
            //banner
            return new BannerVH(inflater.inflate(R.layout.item_banner,null));
        }else if (viewType == TYPE_TIME){
            //日期
            return new TimeVH(inflater.inflate(R.layout.item_time,null));
        }else {
            //新闻
            return new NewsVH(inflater.inflate(R.layout.item_news,null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_BANNER){
            //banner
            BannerVH bannerVH = (BannerVH) holder;
            bannerVH.mBanner.setImages(mTopStoriesBeans)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path,
                                                 ImageView imageView) {
                            Ribao.TopStoriesBean bean = (Ribao.TopStoriesBean) path;
                            Glide.with(mContext).load(bean.getImage()).into(imageView);
                        }
                    })
                    .start();
        }else if (viewType == TYPE_TIME){
            //日期
            TimeVH timeVH = (TimeVH) holder;
            timeVH.mTvTime.setText(mDate);
        }else {
            //新闻
            int newPostion = position-1;
            if (mTopStoriesBeans.size()>0){
                newPostion -= 1;
            }
            Ribao.StoriesBean storiesBean = mStoriesBeans.get(newPostion);

            NewsVH newsVH = (NewsVH) holder;
            Glide.with(mContext).load(storiesBean.getImages().get(0)).into(newsVH.mImg);
            newsVH.mName.setText(storiesBean.getTitle() );
        }
    }
    public void setData(Ribao bean) {
        mDate = bean.getDate();
        mTopStoriesBeans.clear();
        if (bean.getTop_stories() != null && bean.getTop_stories().size()>0){
            mTopStoriesBeans.addAll(bean.getTop_stories());
        }

        mStoriesBeans.clear();
        if (bean.getStories() != null && bean.getStories().size()>0){
            mStoriesBeans.addAll(bean.getStories());
        }

        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (mTopStoriesBeans.size()>0){
            return 1+1+mStoriesBeans.size();
        }else {
            return 1+mStoriesBeans.size();
        }
    }

    public void setData(Retrofit bean) {

    }

    public class BannerVH extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner mBanner;
        public BannerVH(View inflate) {
            super(inflate);
            ButterKnife.bind(this,itemView);
        }
    }

    public class TimeVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time)
        TextView mTvTime;
        public TimeVH(View inflate) {
            super(inflate);
            ButterKnife.bind(this,itemView);
        }
    }

    public class NewsVH extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView mImg;
        @BindView(R.id.name)
        TextView mName;
        public NewsVH(View inflate) {
            super(inflate);
            ButterKnife.bind(this,itemView);
        }
    }
}
