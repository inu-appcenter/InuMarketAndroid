package injappcenter_and.inumarket_android.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.messaging.FirebaseMessaging;

import injappcenter_and.inumarket_android.Activity.Login_main;
import injappcenter_and.inumarket_android.R;

public class Start_inum extends AppCompatActivity{

    private Layout layout;
    private final int SPLASH_DISPLAY_LENGTH = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start_inum);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent_inum = new Intent(Start_inum.this, Login_main.class);
                Start_inum.this.startActivity(intent_inum);
                Start_inum.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
/*
    public void click_inum(View view) {
        Intent intent_inum = new Intent(getApplicationContext(), Login_main.class);
        startActivity(intent_inum);
        finish();
    }*/
}
