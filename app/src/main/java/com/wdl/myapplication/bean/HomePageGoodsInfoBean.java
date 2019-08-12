package com.wdl.myapplication.bean;

import java.util.List;

public class HomePageGoodsInfoBean {
    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private int id;
        private int sid;
        private String uid;
        private String cat;
        private String title;
        private String sku;
        private String price_old;
        private String price;
        private String pic;
        private String content;
        private String zan;
        private String xiaoliang;
        private String hit;
        private Object para;
        private String date;
        private String hd_xianshiqianggou;
        private String hd_temaijingxuan;
        private Object guige;
        private List<String> pics;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
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

        public Object getGuige() {
            return guige;
        }

        public void setGuige(Object guige) {
            this.guige = guige;
        }

        public List<String> getPics() {
            return pics;
        }

        public void setPics(List<String> pics) {
            this.pics = pics;
        }
    }
}
