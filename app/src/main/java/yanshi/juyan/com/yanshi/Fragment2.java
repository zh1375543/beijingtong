package yanshi.juyan.com.yanshi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * on 2022/1/18
 *
 * @Author zhanghui
 * @Description
 */
public class Fragment2 extends Fragment {

    @InjectView(R.id.tv_start)
    TextView mStart;
    @InjectView(R.id.tv_end)
    TextView mEnd;
    @InjectView(R.id.tv_check)
    TextView mCheck;

    @InjectView(R.id.recycle)
    RecyclerView mRecycle;

    @InjectView(R.id.tv_data_tip)
    TextView mTip;
    public static TimePickerView pvTime;
    private int index=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laout2, container, false);
        ButterKnife.inject(this, view);
        initTimePicker(getActivity());
        Date d = new Date();
        SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd");
        mEnd.setText(sbf.format(d));
        return view;
    }
    public static Fragment2 newInstance(int type) {
        Fragment2 fragment = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putInt("puhsType", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @OnClick({R.id.tv_start,R.id.tv_end,R.id.tv_check})
    public void Onclick(View view){

        switch (view.getId()){
            case R.id.tv_start:
                index=1;
               pvTime.show(view);
                break;
            case R.id.tv_end:
                index=2;
                pvTime.show(view);
                break;
            case R.id.tv_check:
                mRecycle.addItemDecoration(new RecycleDecoration(getActivity()));
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                mRecycle.setLayoutManager(manager);
                BooksAdapter adapter = new BooksAdapter(getActivity());
                mRecycle.setAdapter(adapter);
                mTip.setVisibility(View.VISIBLE);
                break;
        }
    }



    public  void initTimePicker(Context context) {//Dialog 模式下，在底部弹出
        Calendar selectedDate = Calendar.getInstance();//系统当前时间

        Calendar endDate = Calendar.getInstance();
        int year=endDate.get(Calendar.YEAR);
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(year+"-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        selectedDate.setTime(date);

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
             if(index==1){
                 mStart.setText(getTime(date));
             }else{
                 mEnd.setText(getTime(date));
             }
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .setItemVisibleCount(10) //若设置偶数，实际值会加1（比如设置6，则最大可见条目为7）
                .setLineSpacingMultiplier(2.0f)
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setTitleBgColor(getResources().getColor(R.color.white))//标题背景颜色 Night mode
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
}
