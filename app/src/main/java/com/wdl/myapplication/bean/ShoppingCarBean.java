package com.wdl.myapplication.bean;

import java.util.List;

public class ShoppingCarBean {
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

        private String id;
        private String cid;
        private String gid;
        private String num;
        private ChanpinBean chanpin;
        private GuigeBean guige;
        private int price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public ChanpinBean getChanpin() {
            return chanpin;
        }

        public void setChanpin(ChanpinBean chanpin) {
            this.chanpin = chanpin;
        }

        public GuigeBean getGuige() {
            return guige;
        }

        public void setGuige(GuigeBean guige) {
            this.guige = guige;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public static class ChanpinBean {
            /**
             * id : 10
             * pic : http://www.wandongli.com.cnhttp://img.wandongli.com/img/32/5449ffa511e54.jpg
             * title : 网店托管
             * price : 0.00
             */

            private String id;
            private String pic;
            private String title;
            private String price;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }

        public static class GuigeBean {
            /**
             * name : 一盒
             * price : 99.00
             */

            private String name;
            private String price;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }
    }
}
