package com.wdl.myapplication.bean;

public class MyLoginBean {

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
        private String tel;
        private String nick;
        private int sid;
        private String headpic;
        private String date_reg;
        private String date_lastaction;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getHeadpic() {
            return headpic;
        }

        public void setHeadpic(String headpic) {
            this.headpic = headpic;
        }

        public String getDate_reg() {
            return date_reg;
        }

        public void setDate_reg(String date_reg) {
            this.date_reg = date_reg;
        }

        public String getDate_lastaction() {
            return date_lastaction;
        }

        public void setDate_lastaction(String date_lastaction) {
            this.date_lastaction = date_lastaction;
        }
    }
}
