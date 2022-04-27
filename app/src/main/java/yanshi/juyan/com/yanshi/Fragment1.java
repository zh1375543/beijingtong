package yanshi.juyan.com.yanshi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * on 2022/1/18
 *
 * @Author zhanghui
 * @Description
 */
public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laout1, container, false);
        ButterKnife.inject(this, view);
        return view;
    }
    public static Fragment1 newInstance(int type) {
        Fragment1 fragment = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putInt("puhsType", type);
        fragment.setArguments(bundle);
        return fragment;
    }

}
