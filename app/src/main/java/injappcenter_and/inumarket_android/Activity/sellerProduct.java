package injappcenter_and.inumarket_android.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Model.Recycler_product_main;
import injappcenter_and.inumarket_android.Model.nonSellResult;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.Mainproduct_Adapter;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sellerProduct extends AppCompatActivity {
    RecyclerView recyclerView;
    Mainproduct_Adapter mAdapter;
    ArrayList<Recycler_product_main> list = new ArrayList<>();
    private TabLayout tabLayout;
    SharedPreferences pref;
    String productid, name;
    Integer price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_product);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        tabLayout = findViewById(R.id.tab_product);
        tabLayout.addTab(tabLayout.newTab().setText("판매중"));
        tabLayout.addTab(tabLayout.newTab().setText("판매완료"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        TextView tv1 = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(0)).getChildAt(1));
        tv1.setScaleY(-1);
        tv1.setTextSize(18);
        TextView tv2 = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(1)).getChildAt(1));
        tv2.setScaleY(-1);
        tv2.setTextSize(18);

        Intent intent_seller = getIntent();
        String sellerid = intent_seller.getStringExtra("sellerid");
        Log.d("sellerid_intent", sellerid);

        pref = getSharedPreferences("userinfo",MODE_PRIVATE);
        String token =  pref.getString("token","");
        Singleton.retrofit.nonsell(token,sellerid).enqueue(new Callback<ArrayList<nonSellResult>>() {
            @Override
            public void onResponse(Call<ArrayList<nonSellResult>> call, Response<ArrayList<nonSellResult>> response) {
                if (response.isSuccessful()) {
                    ArrayList<nonSellResult> result = response.body();
                    Log.d("nonselltest", "판매자로 물건조회" + result.get(0).getProductId());
                    for (int i = 0 ; i < result.size() ; i++){
                        name = result.get(i).getProductName();
                        price = result.get(i).getProductPrice();
                        productid = result.get(i).getProductId();
                        list.add(new Recycler_product_main(R.color.grey8 , name , String.valueOf(price), productid));
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<nonSellResult>> call, Throwable t) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_sellerproduct);
        recyclerView.setHasFixedSize(true);
        mAdapter = new Mainproduct_Adapter(list);
        mAdapter.setItemClick(new Mainproduct_Adapter.ItemClick() {
            @Override
            public void onClick(View view, int position) {
                Intent intent_detail = new Intent(getApplicationContext(),ProductDetail.class);
                startActivity(intent_detail);
                finish();
            }
        });
        RecyclerView.LayoutManager mLayoutManager;
        mLayoutManager = new GridLayoutManager(getApplicationContext(),3);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
