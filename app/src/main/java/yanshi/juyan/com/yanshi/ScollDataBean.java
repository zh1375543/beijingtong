package yanshi.juyan.com.yanshi;

import java.util.List;

/**
 * on 2022/1/20
 *
 * @Author zhanghui
 * @Description
 */
public class ScollDataBean {

       private int name;
       private List<ChildData> data;

    public ScollDataBean(int name, List<ChildData> data) {
        this.name = name;
        this.data = data;
    }

    public List<ChildData> getData() {
        return data;
    }

    public void setData(List<ChildData> data) {
        this.data = data;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }


    static class ChildData{

        public ChildData(int childNum) {
            this.childNum = childNum;
        }

        private int childNum;

        public int getChildNum() {
            return childNum;
        }

        public void setChildNum(int childNum) {
            this.childNum = childNum;
        }
    }
}
