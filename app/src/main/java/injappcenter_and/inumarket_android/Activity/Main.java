package injappcenter_and.inumarket_android.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import injappcenter_and.inumarket_android.Fragment.main_product;
import injappcenter_and.inumarket_android.Model.Recycler_product_main;
import injappcenter_and.inumarket_android.R;
import static injappcenter_and.inumarket_android.R.id.fragment_category;
import static injappcenter_and.inumarket_android.R.id.btn_main_search_cancle;
import static injappcenter_and.inumarket_android.R.id.container;
import static injappcenter_and.inumarket_android.R.id.drawer_main_category;
import static injappcenter_and.inumarket_android.R.id.invisible;
import static injappcenter_and.inumarket_android.R.id.view;
import static injappcenter_and.inumarket_android.R.id.view_ad;
import static injappcenter_and.inumarket_android.R.id.visible;

public class Main extends AppCompatActivity implements View.OnClickListener{

    private EditText et_search, et_search_ing;
    private FrameLayout frameLayout;
    private ImageButton btncategory, btnmypage;
    private Fragment category,mypage;
    DrawerLayout cDrawer;
    DrawerLayout mDrawer;

    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer = findViewById(R.id.fragment_mypage);
        cDrawer = findViewById(R.id.fragment_category);
        mypage = getSupportFragmentManager().findFragmentById(R.id.drawer_main_mypage);
        category = getSupportFragmentManager().findFragmentById(R.id.drawer_main_category);
        btncategory = findViewById(R.id.btn_main_category);
        btncategory.setOnClickListener(this);
        btnmypage = findViewById(R.id.btn_main_mypage);
        btnmypage.setOnClickListener(this);

        ImageButton closemypage = findViewById(R.id.btn_mypage_closedrawer);
        ImageButton closecategory = findViewById(R.id.btn_category_closedrawer);
        closecategory.setOnClickListener(this);
        closemypage.setOnClickListener(this);

        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        et_search = findViewById(R.id.et_main_search);
        et_search_ing = findViewById(R.id.et_main_search_ing);

        Button btn_searchcancle= findViewById(R.id.btn_main_search_cancle);
        ImageButton btn_search_erase = findViewById(R.id.btn_main_search_erase);

        btn_searchcancle.setOnClickListener(this);
        btn_search_erase.setOnClickListener(this);


        et_search.setVisibility(View.VISIBLE);
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String txt_search = s.toString();
                et_search_ing.setText(txt_search);
                if (s.length() == 0){
                    et_search.setVisibility(View.VISIBLE);
                    et_search_ing.setVisibility(View.INVISIBLE);
                }
                else{
                    et_search.setVisibility(View.INVISIBLE);
                    et_search_ing.setVisibility(View.VISIBLE);
                    findViewById(R.id.btn_main_search_erase).setVisibility(View.VISIBLE);
                    findViewById(R.id.btn_main_search_cancle).setVisibility(View.VISIBLE);
                }

                if(et_search_ing.getVisibility() == View.VISIBLE) {
                    findViewById(R.id.fragment_constraint).setVisibility(View.INVISIBLE);
                }
                else
                    findViewById(R.id.fragment_constraint).setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View view) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        switch(view.getId()){
            case R.id.btn_main_search_cancle:{
                et_search_ing.setVisibility(View.INVISIBLE);
                et_search.setVisibility(View.VISIBLE);
                et_search.setText("");
                findViewById(R.id.btn_main_search_erase).setVisibility(View.INVISIBLE);
                findViewById(R.id.btn_main_search_cancle).setVisibility(View.INVISIBLE);
                findViewById(R.id.fragment_constraint).setVisibility(View.VISIBLE);
                break;
            }

            case R.id.btn_main_search_erase: {
                et_search.setVisibility(View.INVISIBLE);
                et_search_ing.setVisibility(View.VISIBLE);
                findViewById(R.id.fragment_constraint).setVisibility(View.INVISIBLE);
                et_search_ing.setText("");
                et_search.setText("");
                break;
            }
            case R.id.btn_category_closedrawer:{
                    drawer.closeDrawer(Gravity.START);
                    break;
            }
            case R.id.btn_mypage_closedrawer:{
                drawer.closeDrawer(Gravity.END);
                break;
            }
            case R.id.btn_main_category:
            {
                drawer.openDrawer(Gravity.START);
                break;
            }
            case R.id.btn_main_mypage:{
                drawer.openDrawer(Gravity.END);
                break;
            }
        }
    }
}
