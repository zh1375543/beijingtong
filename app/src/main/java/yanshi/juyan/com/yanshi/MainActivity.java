package yanshi.juyan.com.yanshi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Calendar;

import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.et_main_name)
    EditText mName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = new Header(this, "");
        header.setTitle("权益查询");

        LinearLayout laout1=findViewById(R.id.ll_laout_1);
        laout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SocialInfoActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout laout2=findViewById(R.id.ll_laout_2);
        laout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AcumulationActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout laout3=findViewById(R.id.ll_laout_3);
        laout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout laout4=findViewById(R.id.ll_laout_4);
        laout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Setting2Activity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        if(!TextUtils.isEmpty(Tools.name)){
            mName.setText(Tools.name);
        }
    }
}
