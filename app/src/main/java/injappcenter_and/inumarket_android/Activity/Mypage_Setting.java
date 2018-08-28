package injappcenter_and.inumarket_android.Activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import injappcenter_and.inumarket_android.R;

public class Mypage_Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage__setting);

        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}
