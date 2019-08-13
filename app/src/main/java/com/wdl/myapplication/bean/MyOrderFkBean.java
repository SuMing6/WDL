package com.wdl.myapplication.bean;

import java.util.List;

public class MyOrderFkBean {

    private int code;
    private String title;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private String id;
        private String code;
        private String uid;
        private String sid;
        private String price;
        private String status;
        private Object dizhi;
        private Object chanpin;
        private String date;
        private String pay_type;
        private String pay_img;
        private String status_txt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getDizhi() {
            return dizhi;
        }

        public void setDizhi(Object dizhi) {
            this.dizhi = dizhi;
        }

        public Object getChanpin() {
            return chanpin;
        }

        public void setChanpin(Object chanpin) {
            this.chanpin = chanpin;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getPay_img() {
            return pay_img;
        }

        public void setPay_img(String pay_img) {
            this.pay_img = pay_img;
        }

        public String getStatus_txt() {
            return status_txt;
        }

        public void setStatus_txt(String status_txt) {
            this.status_txt = status_txt;
        }
    }
}
