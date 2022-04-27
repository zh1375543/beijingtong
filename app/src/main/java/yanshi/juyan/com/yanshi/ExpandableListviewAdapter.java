package yanshi.juyan.com.yanshi;

import android.content.Context;
import android.icu.text.IDNA;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * on 2022/1/18
 *
 * @Author zhanghui
 * @Description
 */
public class ExpandableListviewAdapter extends BaseExpandableListAdapter {
    //Model：定义的数据
    private List<String>  groups;
    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
    private Context context;
    private int index;
    private List<ScollDataBean> beans;
    public ExpandableListviewAdapter(Context context, List<String> groups, int index){
        this.context=context;
        this.groups=groups;
        this.index=index;
    }

    @Override
    public int getGroupCount() {
        return index;
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return groups.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return i1;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    //分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    public boolean hasStableIds() {
        return true;
    }




    /**
 *
 * 获取显示指定组的视图对象
 *
 * @param groupPosition 组位置
 * @param isExpanded 该组是展开状态还是伸缩状态，true=展开
 * @param convertView 重用已有的视图对象
 * @param parent 返回的视图对象始终依附于的视图组
 */
    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_parent_item,parent,false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.parent_textview_id = convertView.findViewById(R.id.parent_textview_id);
            groupViewHolder.parent_image = convertView.findViewById(R.id.parent_image);
            groupViewHolder.mlaout=convertView.findViewById(R.id.llout_item);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }
        groupViewHolder.parent_textview_id.setText(groups.get(groupPosition));
        //如果是展开状态，
        if (isExpanded){
            groupViewHolder.parent_image.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.img_top));
        }else{
            groupViewHolder.parent_image.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.img_boom));
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_chidren_item,parent,false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.etNum1 = (EditText)convertView.findViewById(R.id.et_address);
            childViewHolder.etNum2 = (EditText)convertView.findViewById(R.id.et_address1);
            childViewHolder.mYe3 = (EditText)convertView.findViewById(R.id.Ye3);

            childViewHolder.mlao1 = (EditText)convertView.findViewById(R.id.lao1);
            childViewHolder.mlao2 = (EditText)convertView.findViewById(R.id.lao2);
            childViewHolder.mlao3 = (EditText)convertView.findViewById(R.id.lao3);
            childViewHolder.mye1 = (EditText)convertView.findViewById(R.id.Ye1);
            childViewHolder.mye2 = (EditText)convertView.findViewById(R.id.Ye2);
            childViewHolder.mShagn1 = (EditText)convertView.findViewById(R.id.shagn1);
            childViewHolder.mShagn2 = (EditText)convertView.findViewById(R.id.shagn2);
            childViewHolder.mShagn3 = (EditText)convertView.findViewById(R.id.shagn3);
            childViewHolder.mlao1.setText(Infos.Info1.get(0).getNum1());
            childViewHolder.mlao2.setText(Infos.Info1.get(0).getNum2());
            childViewHolder.mlao3.setText(Infos.Info1.get(0).getNum3());

            childViewHolder.mye1.setText(Infos.Info2.get(0).getNum1());
            childViewHolder.mye2.setText(Infos.Info2.get(0).getNum2());

            childViewHolder.mShagn1.setText(Infos.Info3.get(0).getNum1());
            childViewHolder.mShagn2.setText(Infos.Info3.get(0).getNum2());
            childViewHolder.mShagn3.setText(Infos.Info3.get(0).getNum3());

            convertView.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        if(!TextUtils.isEmpty(Tools.Info1)){
            childViewHolder.etNum1.setText("单位名称："+Tools.Info1);
        }
        if(!TextUtils.isEmpty(Tools.Info2)){
            childViewHolder.etNum2.setText("缴纳区县："+Tools.Info2);
        }
        if(groupPosition==4){
            if(!TextUtils.isEmpty(Tools.newInifo1)){
                childViewHolder.mYe3.setText(Tools.newInifo1);
            }
        }
        if(groupPosition==5){
            if(!TextUtils.isEmpty(Tools.newInifo1)){
                childViewHolder.mYe3.setText(Tools.newInifo1);
            }
        }

        if(groupPosition>5){
            childViewHolder.mye2.setText(Tools.newInifo2);
            childViewHolder.mYe3.setText(Tools.newInifo3);
        }
        return convertView;
    }

    //指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    static class GroupViewHolder {
        TextView parent_textview_id;
        ImageView parent_image;
        RelativeLayout mlaout;
    }

    static class ChildViewHolder {
        EditText etNum1;
        EditText etNum2;
        EditText mYe3;
        EditText mlao1;
        EditText mlao2;
        EditText mlao3;
        EditText mye1;
        EditText mye2;
        EditText mShagn1;
        EditText mShagn2;
        EditText mShagn3;
    }
}


