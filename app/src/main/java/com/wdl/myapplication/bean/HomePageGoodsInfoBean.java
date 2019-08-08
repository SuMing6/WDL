package com.wdl.myapplication.bean;

import java.util.List;

public class HomePageGoodsInfoBean {

    private int code;
    private String msg;
    private String base_url;
    private InfoBean info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {

        private String name;
        private int shop_id;
        private int market_price;
        private int shop_price;
        private int number;
        private String img;
        private String info;
        private int sales;
        private int is_points;
        private int second;
        private String rolex;
        private String video;
        private int points;
        private int review;
        private int rate;
        private int is_free;
        private int id;
        private int collect;
        private int spec;
        private ShopBean shop;
        private String huajia;
        private List<String> detail;
        private List<SpecListBean> spec_list;
        private List<ShopListBean> shop_list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public int getMarket_price() {
            return market_price;
        }

        public void setMarket_price(int market_price) {
            this.market_price = market_price;
        }

        public int getShop_price() {
            return shop_price;
        }

        public void setShop_price(int shop_price) {
            this.shop_price = shop_price;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public int getSales() {
            return sales;
        }

        public void setSales(int sales) {
            this.sales = sales;
        }

        public int getIs_points() {
            return is_points;
        }

        public void setIs_points(int is_points) {
            this.is_points = is_points;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public String getRolex() {
            return rolex;
        }

        public void setRolex(String rolex) {
            this.rolex = rolex;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getReview() {
            return review;
        }

        public void setReview(int review) {
            this.review = review;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public int getIs_free() {
            return is_free;
        }

        public void setIs_free(int is_free) {
            this.is_free = is_free;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCollect() {
            return collect;
        }

        public void setCollect(int collect) {
            this.collect = collect;
        }

        public int getSpec() {
            return spec;
        }

        public void setSpec(int spec) {
            this.spec = spec;
        }

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
        }

        public String getHuajia() {
            return huajia;
        }

        public void setHuajia(String huajia) {
            this.huajia = huajia;
        }

        public List<String> getDetail() {
            return detail;
        }

        public void setDetail(List<String> detail) {
            this.detail = detail;
        }

        public List<SpecListBean> getSpec_list() {
            return spec_list;
        }

        public void setSpec_list(List<SpecListBean> spec_list) {
            this.spec_list = spec_list;
        }

        public List<ShopListBean> getShop_list() {
            return shop_list;
        }

        public void setShop_list(List<ShopListBean> shop_list) {
            this.shop_list = shop_list;
        }

        public static class ShopBean {

            private String shop_name;
            private String shop_img;
            private int shop_score;

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public String getShop_img() {
                return shop_img;
            }

            public void setShop_img(String shop_img) {
                this.shop_img = shop_img;
            }

            public int getShop_score() {
                return shop_score;
            }

            public void setShop_score(int shop_score) {
                this.shop_score = shop_score;
            }
        }

        public static class SpecListBean {

            private int id;
            private String spec_name;
            private int shop_price;
            private int market_price;
            private String spec_img;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSpec_name() {
                return spec_name;
            }

            public void setSpec_name(String spec_name) {
                this.spec_name = spec_name;
            }

            public int getShop_price() {
                return shop_price;
            }

            public void setShop_price(int shop_price) {
                this.shop_price = shop_price;
            }

            public int getMarket_price() {
                return market_price;
            }

            public void setMarket_price(int market_price) {
                this.market_price = market_price;
            }

            public String getSpec_img() {
                return spec_img;
            }

            public void setSpec_img(String spec_img) {
                this.spec_img = spec_img;
            }
        }

        public static class ShopListBean {

            private int id;
            private String name;
            private String img;
            private int shop_price;
            private int is_points;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getShop_price() {
                return shop_price;
            }

            public void setShop_price(int shop_price) {
                this.shop_price = shop_price;
            }

            public int getIs_points() {
                return is_points;
            }

            public void setIs_points(int is_points) {
                this.is_points = is_points;
            }
        }
    }
}
