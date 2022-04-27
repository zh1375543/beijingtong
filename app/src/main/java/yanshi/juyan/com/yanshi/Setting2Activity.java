package yanshi.juyan.com.yanshi;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * on 2022/1/22
 *
 * @Author zhanghui
 * @Description
 */
public class Setting2Activity extends BaseActivity {

    @InjectView(R.id.et_name_user1)
    EditText nName;


    @InjectView(R.id.et_name_danwei)
    EditText nDan;

    @InjectView(R.id.et_pay_1)
    EditText nPay1;
    @InjectView(R.id.et_mouth_1)
    EditText nMouth1;
    @InjectView(R.id.et_data_1)
    EditText nData1;
    @InjectView(R.id.et_money_1)
    EditText nMoney1;

    @InjectView(R.id.et_pay_2)
    EditText nPay2;
    @InjectView(R.id.et_mouth_2)
    EditText nMouth2;
    @InjectView(R.id.et_data_2)
    EditText nData2;
    @InjectView(R.id.et_money_2)
    EditText nMoney2;

    @InjectView(R.id.et_pay_3)
    EditText nPay3;
    @InjectView(R.id.et_mouth_3)
    EditText nMouth3;
    @InjectView(R.id.et_data_3)
    EditText nData3;
    @InjectView(R.id.et_money_3)
    EditText nMoney3;

    @InjectView(R.id.et_pay_4)
    EditText nPay4;
    @InjectView(R.id.et_mouth_4)
    EditText nMouth4;
    @InjectView(R.id.et_data_4)
    EditText nData4;
    @InjectView(R.id.et_money_4)
    EditText nMoney4;


    @InjectView(R.id.et_pay_5)
    EditText nPay5;
    @InjectView(R.id.et_mouth_5)
    EditText nMouth5;
    @InjectView(R.id.et_data_5)
    EditText nData5;
    @InjectView(R.id.et_money_5)
    EditText nMoney5;

    @InjectView(R.id.et_pay_6)
    EditText nPay6;
    @InjectView(R.id.et_mouth_6)
    EditText nMouth6;
    @InjectView(R.id.et_data_6)
    EditText nData6;
    @InjectView(R.id.et_money_6)
    EditText nMoney6;


    @InjectView(R.id.et_pay_61)
    EditText nPay61;
    @InjectView(R.id.et_mouth_61)
    EditText nMouth61;
    @InjectView(R.id.et_data_61)
    EditText nData61;
    @InjectView(R.id.et_money_61)
    EditText nMoney61;

    @InjectView(R.id.et_pay_7)
    EditText nPay7;
    @InjectView(R.id.et_mouth_7)
    EditText nMouth7;
    @InjectView(R.id.et_data_7)
    EditText nData7;
    @InjectView(R.id.et_money_7)
    EditText nMoney7;

    @InjectView(R.id.et_pay_8)
    EditText nPay8;
    @InjectView(R.id.et_mouth_8)
    EditText nMouth8;
    @InjectView(R.id.et_data_8)
    EditText nData8;
    @InjectView(R.id.et_money_8)
    EditText nMoney8;

    @InjectView(R.id.et_pay_9)
    EditText nPay9;
    @InjectView(R.id.et_mouth_9)
    EditText nMouth9;
    @InjectView(R.id.et_data_9)
    EditText nData9;
    @InjectView(R.id.et_money_9)
    EditText nMoney9;

    @InjectView(R.id.et_pay_10)
    EditText nPay10;
    @InjectView(R.id.et_mouth_10)
    EditText nMouth10;
    @InjectView(R.id.et_data_10)
    EditText nData10;
    @InjectView(R.id.et_money_10)
    EditText nMoney10;

    @InjectView(R.id.et_pay_11)
    EditText nPay11;
    @InjectView(R.id.et_mouth_11)
    EditText nMouth11;
    @InjectView(R.id.et_data_11)
    EditText nData11;
    @InjectView(R.id.et_money_11)
    EditText nMoney11;

    @InjectView(R.id.et_pay_12)
    EditText nPay12;
    @InjectView(R.id.et_mouth_12)
    EditText nMouth12;
    @InjectView(R.id.et_data_12)
    EditText nData12;
    @InjectView(R.id.et_money_12)
    EditText nMoney12;


    @InjectView(R.id.et_hui_1)
    EditText nHui1;
    @InjectView(R.id.et_hui_2)
    EditText nHui2;
    @InjectView(R.id.et_hui_3)
    EditText nHui3;
    @InjectView(R.id.et_hui_4)
    EditText nHui4;
    @InjectView(R.id.et_hui_5)
    EditText nHui5;
    @InjectView(R.id.et_hui_6)
    EditText nHui6;
    @InjectView(R.id.et_hui_61)
    EditText nHui61;
    @InjectView(R.id.et_hui_7)
    EditText nHui7;
    @InjectView(R.id.et_hui_8)
    EditText nHui8;
    @InjectView(R.id.et_hui_9)
    EditText nHui9;
    @InjectView(R.id.et_hui_10)
    EditText nHui10;
    @InjectView(R.id.et_hui_11)
    EditText nHui11;
    @InjectView(R.id.et_hui_12)
    EditText nHui12;



