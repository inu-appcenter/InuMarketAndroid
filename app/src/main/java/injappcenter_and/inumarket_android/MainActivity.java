package injappcenter_and.inumarket_android;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private TextView errtxt;
    private EditText pw_e_txt,id_e_txt;
    private ImageButton loginbtn;
    private boolean i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(Color.WHITE);
        }

        id_e_txt = findViewById(R.id.et_login_student_id);
        pw_e_txt = findViewById(R.id.et_login_pw);
        errtxt = findViewById(R.id.txt_login_err);
        loginbtn = findViewById(R.id.btn_login_login);
        String idetxt = id_e_txt.getText().toString();
        String pwetxt = pw_e_txt.getText().toString();

    }

    public void click_forgotpw(View view) {
        Intent intent = new Intent(getApplicationContext(), forgot_pw.class);
        startActivity(intent);
    }

    public void click_loginbtn(View view) {

    }


    /*
    public void join_click(View view) {
        Intent intent = new Intent(getApplicationContext(),join.class);
    }
    */


}
