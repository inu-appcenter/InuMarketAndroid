package injappcenter_and.inumarket_android.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;

import injappcenter_and.inumarket_android.Activity.Login_main;
import injappcenter_and.inumarket_android.R;

public class Start_inum extends AppCompatActivity{

    private Layout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start_inum);
    }

    public void click_inum(View view) {
        Intent intent_inum = new Intent(getApplicationContext(), Login_main.class);
        startActivity(intent_inum);
        finish();
    }
}
