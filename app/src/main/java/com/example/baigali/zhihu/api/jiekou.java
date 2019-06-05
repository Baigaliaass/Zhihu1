package com.example.baigali.zhihu.api;





import com.example.baigali.zhihu.baen.Remen;
import com.example.baigali.zhihu.baen.Ribao;
import com.example.baigali.zhihu.baen.Zhuanlan;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

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
public interface jiekou {
    public String url="http://news-at.zhihu.com/api/4/";
    //知乎
    //最新日报
    @GET("news/latest")
    Observable<Ribao>getRibao();
    //专栏
    @GET("sections ")
    Observable<Zhuanlan>getZhuanlan();
    //热门
    @GET("news/hot ")
    Observable<Remen>getRemen();

}
