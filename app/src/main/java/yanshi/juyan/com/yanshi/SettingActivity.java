package yanshi.juyan.com.yanshi;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * on 2022/1/18
 *
 * @Author zhanghui
 * @Description
 */
public class SettingActivity extends BaseActivity {


    @InjectView(R.id.et_name_company)
    EditText mInfo1;
    @InjectView(R.id.et_name_address)
    EditText mInfo2;
    @InjectView(R.id.et_name_user)
    EditText mName;
    @InjectView(R.id.et_name_pangy)
    EditText mPany;
    @InjectView(R.id.et_name_pangy_num)
    EditText mPanyNum;
    @InjectView(R.id.et_name_type)
    EditText mType;
    @InjectView(R.id.et_name_times)
    EditText mTimes;



    @InjectView(R.id.et_lao1)
    EditText mLoa1;
    @InjectView(R.id.et_lao2)
    EditText mLoa2;
    @InjectView(R.id.et_lao3)
    EditText mLoa3;
    @InjectView(R.id.et_ye1)
    EditText mYe1;
    @InjectView(R.id.et_ye2)
    EditText mYe2;
    @InjectView(R.id.et_ye3)
    EditText mYe3;
    @InjectView(R.id.et_shang1)
    EditText mshang1;
    @InjectView(R.id.et_shang2)
    EditText mshang2;
    @InjectView(R.id.et_shang3)
    EditText mshang3;


    @InjectView(R.id.et_ye11)
    EditText mYe11;
    @InjectView(R.id.et_ye22)
    EditText mYe22;
    @InjectView(R.id.et_ye33)
    EditText mYe33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        header = new Header(this, "");
        header.setTitle("信息设置");
    }

    @OnClick({R.id.btn_submit})
    public void Onclick(){
          if(!TextUtils.isEmpty(mInfo1.getText().toString().trim())){
              Tools.Info1=mInfo1.getText().toString().trim();
          }
        if(!TextUtils.isEmpty(mInfo2.getText().toString().trim())){
            Tools.Info2=mInfo2.getText().toString().trim();
        }

        if(!TextUtils.isEmpty(mName.getText().toString().trim())){
            Tools.name=mName.getText().toString().trim();
        }
        if(!TextUtils.isEmpty(mPany.getText().toString().trim())){
            Tools.mPany=mPany.getText().toString().trim();
        }
        if(!TextUtils.isEmpty(mPanyNum.getText().toString().trim())){
            Tools.mPanyNum=mPanyNum.getText().toString().trim();
        }
        if(!TextUtils.isEmpty(mType.getText().toString().trim())){
            Tools.mType=mType.getText().toString().trim();
        }
        if(!TextUtils.isEmpty(mTimes.getText().toString().trim())){
            Tools.mYearNum=mTimes.getText().toString().trim();
        }

        if(!TextUtils.isEmpty(mYe11.getText().toString().trim())){
            Tools.newInifo1=mYe11.getText().toString().trim();
        }
        if(!TextUtils.isEmpty(mYe22.getText().toString().trim())){
            Tools.newInifo2=mYe22.getText().toString().trim();
        }
        if(!TextUtils.isEmpty(mYe33.getText().toString().trim())){
            Tools.newInifo3=mYe33.getText().toString().trim();
        }

        Infos  infos=new Infos();

        List<Infos.Info1> num=new ArrayList<>();
        Infos.Info1 info1=new Infos.Info1(mLoa1.getText().toString().trim(),mLoa2.getText().toString().trim(),mLoa3.getText().toString().trim());
        num.add(info1);
        infos.setInfo1(num);

        List<Infos.Info2> num2=new ArrayList<>();
        Infos.Info2 info2=new Infos.Info2(mYe1.getText().toString().trim(),mYe2.getText().toString().trim(),mYe3.getText().toString().trim());
        num2.add(info2);
        infos.setInfo2(num2);


        List<Infos.Info3> num3=new ArrayList<>();
        Infos.Info3 info3=new Infos.Info3(mshang1.getText().toString().trim(),mshang2.getText().toString().trim(),mshang3.getText().toString().trim());
        num3.add(info3);

        infos.setInfo3(num3);
        finish();

    }
}
