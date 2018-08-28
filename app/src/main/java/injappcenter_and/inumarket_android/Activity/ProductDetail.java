package injappcenter_and.inumarket_android.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

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
    ImageButton btnClosePopup, btnClose;
    PopupWindow pwindo,pwsendindo;

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
        Button sellerproduct = findViewById(R.id.btn_productdetail_otherproduct);
        sellerproduct.setOnClickListener(this);

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
            case R.id.btn_productdetail_otherproduct: {
                Intent intent_seller = new Intent(getApplicationContext(), sellerProduct.class);
                startActivity(intent_seller);

                finish();
                break;
            }
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
                initiatePopupWindow_beforesend();
                break;
            }

            case R.id.txt_popup_letter_cancle: case R.id.btn_popup_letter_close: {
                pwsendindo.dismiss();
                break;
            }
            case R.id.txt_popup_letter_send:{
                pwsendindo.dismiss();
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

    private void initiatePopupWindow_beforesend() {
        try {
            View layout = getLayoutInflater().inflate(R.layout.popup_product_letter,null);

            pwsendindo = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true);
            pwsendindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwsendindo.setAnimationStyle(-1);
            btnClose = layout.findViewById(R.id.btn_popup_letter_close);
            btnClose.setOnClickListener(this);
            TextView txtcencle = layout.findViewById(R.id.txt_popup_letter_cancle);
            txtcencle.setOnClickListener(this);
            TextView txtsend = layout.findViewById(R.id.txt_popup_letter_send);
            txtsend.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
