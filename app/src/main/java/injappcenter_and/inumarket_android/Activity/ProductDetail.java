package injappcenter_and.inumarket_android.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import injappcenter_and.inumarket_android.Config;
import injappcenter_and.inumarket_android.Model.ProductDetailRetrofit;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import injappcenter_and.inumarket_android.Viewpager.PagerAdapter_product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetail extends AppCompatActivity implements View.OnClickListener{
    Button seller;
    public int[] ImageResource;
    ImageView[] dots;
    LinearLayout pager_indicator;
    private ViewPager viewPager;
    private ArrayList<String> numberList, Productdata;
    me.relex.circleindicator.CircleIndicator circleIndicator;
    //private CircleIndicator
    ProductDetailRetrofit result;
    PagerAdapter_product viewPagerAdapter;
    ImageButton btnClosePopup, btnClose;
    PopupWindow pwindo,pwsendindo;
    SharedPreferences pref;
    String productid, name, state, method, place, category, info,sellerid;
    Integer price, star, dotsCount;
    TextView txtname, txtstate, txtmethod, txtplace, txtcategory, txtinfo, txtprice, txtstar;
    public Intent intent_seller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        ScrollView scrollView = findViewById(R.id.scroll_productdetail);
        scrollView.setSmoothScrollingEnabled(true);
        scrollView.setVerticalScrollBarEnabled(true);

        ImageButton btn_left = findViewById(R.id.btn_productdetail_slideleft);
        ImageButton btn_right = findViewById(R.id.btn_productdetail_slideright);
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        Button btnOpenPopup = findViewById(R.id.btn_productdetail_question);
        btnOpenPopup.setOnClickListener(this);
        seller = findViewById(R.id.btn_productdetail_otherproduct);
        seller.setOnClickListener(this);

        txtname = findViewById(R.id.txt_productdetail_name);
        txtplace = findViewById(R.id.txt_productdetail_dealplace);
        txtprice = findViewById(R.id.txt_productdetail_price);
        txtinfo = findViewById(R.id.txt_productdetail_info);
        txtmethod = findViewById(R.id.txt_productdetail_method);
        txtcategory = findViewById(R.id.txt_productdetail_category);
        txtstate = findViewById(R.id.txt_productdetail_status);
        txtstar = findViewById(R.id.txt_productdetail_current);

        Intent intent = getIntent();
        productid = intent.getStringExtra("id");
        Log.d("requesttest",productid);

        pref = getSharedPreferences("userinfo",MODE_PRIVATE);
        String token = pref.getString("token","");

        viewPager = (ViewPager) findViewById(R.id.viewpager_productdetail_image);
//        viewPager.setInterval(5000);
//        viewPager.startAutoScroll();
        circleIndicator = findViewById(R.id.indicator_productimage);
        circleIndicator.setViewPager(viewPager);

        Productdata = new ArrayList<>();
        result = new ProductDetailRetrofit();

        viewPager.addOnPageChangeListener(mOnPageChangeListener);

        if ( productid != null) {
            Log.d("token,id", "토큰 받은거 확인" + token);
            Singleton.retrofit.detail(token,productid).enqueue(new Callback<ProductDetailRetrofit>() {
                @Override
                public void onResponse(Call<ProductDetailRetrofit> call, Response<ProductDetailRetrofit> response) {

                    if (response.isSuccessful()) {
                        result = response.body();
                        Log.d("detail_lodtest", "상세정보 로딩성공");

                        assert result != null;
                        numberList = new ArrayList<>();
                        numberList.addAll(result.getProductImg());
                        viewPagerAdapter = new PagerAdapter_product(getApplicationContext(),numberList);
                        viewPagerAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
                        viewPager.setAdapter(viewPagerAdapter);
                        sellerid = result.getSellerId();
                        name = result.getProductName();
                        price = result.getProductPrice();
                        state = result.getProductState();
                        method = result.getMethod();
                        place = result.getPlace();
                        category = result.getCategory();
                        info = result.getProductInfo();
                        star = result.getProductStar();

                        Productdata.add(name);
                        Productdata.add(sellerid);
                        Productdata.add(category);

                        intent_seller = new Intent(getApplicationContext(), sellerProduct.class);
                        intent_seller.putExtra("sellerid",sellerid);

                        txtname.setText(name);
                        txtprice.setText(price+"원");
                        txtstar.setText("현재 "+star+"명의 학생들이 문의중입니다!");
                        txtinfo.setText(info);
                        txtplace.setText("- 거래 장소: "+place);
                        txtmethod.setText("- 거래 방식: "+method);
                        txtcategory.setText("- 카테고리: "+category);
                        txtstate.setText("- 거래 상태: "+state);

                    }
                }

                @Override
                public void onFailure(Call<ProductDetailRetrofit> call, Throwable t) {
                    Log.d("fail", "안돼");
                }
            });
        }
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        @Override
        public void onPageSelected(int position) {

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
            case R.id.btn_productdetail_otherproduct:{
                startActivity(intent_seller);
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

            case R.id.btn_popup_close: {
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

            Glide.with(getApplicationContext()).load(Config.serverUrl + "imgload/" + numberList.get(0))
                    .into((ImageView) layout.findViewById(R.id.image_popup_productimage));

            final String username = pref.getString("name","");
            String usertel = pref.getString("tel","");
            final String userid = pref.getString("id","");

            TextView productinfo = (TextView)layout.findViewById(R.id.txt_popup_productinfo);
            productinfo.setText("상품명: "+Productdata.get(0)+"\n\n내 이름: "+username+"\n전화번호: "+usertel);
            btnClosePopup = layout.findViewById(R.id.btn_popup_close);
            btnClosePopup.setOnClickListener(this);
            Button btnOkPopup = layout.findViewById(R.id.btn_popup_ok);
            btnOkPopup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Singleton.retrofit.lettersend(userid,Productdata.get(1), productid, Productdata.get(0),Productdata.get(2))
                            .enqueue(new Callback<JsonObject>() {
                                @Override
                                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                    assert response.body() != null;
                                    JsonObject result = response.body();
                                    Log.d("lettersendtest",""+result);
                                    if(String.valueOf(result.get("ans")).equals("true")){
                                        Toast.makeText(getApplicationContext(),"쪽지가 전송되었습니다.",Toast.LENGTH_SHORT);
                                        pwindo.dismiss();
                                    }
                                }
                                @Override
                                public void onFailure(Call<JsonObject> call, Throwable t) {

                                }
                            });
                }
            });
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
            Glide.with(getApplicationContext()).load(Config.serverUrl + "imgload/" + numberList.get(0))
                    .into((ImageView) layout.findViewById(R.id.image_popup_letter_productimage));

            String username = pref.getString("name","");
            String usertel = pref.getString("tel","");

            TextView product = layout.findViewById(R.id.txt_popup_letter_productinfo);
            product.setText("상품명: "+Productdata.get(0)+"\n\n내 이름: "+username+"\n전화번호: "+usertel);

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
