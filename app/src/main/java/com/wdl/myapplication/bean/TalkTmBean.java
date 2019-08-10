package com.wdl.myapplication.bean;

import java.util.List;

public class TalkTmBean {

    /**
     * code : 0
     * count : 1
     * data : [{"id":"96","sid":"285459","uid":"243978","cat":"2236","title":"路灯产品设计","sku":"11","price_old":"11.00","price":"10.00","pic":"http://www.wandongli.com.cn/img/20190719/20190719155440_64668.jpg","pics":"[\"\\/img\\/20190719\\/20190719155447_73589.jpg\",\"\\/img\\/20190719\\/20190719155453_97903.jpg\",\"\\/img\\/20190719\\/20190719155500_13258.jpg\"]","content":"佛山正迪专注于为企业提供工业产品整体规划设计，包括产品概念设计、工业产品设计（外观设计、造型设计、结构设计）、手板制作及模具制造、包装设计。","zan":"0","xiaoliang":"0","hit":"26","para":null,"date":"1563522930","hd_xianshiqianggou":"0","hd_temaijingxuan":"1"}]
     */

    private int code;
    private int count;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 96
         * sid : 285459
         * uid : 243978
         * cat : 2236
         * title : 路灯产品设计
         * sku : 11
         * price_old : 11.00
         * price : 10.00
         * pic : http://www.wandongli.com.cn/img/20190719/20190719155440_64668.jpg
         * pics : ["\/img\/20190719\/20190719155447_73589.jpg","\/img\/20190719\/20190719155453_97903.jpg","\/img\/20190719\/20190719155500_13258.jpg"]
         * content : 佛山正迪专注于为企业提供工业产品整体规划设计，包括产品概念设计、工业产品设计（外观设计、造型设计、结构设计）、手板制作及模具制造、包装设计。
         * zan : 0
         * xiaoliang : 0
         * hit : 26
         * para : null
         * date : 1563522930
         * hd_xianshiqianggou : 0
         * hd_temaijingxuan : 1
         */

        private int id;
        private String sid;
        private String uid;
        private String cat;
        private String title;
        private String sku;
        private String price_old;
        private String price;
        private String pic;
        private String pics;
        private String content;
        private String zan;
        private String xiaoliang;
        private String hit;
        private Object para;
        private String date;
        private String hd_xianshiqianggou;
        private String hd_temaijingxuan;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getPrice_old() {
            return price_old;
        }

        public void setPrice_old(String price_old) {
            this.price_old = price_old;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getPics() {
            return pics;
        }

        public void setPics(String pics) {
            this.pics = pics;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public String getXiaoliang() {
            return xiaoliang;
        }

        public void setXiaoliang(String xiaoliang) {
            this.xiaoliang = xiaoliang;
        }

        public String getHit() {
            return hit;
        }

        public void setHit(String hit) {
            this.hit = hit;
        }

        public Object getPara() {
            return para;
        }

        public void setPara(Object para) {
            this.para = para;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHd_xianshiqianggou() {
            return hd_xianshiqianggou;
        }

        public void setHd_xianshiqianggou(String hd_xianshiqianggou) {
            this.hd_xianshiqianggou = hd_xianshiqianggou;
        }

        public String getHd_temaijingxuan() {
            return hd_temaijingxuan;
        }

        public void setHd_temaijingxuan(String hd_temaijingxuan) {
            this.hd_temaijingxuan = hd_temaijingxuan;
        }
    }
}
