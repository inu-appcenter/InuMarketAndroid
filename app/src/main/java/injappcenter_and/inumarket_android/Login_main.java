package injappcenter_and.inumarket_android;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;


public class Login_main extends AppCompatActivity implements View.OnClickListener{


    private FragmentManager frg_start;
    private TextView errtxt;
    private EditText pw_e_txt,id_e_txt;
    private ImageButton login_btn;
    private Button join_btn, fgt_pw_btn;
    private boolean i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
        id_e_txt = findViewById(R.id.et_login_student_id);
        pw_e_txt = findViewById(R.id.et_login_pw);
        errtxt = findViewById(R.id.txt_login_err);
        login_btn = findViewById(R.id.btn_login_login);
        join_btn = findViewById(R.id.btn_login_join);
        fgt_pw_btn = findViewById(R.id.btn_login_forgot_pw);

        join_btn.setOnClickListener(this);
        fgt_pw_btn.setOnClickListener(this);
        login_btn.setOnClickListener(this);

        id_e_txt.getText().toString();
        pw_e_txt.getText().toString();


    }

    public void onClick(View v){
        switch(v.getId()) {

            case R.id.btn_login_login:
            {
            //메인화면으로 전환
                Intent intent_login = new Intent(getApplicationContext(), Main.class);
                startActivity(intent_login);
                break;
            }

            case R.id.btn_login_forgot_pw:
            {
                Intent intent_pw = new Intent(getApplicationContext(), forgot_pw.class);
                startActivity(intent_pw);
                break;
            }
            /* case R.id.btn_login_join:
            {
                // 회원가입화면으로 전환
                Intent intent_join = new Intent(getApplicationContext(), join.class);
                startActivity(intent_join);
                break;
            }*/
        }
    }

}
