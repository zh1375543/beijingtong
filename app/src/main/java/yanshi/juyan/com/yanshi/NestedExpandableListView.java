package yanshi.juyan.com.yanshi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

/**
 * on 2022/1/18
 *
 * @Author zhanghui
 * @Description
 */
public class NestedExpandableListView extends ExpandableListView {

    public NestedExpandableListView(Context context) {
        super(context);
    }



    public NestedExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NestedExpandableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom);
        ViewGroup.LayoutParams params = getLayoutParams(); // 存在一个问题 ，如果是全部收起的话 ，就会导致页面空白
        params.height = getMeasuredHeight();

    }
}
