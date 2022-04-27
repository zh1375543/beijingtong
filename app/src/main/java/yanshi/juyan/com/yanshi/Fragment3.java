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
public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laout3, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    public static Fragment3 newInstance(int type) {
        Fragment3 fragment = new Fragment3();
        Bundle bundle = new Bundle();
        bundle.putInt("puhsType", type);
        fragment.setArguments(bundle);
        return fragment;
    }
}
