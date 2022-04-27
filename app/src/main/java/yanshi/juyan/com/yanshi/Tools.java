package yanshi.juyan.com.yanshi;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * on 2022/1/17
 *
 * @Author zhanghui
 * @Description
 */
public class Tools {
    public static TimePickerView pvTime;

    public static String Info1="";
    public static String Info2="";
    public static String name="";
    public static String mPany="";
    public static String mPanyNum="";
    public static String mType="";
    public static String mYearNum="";


    public static String newInifo1;
    public static String newInifo2;
    public static String newInifo3;

    public static String nameGongjiJ;
    public static String danweiGongjiJ;
    public static void initTimePicker(final TextView textView, Context context) {//Dialog 模式下，在底部弹出
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        Calendar endDate = Calendar.getInstance();
        int year=endDate.get(Calendar.YEAR);
        int month = (endDate.get(Calendar.MONTH)) + 1;
        //设置时间格式
        SimpleDateFormat format = new SimpleDateFormat("dd");
        //设置最后一天
        endDate.set(Calendar.DAY_OF_MONTH, endDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        //最后一天格式化
        String lastDay = format.format(endDate.getTime());
        endDate.set(year, month, Integer.parseInt(lastDay));
        pvTime = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                textView.setText(getTime(date));
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .setItemVisibleCount(10) //若设置偶数，实际值会加1（比如设置6，则最大可见条目为7）
                .setLineSpacingMultiplier(2.0f)
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("","","","","","")//默认设置为年月日时分秒
                .setSubmitColor(context.getResources().getColor(R.color.black))//确定按钮文字颜色
                .setCancelColor(context.getResources().getColor(R.color.black))//取消按钮文字颜色
                .isAlphaGradient(true)
                .build();

        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
                dialogWindow.setDimAmount(0.3f);
            }
        }
    }

    public static String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String getYear(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(date);
    }
    public static String getHour(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    public static List<AddressBean> addInfo(){
        List<AddressBean> beanList=new ArrayList<>();
        AddressBean bean=new AddressBean("测试1","测试11");
        AddressBean bean1=new AddressBean("测试2","测试223");
        AddressBean bean2=new AddressBean("测试3","测试34");
        AddressBean bean3=new AddressBean("测试4","测试45");
        AddressBean bean4=new AddressBean("测试5","测试56");
        AddressBean bean5=new AddressBean("测试6","测试67");
        AddressBean bean6=new AddressBean("测试7","测试78");
        AddressBean bean7=new AddressBean("测试8","测试89");
        AddressBean bean8=new AddressBean("测试9","测试90");
        AddressBean bean9=new AddressBean("测试10","测试109");
        AddressBean bean10=new AddressBean("测试11","测试119");
        AddressBean bean11=new AddressBean("测试12","测试129");
        beanList.add(bean);
        beanList.add(bean1);
        beanList.add(bean2);
        beanList.add(bean3);
        beanList.add(bean4);
        beanList.add(bean5);
        beanList.add(bean6);
        beanList.add(bean7);
        beanList.add(bean8);
        beanList.add(bean9);
        beanList.add(bean10);
        beanList.add(bean11);
        return beanList;
    }



}
