package yanshi.juyan.com.yanshi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * on 2022/1/18
 *
 * @Author zhanghui
 * @Description
 */
public class AcumulationActivity extends BaseActivity {
    @InjectView(R.id.sliding_tabs)
    TabLayout mTablaout;
    @InjectView(R.id.viewpager)
    ViewPager mPager;

    @InjectView(R.id.et_g_name)
    EditText mName;
    private FragmentPushAdapter adapter;
    List<Fragment> mFragmentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acumulation);
        header = new Header(this, "");
        header.setTitle("公积金查询");

        if(!TextUtils.isEmpty(Tools.nameGongjiJ)){
            mName.setText(Tools.nameGongjiJ);
        }
        String[] title={"个人总账信息","明细信息","对账单信息"};
        mFragmentList.add(Fragment1.newInstance(1));
        mFragmentList.add(Fragment2.newInstance(2));
        mFragmentList.add(Fragment3.newInstance(3));
        adapter=new FragmentPushAdapter(title,getSupportFragmentManager(),mFragmentList);
        mPager.setAdapter(adapter);
        mTablaout.setupWithViewPager(mPager);
    }
}
