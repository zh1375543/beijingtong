package yanshi.juyan.com.yanshi;

import java.util.List;

/**
 * on 2022/1/22
 *
 * @Author zhanghui
 * @Description
 */
public class GJinfos  {

    public static List<MyInfos> infosList;

    public static List<MyInfos> getInfosList() {
        return infosList;
    }

    public void setInfosList(List<MyInfos> infosList) {
        this.infosList = infosList;
    }

    static class MyInfos{

        public MyInfos(String pay, String mouth, String date, String money,String index) {
            this.pay = pay;
            this.mouth = mouth;
            this.date = date;
            this.money = money;
            this.index=index;
        }

        private String pay;
        private String mouth;
        private String date;
        private String money;
        private String index;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getPay() {
            return pay;
        }

        public void setPay(String pay) {
            this.pay = pay;
        }

        public String getMouth() {
            return mouth;
        }

        public void setMouth(String mouth) {
            this.mouth = mouth;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }
}
