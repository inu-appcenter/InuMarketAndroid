package injappcenter_and.inumarket_android;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class forgot_pw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(Color.WHITE);}
    }
}

