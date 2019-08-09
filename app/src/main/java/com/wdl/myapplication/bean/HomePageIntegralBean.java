package com.wdl.myapplication.bean;

import java.util.List;

public class HomePageIntegralBean {

    private int code;
    private int shi;
    private int h;
    private int i;
    private int s;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getShi() {
        return shi;
    }

    public void setShi(int shi) {
        this.shi = shi;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

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