    @InjectView(R.id.btn_submit1)
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);
        header = new Header(this, "");
        header.setTitle("公积金设置");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(nName.getText().toString().trim())){
                    Tools.nameGongjiJ=nName.getText().toString().trim();
                }
                if(!TextUtils.isEmpty(nDan.getText().toString().trim())){
                    Tools.danweiGongjiJ=nDan.getText().toString().trim();
                }

                GJinfos gJinfos=new GJinfos();

                List<GJinfos.MyInfos> list1=new ArrayList<>();

                GJinfos.MyInfos myInfos2=new GJinfos.MyInfos(nPay2.getText().toString().trim(),nMouth2.getText().toString().trim(),nData2.getText().toString().trim(),nMoney2.getText().toString().trim(),nHui2.getText().toString().trim());
                GJinfos.MyInfos myInfos=new GJinfos.MyInfos(nPay1.getText().toString().trim(),nMouth1.getText().toString().trim(),nData1.getText().toString().trim(),nMoney1.getText().toString().trim(),nHui1.getText().toString().trim());
                GJinfos.MyInfos myInfos12=new GJinfos.MyInfos(nPay12.getText().toString().trim(),nMouth12.getText().toString().trim(),nData12.getText().toString().trim(),nMoney12.getText().toString().trim(),nHui12.getText().toString().trim());
                GJinfos.MyInfos myInfos11=new GJinfos.MyInfos(nPay11.getText().toString().trim(),nMouth11.getText().toString().trim(),nData11.getText().toString().trim(),nMoney11.getText().toString().trim(),nHui11.getText().toString().trim());
                GJinfos.MyInfos myInfos10=new GJinfos.MyInfos(nPay10.getText().toString().trim(),nMouth10.getText().toString().trim(),nData10.getText().toString().trim(),nMoney10.getText().toString().trim(),nHui10.getText().toString().trim());
                GJinfos.MyInfos myInfos9=new GJinfos.MyInfos(nPay9.getText().toString().trim(),nMouth9.getText().toString().trim(),nData9.getText().toString().trim(),nMoney9.getText().toString().trim(),nHui9.getText().toString().trim());
                GJinfos.MyInfos myInfos8=new GJinfos.MyInfos(nPay8.getText().toString().trim(),nMouth8.getText().toString().trim(),nData8.getText().toString().trim(),nMoney8.getText().toString().trim(),nHui8.getText().toString().trim());
                GJinfos.MyInfos myInfos7=new GJinfos.MyInfos(nPay7.getText().toString().trim(),nMouth7.getText().toString().trim(),nData7.getText().toString().trim(),nMoney7.getText().toString().trim(),nHui7.getText().toString().trim());
                GJinfos.MyInfos myInfos6=new GJinfos.MyInfos(nPay6.getText().toString().trim(),nMouth6.getText().toString().trim(),nData6.getText().toString().trim(),nMoney6.getText().toString().trim(),nHui6.getText().toString().trim());
                GJinfos.MyInfos myInfos61=new GJinfos.MyInfos(nPay61.getText().toString().trim(),nMouth61.getText().toString().trim(),nData61.getText().toString().trim(),nMoney61.getText().toString().trim(),nHui61.getText().toString().trim());
                GJinfos.MyInfos myInfos5=new GJinfos.MyInfos(nPay5.getText().toString().trim(),nMouth5.getText().toString().trim(),nData5.getText().toString().trim(),nMoney5.getText().toString().trim(),nHui5.getText().toString().trim());
                GJinfos.MyInfos myInfos4=new GJinfos.MyInfos(nPay4.getText().toString().trim(),nMouth4.getText().toString().trim(),nData4.getText().toString().trim(),nMoney4.getText().toString().trim(),nHui4.getText().toString().trim());
                GJinfos.MyInfos myInfos3=new GJinfos.MyInfos(nPay3.getText().toString().trim(),nMouth3.getText().toString().trim(),nData3.getText().toString().trim(),nMoney3.getText().toString().trim(),nHui3.getText().toString().trim());




                if(!TextUtils.isEmpty(myInfos.getPay())){
                    list1.add(myInfos);
                }
                if(!TextUtils.isEmpty(myInfos2.getPay())){
                    list1.add(myInfos2);
                }
                if(!TextUtils.isEmpty(myInfos3.getPay())){
                    list1.add(myInfos3);
                }
                if(!TextUtils.isEmpty(myInfos4.getPay())){
                    list1.add(myInfos4);
                }
                if(!TextUtils.isEmpty(myInfos5.getPay())){
                    list1.add(myInfos5);
                }
                if(!TextUtils.isEmpty(myInfos6.getPay())){
                    list1.add(myInfos6);
                }
                if(!TextUtils.isEmpty(myInfos61.getPay())){
                    list1.add(myInfos61);
                }
                if(!TextUtils.isEmpty(myInfos7.getPay())){
                    list1.add(myInfos7);
                }
                if(!TextUtils.isEmpty(myInfos8.getPay())){
                    list1.add(myInfos8);
                }
                if(!TextUtils.isEmpty(myInfos9.getPay())){
                    list1.add(myInfos9);
                }
                if(!TextUtils.isEmpty(myInfos10.getPay())){
                    list1.add(myInfos10);
                }
                if(!TextUtils.isEmpty(myInfos11.getPay())){
                    list1.add(myInfos11);
                }
                if(!TextUtils.isEmpty(myInfos12.getPay())){
                    list1.add(myInfos12);
                }
//                list1.add(myInfos2);
//                list1.add(myInfos3);
//                list1.add(myInfos4);
//                list1.add(myInfos5);
//                list1.add(myInfos6);
//                list1.add(myInfos61);
//                list1.add(myInfos7);
//                list1.add(myInfos8);
//                list1.add(myInfos9);
//                list1.add(myInfos10);
//                list1.add(myInfos11);
//                list1.add(myInfos12);

                gJinfos.setInfosList(list1);
                finish();
            }
        });



    }
}
