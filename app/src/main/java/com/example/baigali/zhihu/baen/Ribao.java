package com.example.baigali.zhihu.baen;

import java.util.List;

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
public class Ribao {

    /**
     * date : 20190503
     * stories : [{"images":["https://pic2.zhimg.com/v2-5599a0274655bf331451cb8123647269.jpg"],"type":0,"id":9458860,"ga_prefix":"050316","title":"在人类制造光明的历史上，光究竟有多贵？"},{"images":["https://pic1.zhimg.com/v2-5b3e7329c52777a9e2002a36ad83a73c.jpg"],"type":0,"id":9465349,"ga_prefix":"050309","title":"对情欲没有了想象力，多么悲哀的一件事"},{"images":["https://pic4.zhimg.com/v2-0ef521d955bce4c1bc63073215d88a07.jpg"],"type":0,"id":9710801,"ga_prefix":"050307","title":"《权力的游戏》里的龙是怎么做出来的？视效总监如是说"},{"images":["https://pic2.zhimg.com/v2-9db21ac2cb00b02841800af6eb7f901d.jpg"],"type":0,"id":9710846,"ga_prefix":"050306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-7555e56f4ae4be4e7916a3f578f3c20b.jpg","type":0,"id":9710753,"ga_prefix":"050107","title":"为什么很多人讨厌剧透？"},{"image":"https://pic4.zhimg.com/v2-66e3354dec06315d47299d0bf6a8ff7f.jpg","type":0,"id":9710786,"ga_prefix":"043008","title":"迄今为止你见过最惊艳的建筑是哪个？"},{"image":"https://pic2.zhimg.com/v2-0a077825bb0e2b3584ffaf1dc9c68465.jpg","type":0,"id":9710774,"ga_prefix":"042908","title":"呃\u2026\u2026漫威和 DC 的这些角色也太像了吧"},{"image":"https://pic2.zhimg.com/v2-5446dd9cea49630ddc0e193a524df669.jpg","type":0,"id":9710732,"ga_prefix":"042907","title":"漫威是否会毁了电影艺术？"},{"image":"https://pic3.zhimg.com/v2-45d4abb765fbbff50aa88f8c92825376.jpg","type":0,"id":9710722,"ga_prefix":"042909","title":"那些没能回来的小燕子，可能已经变成了烧烤"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-5599a0274655bf331451cb8123647269.jpg"]
         * type : 0
         * id : 9458860
         * ga_prefix : 050316
         * title : 在人类制造光明的历史上，光究竟有多贵？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-7555e56f4ae4be4e7916a3f578f3c20b.jpg
         * type : 0
         * id : 9710753
         * ga_prefix : 050107
         * title : 为什么很多人讨厌剧透？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
