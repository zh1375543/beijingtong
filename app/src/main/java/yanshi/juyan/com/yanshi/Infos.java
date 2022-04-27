package yanshi.juyan.com.yanshi;

import java.util.List;

/**
 * on 2022/1/20
 *
 * @Author zhanghui
 * @Description
 */
public class Infos {
    public static   List<Info1>Info1 ;
    public static  List<Info3>Info3 ;
    public static  List<Info2>Info2 ;

    public List<Infos.Info1> getInfo1() {
        return Info1;
    }

    public void setInfo1(List<Infos.Info1> info1) {
        Info1 = info1;
    }

    public List<Infos.Info3> getInfo3() {
        return Info3;
    }

    public void setInfo3(List<Infos.Info3> info3) {
        Info3 = info3;
    }

    public List<Infos.Info2> getInfo2() {
        return Info2;
    }

    public void setInfo2(List<Infos.Info2> info2) {
        Info2 = info2;
    }

    static class Info1{

        public Info1(String num1, String num2, String num3) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }

        private  String num1;
        private  String num2;
        private  String num3;

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
        }

        public String getNum3() {
            return num3;
        }

        public void setNum3(String num3) {
            this.num3 = num3;
        }
    }

    static class Info2{
        public Info2(String num1, String num2, String num3) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }
        private  String num1;
        private  String num2;
        private  String num3;

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
        }

        public String getNum3() {
            return num3;
        }

        public void setNum3(String num3) {
            this.num3 = num3;
        }
    }

   static class Info3{

        public Info3(String num1, String num2, String num3) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }
        private  String num1;
        private  String num2;
        private  String num3;

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
        }

        public String getNum3() {
            return num3;
        }

        public void setNum3(String num3) {
            this.num3 = num3;
        }
    }
}
