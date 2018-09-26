package injappcenter_and.inumarket_android.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import injappcenter_and.inumarket_android.Fragment.Fragment_Signup01;
import injappcenter_and.inumarket_android.R;

public class Signup extends AppCompatActivity {
    public android.support.v4.app.FragmentManager fm;
    public FragmentTransaction tr;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        initData();
        initView();


    }

//    @Override
//    public void onBackPressed(){
//        if (Fragment_Signup01 == findViewById(R.id.container_signup).getRootView()){
//            super.onBackPressed();
//            finish();
//        }
//    }

    public void initData() {
        fm = getSupportFragmentManager();
        changetFragment(new Fragment_Signup01());
    }


    public void initView() {

    }

    public void changetFragment(Fragment fragment) {
        tr = fm.beginTransaction();
        tr.replace(R.id.container_signup, fragment);
        tr.addToBackStack(null);
        tr.commit();
    }

}

