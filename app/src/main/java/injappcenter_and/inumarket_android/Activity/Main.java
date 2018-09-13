package injappcenter_and.inumarket_android.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import injappcenter_and.inumarket_android.Fragment.Fragment_searchresult;
import injappcenter_and.inumarket_android.Fragment.main_product;
import injappcenter_and.inumarket_android.Model.Recycler_product_main;
import injappcenter_and.inumarket_android.R;

import static injappcenter_and.inumarket_android.R.id.drawer;
import static injappcenter_and.inumarket_android.R.id.fragment_Main_product;
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
    public ConstraintLayout search_ing;

    private final long FINISH_INTERVAL_TIME = 2000;
    private long   backPressedTime = 0;

    String token;
    @SuppressLint("ClickableViewAccessibility")
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

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        main_product product = new main_product();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_Main_product,product)
        .commit();


        et_search = findViewById(R.id.et_main_search);
        final Button btn_searchcancle = findViewById(R.id.btn_main_search_cancle);
        final ImageButton btn_search_erase = findViewById(R.id.btn_main_search_erase);

        btn_searchcancle.setOnClickListener(this);
        btn_search_erase.setOnClickListener(this);

        et_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    btn_search_erase.setVisibility(View.VISIBLE);
                    btn_searchcancle.setVisibility(View.VISIBLE);
                    findViewById(R.id.fragment_Main_product).setVisibility(View.INVISIBLE);
                }
                else {
                    basicset();
                }
            }
        });

        et_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == event.KEYCODE_ENTER)) {
                    //Enter키눌렀을떄 처리
                    Fragment_searchresult searchproduct = new Fragment_searchresult();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_Main_product, searchproduct)
                            .addToBackStack(null)
                            .commit();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        if (drawerLayout.isDrawerOpen(findViewById(R.id.drawer_main_mypage))||drawerLayout.isDrawerOpen(findViewById(R.id.drawer_main_category))) {
            drawerLayout.closeDrawers();
        }
        else if (findViewById(R.id.fragment_Main_product).getVisibility() == View.VISIBLE){
            long tempTime = System.currentTimeMillis();
            long intervalTime = tempTime - backPressedTime;
            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
                super.onBackPressed();
            } else {
                backPressedTime = tempTime;
                Toast.makeText(getApplicationContext(), "버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        switch(view.getId()){
            case R.id.btn_main_search_cancle:{
                et_search.setVisibility(View.VISIBLE);
                et_search.setText("");
                findViewById(R.id.fragment_Main_product).setVisibility(View.VISIBLE);
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(et_search.getWindowToken(),0);
                findViewById(R.id.btn_main_search_erase).setVisibility(View.INVISIBLE);
                findViewById(R.id.btn_main_search_cancle).setVisibility(View.INVISIBLE);
                break;
            }

            case R.id.btn_main_search_erase: {
                et_search.setText("");
                findViewById(R.id.fragment_constraint).setVisibility(View.INVISIBLE);
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

    public void basicset(){
        findViewById(R.id.fragment_Main_product).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_main_search_erase).setVisibility(View.INVISIBLE);
        findViewById(R.id.btn_main_search_cancle).setVisibility(View.INVISIBLE);
    }
}
