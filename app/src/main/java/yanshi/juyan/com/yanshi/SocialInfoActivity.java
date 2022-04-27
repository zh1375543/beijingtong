package yanshi.juyan.com.yanshi;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * on 2022/1/17
 *
 * @Author zhanghui
 * @Description
 */
public class SocialInfoActivity extends BaseActivity {

    @InjectView(R.id.et_time)
    EditText mTime;

    @InjectView(R.id.ll_laout_tip)
    LinearLayout mTip;

    @InjectView(R.id.et_social_name)
    EditText mName;

    @InjectView(R.id.et_info1)
    EditText mInfo1;
    @InjectView(R.id.et_info2)
    EditText mInfo2;

    @InjectView(R.id.et_pany)
    EditText mPany;

    @InjectView(R.id.et_pany_num)
    EditText mPanyNum;

    @InjectView(R.id.et_pany_type)
    EditText mType;

    @InjectView(R.id.et_pany_time)
    EditText mYearTime;
    private ExpandableListView expand_list_id;
      private OptionsPickerView pvNoLinkOptions;
    private List<String> typeInfo;
    List<String> time=new ArrayList<>();
    List<ScollDataBean> beans=new ArrayList<>();
    List<ScollDataBean.ChildData> datalist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        mTip.setVisibility(View.VISIBLE);
        header = new Header(this, "");
        header.setTitle("缴费信息");
        if(!TextUtils.isEmpty(Tools.name)){
            mName.setText(Tools.name);
        }
        if(!TextUtils.isEmpty(Tools.Info1)){
            mInfo1.setText(Tools.Info1);
        }
        if(!TextUtils.isEmpty(Tools.Info2)){
            mInfo2.setText(Tools.Info2);
        }

        if(!TextUtils.isEmpty(Tools.mPany)){
            mPany.setText(Tools.mPany);
        }

        if(!TextUtils.isEmpty(Tools.mPanyNum)){
            mPanyNum.setText(Tools.mPanyNum);
        }

        if(!TextUtils.isEmpty(Tools.mType)){
            mType.setText(Tools.mType);
        }
        if(!TextUtils.isEmpty(Tools.mYearNum)){
            mYearTime.setText(Tools.mYearNum);
        }
        expand_list_id=findViewById(R.id.expand_list_id);
        expand_list_id.setVelocityScale(View.GONE);
        initNoLinkOptionsPicker();
        typeInfo = new ArrayList<>();
        typeInfo.add("2022");
        typeInfo.add("2021");
        typeInfo.add("2020");
        typeInfo.add("2019");
        typeInfo.add("2018");
        typeInfo.add("2017");
        typeInfo.add("2016");
        typeInfo.add("2015");
        datalist=new ArrayList<>();

        ScollDataBean.ChildData data=new ScollDataBean.ChildData(1);
        datalist.add(data);
        ScollDataBean bean;
        for (int i=1;i<13;i++){
            bean=new ScollDataBean(i,datalist);
            beans.add(bean);
        }



    }

    @OnClick({R.id.et_time,R.id.tv_sumbit})
    public void Onclick(View view){

        switch (view.getId()){
            case R.id.et_time:
                pvNoLinkOptions.setPicker(typeInfo);
                pvNoLinkOptions.show();
                break;
            case R.id.tv_sumbit:
                int max;
                Calendar endDate = Calendar.getInstance();
                int year=endDate.get(Calendar.YEAR);
                if(Integer.parseInt(mTime.getText().toString().trim())==year){
                    int month = (endDate.get(Calendar.MONTH)) + 1;
                    if(month-1>=1){
                        max=month-1;
                    }else{
                        mTip.setVisibility(View.VISIBLE);
                        expand_list_id.setVelocityScale(View.GONE);
                        break;
                    }
                }else{
                    max=12;
                }
                mTip.setVisibility(View.GONE);
                expand_list_id.setVelocityScale(View.VISIBLE);
                //设置时间格式

                ExpandableListviewAdapter adapter=new ExpandableListviewAdapter(this,time,max);
                expand_list_id.setAdapter(adapter);
                break;
        }
    }


    private void initNoLinkOptionsPicker() {//
        pvNoLinkOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                mTime.setText(typeInfo.get(options1));
                time=new ArrayList<>();
                for (int i=1;i<=12;i++){
                    if(i<10){
                        time.add(typeInfo.get(options1)+"年"+"0"+i+"月");
                    }else{
                        time.add(typeInfo.get(options1)+"年"+i+"月");
                    }

                }

            }
        })
                .setItemVisibleCount(10)
                .setLineSpacingMultiplier(2.0f)
                .setSelectOptions(0, 0, 0)
                .setOutSideCancelable(false)
                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                .setSubmitColor(getResources().getColor(R.color.num4))//确定按钮文字颜色
                .setTitleBgColor(getResources().getColor(R.color.white))//标题背景颜色 Night mode
                .setCancelColor(getResources().getColor(R.color.black))//取消按钮文字颜色
                .build();
    }
}
