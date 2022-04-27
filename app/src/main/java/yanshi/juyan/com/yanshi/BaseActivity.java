package yanshi.juyan.com.yanshi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;

import butterknife.ButterKnife;


/**
 * 项目名: 所有的Activity基类
 * 
 * @author
 *
 */
public  abstract class BaseActivity extends AppCompatActivity {
	public static String CCB = "";// 与V赋值参数
	protected Header header;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	};

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		ButterKnife.inject(this);
	}

	// *
	// 获取参数
	// 这里可以获取打我打开过的网页参数
	public String   args(String k, String defaultValue) {
		Intent intent = this.getIntent();
		String v = intent.getStringExtra(k);
		if (v == null)
			v = defaultValue;
		if (!v.equals("default")) {
			CCB = v;
		}
		return v;

	}

	// log数据
	public void log(String log) {
		Log.e("live", log);
	}

	// 跳转activity
	public void go(Activity a, HashMap<String, String> args) {
		Intent intent = new Intent(a, MainActivity.class);
		if (args != null) {
			Iterator iter = args.entrySet().iterator();
			while (iter.hasNext()) {
				HashMap.Entry entry = (HashMap.Entry) iter.next();
				String k = (String) entry.getKey();
				String v = (String) entry.getValue();

			}
		}
		startActivity(intent);
	}



}
