package injappcenter_and.inumarket_android.Viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
public class CircleIndicator extends LinearLayout{

    private Context mContext;
    //원 사이의 간격
    private int itemMargin = 9;

    private int mDefaultCircle;
    private int mSelectCircle;

    private ImageView[] imageDot;

    public void setItemMargin(int itemMargin) {
        this.itemMargin = itemMargin;
    }

    public CircleIndicator(Context context) {
        super(context);

        mContext = context;
    }

    public CircleIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
    }

    /**
     * 기본 점 생성
     * @param count 점의 갯수
     * @param defaultCircle 점의 이미지
     */
    public void createDotPanel(int count , int defaultCircle , int selectCircle) {

        mDefaultCircle = defaultCircle;
        mSelectCircle = selectCircle;

        imageDot = new ImageView[count];

        for (int i = 0; i < count; i++) {

            imageDot[i] = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.topMargin = itemMargin;
            params.bottomMargin = itemMargin;
            params.leftMargin = itemMargin;
            params.rightMargin = itemMargin;
            params.gravity = Gravity.CENTER;

            imageDot[i].setLayoutParams(params);
            imageDot[i].setImageResource(defaultCircle);
            imageDot[i].setTag(imageDot[i].getId(), false);
            this.addView(imageDot[i]);
        }
        //첫인덱스 선택
        selectDot(0);
    }

    /**
     * 선택된 점 표시
     * @param position
     */
    public void selectDot(int position) {

        for (int i = 0; i < imageDot.length; i++) {
            if (i == position) {
                imageDot[i].setImageResource(mSelectCircle);
            } else {

                if((boolean)imageDot[i].getTag(imageDot[i].getId()) == true){
                    imageDot[i].setImageResource(mDefaultCircle);
                }
            }
        }
    }

}