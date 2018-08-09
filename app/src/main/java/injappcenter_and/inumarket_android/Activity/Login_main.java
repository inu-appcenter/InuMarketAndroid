package injappcenter_and.inumarket_android.Activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

import injappcenter_and.inumarket_android.Model.LoginResult;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Retrofit.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_main extends AppCompatActivity implements View.OnClickListener{

    private FragmentManager frg_start;
    private TextView errtxt,errtxt_noinput;
    private EditText pw_e_txt,id_e_txt;
    private ImageButton login_btn;
    private Button join_btn, fgt_pw_btn;
    private boolean i;

    private String loginsuc = "logged in success";
    public String usertoken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        id_e_txt = findViewById(R.id.et_login_student_id);
        pw_e_txt = findViewById(R.id.et_login_pw);
        errtxt = findViewById(R.id.txt_login_err);
        errtxt_noinput = findViewById(R.id.txt_login_err_noinput);
        login_btn = findViewById(R.id.btn_login_login);
        join_btn = findViewById(R.id.btn_login_join);
        fgt_pw_btn = findViewById(R.id.btn_login_forgot_pw);

        join_btn.setOnClickListener(this);
        fgt_pw_btn.setOnClickListener(this);
        login_btn.setOnClickListener(this);
    }
    public void onClick(View v){

        switch(v.getId()) {


            case R.id.btn_login_login:
            {
                String userid = id_e_txt.getText().toString();
                String userpw = pw_e_txt.getText().toString();

                if((userid.length()==9)&&(userpw.length()>0)) {
                    errtxt_noinput.setVisibility(View.INVISIBLE);
                    Singleton.retrofitLogin.login(userid, userpw).enqueue(new Callback<LoginResult>() {
                        @Override
                        public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                            if (response.isSuccessful()) {
                                LoginResult result = response.body();
                                if (result != null) {

                                    usertoken = result.getToken();
                                    if ((usertoken.length()!=0)&&(loginsuc.equals(result.getMessage()))) {
                                        Log.d("logintest", "" + result.message);
                                        Log.d("test", "" + result.token);
                                        errtxt_noinput.setVisibility(View.INVISIBLE);
                                        errtxt.setVisibility(View.INVISIBLE);
                                        Intent intent_login = new Intent(getApplicationContext(), Main.class);
                                        startActivity(intent_login);
                                        finish();
                                    }
                                }
                            }
                            else {
                                errtxt_noinput.setVisibility(View.INVISIBLE);
                                errtxt.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResult> call, Throwable t) {
                            Log.d("errtxt", "서버연결에러");
                        }
                    });
                }
                else{
                    errtxt_noinput.setVisibility(View.VISIBLE);
                    errtxt.setVisibility(View.INVISIBLE);
                }
                break;
            }

            case R.id.btn_login_forgot_pw:
            {
                //비밀번호 분실화면으로 전환
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
