package injappcenter_and.inumarket_android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(Color.WHITE);
        }

    }

    public void forgotpw(View view) {
        Intent intent = new Intent(getApplicationContext(),forgot_pw.class);
        startActivity(intent);
    }

    /*
    public void join_click(View view) {
        Intent intent = new Intent(getApplicationContext(),join.class);
    }
    */
    /* private void visibletxt(){
        if()
    }
*/

}
