package injappcenter_and.inumarket_android.Fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class uploadRVDecorator extends RecyclerView.ItemDecoration{
    private final int divHeight;
    private final int divWeight;

    public uploadRVDecorator(int divHeight, int divWeight){
        this.divHeight = divHeight;
        this.divWeight = divWeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = divHeight;
        outRect.left = divWeight;
    }
}
