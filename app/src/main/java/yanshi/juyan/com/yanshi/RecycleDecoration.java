package yanshi.juyan.com.yanshi;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


//recycleview前后间距
public class RecycleDecoration extends RecyclerView.ItemDecoration {
  private int margin;

  public RecycleDecoration(Context context) {
    margin = context.getResources().getDimensionPixelSize(R.dimen.recy_item_margin);
  }

  public RecycleDecoration(Context context, int pix) {
    margin = pix;
  }

  @Override
  public void getItemOffsets(
          Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    outRect.set(0, margin, 0, 0);
  }
}