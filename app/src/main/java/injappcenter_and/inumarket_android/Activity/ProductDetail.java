package injappcenter_and.inumarket_android.Activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Viewpager.CircleIndicator;
import injappcenter_and.inumarket_android.Viewpager.PagerAdapter_product;

public class ProductDetail extends AppCompatActivity implements View.OnClickListener{

    public int[] ImageResource;
    ImageView[] dots;
    LinearLayout pager_indicator;
    int dotsCount;
    private ViewPager viewPager;
    private List<String> numberList;
    private CircleIndicator circleIndicator;
    PagerAdapter_product viewPagerAdapter;
    ImageButton btnClosePopup;
    PopupWindow pwindo;
    int mWidthPixels, mHeightPixels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        ImageButton btn_left = findViewById(R.id.btn_productdetail_slideleft);
        ImageButton btn_right = findViewById(R.id.btn_productdetail_slideright);
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        Button btnOpenPopup = findViewById(R.id.btn_productdetail_question);
        btnOpenPopup.setOnClickListener(this);

        ImageResource = new int[]{
                R.color.blush_pink,
                R.color.pale_salmon,
                R.color.cloudy_blue,
                R.color.warm_grey
        };
        initLayout();
        init();
}
    private void initLayout(){

        viewPager = (ViewPager) findViewById(R.id.viewpager_productdetail_image);
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator_productimage);
    }

    private void init(){
        initViewPager();
    }

    private void initViewPager(){

        viewPagerAdapter = new PagerAdapter_product(getApplicationContext(),ImageResource);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(mOnPageChangeListener);

        //Indicator 초기화
        initIndicaotor();
    }

    private void initIndicaotor(){

        //원사이의 간격
        circleIndicator.setItemMargin(9);
        circleIndicator.createDotPanel(ImageResource.length, R.drawable.default_dot , R.drawable.selected_dot);
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        @Override
        public void onPageSelected(int position) {
            circleIndicator.selectDot(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    public void onClick(View v) {
        int curr = viewPager.getCurrentItem();
        int last = viewPagerAdapter.getCount()-1;
        int next = curr+1;
        int prev = curr-1;
        switch (v.getId()) {
            case R.id.btn_productdetail_slideright:
            {
                if (next>last){
                    viewPager.setCurrentItem(0,false);
                }
                else
                    viewPager.setCurrentItem(next);
                break;
            }
            case R.id.btn_productdetail_slideleft:{
                if(prev<0){
                    viewPager.setCurrentItem(last,false);
                }
                else
                    viewPager.setCurrentItem(prev);
                break;
            }
            case R.id.btn_productdetail_question:{
                initiatePopupWindow();
                break;
            }
            case R.id.btn_popup_close: case R.id.btn_popup_ok: {
                pwindo.dismiss();
                break;
            }
        }

    }

    private void initiatePopupWindow() {
        try {
            View layout = getLayoutInflater().inflate(R.layout.popup_product_letter_sent,null);

            pwindo = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.setAnimationStyle(-1);
            btnClosePopup = layout.findViewById(R.id.btn_popup_close);
            btnClosePopup.setOnClickListener(this);
            Button btnOkPopup = layout.findViewById(R.id.btn_popup_ok);
            btnOkPopup.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
