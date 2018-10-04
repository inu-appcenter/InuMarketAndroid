package injappcenter_and.inumarket_android.Activity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

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
    private TextView join_btn, fgt_pw_btn;
    private boolean i;
    CheckBox checkBox;
    String userTel;

    Boolean loginsave;

    private String loginsuc = "logged in success";
    public String usertoken, saveid, savepw, userid, userpw;
    public  SharedPreferences pref_info;
    SharedPreferences.Editor editor;

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
        pref_info = getSharedPreferences("userinfo",MODE_PRIVATE);
        loadlogindata();

        checkBox = findViewById(R.id.checkBox_login);

        editor = pref_info.edit();

        if (loginsave){
            checkBox.setChecked(true);
            id_e_txt.setText(saveid);
            pw_e_txt.setText(savepw);

            Singleton.retrofit.login(saveid,savepw,"notwork").enqueue(new Callback<LoginResult>() {
                @Override
                public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                    if (response.isSuccessful()) {
                        LoginResult result = response.body();
                        if (result != null) {
                            usertoken = result.getToken();
                            userTel = result.getTel();
                            if ((usertoken.length()!=0)&&(loginsuc.equals(result.getMessage()))) {

                                if (!pref_info.getString("token","").equals(usertoken)) {
                                    editor.putString("token", usertoken);
                                    editor.apply();
                                }
                                if (!pref_info.getString("tel","").equals(userTel)){
                                    editor.putString("tel", userTel);
                                    editor.commit();
                                }

                                Log.d("logintest_result_msg", "" + result.message);
                                Log.d("tokencheck", "" + result.token);
                                errtxt_noinput.setVisibility(View.INVISIBLE);
                                errtxt.setVisibility(View.INVISIBLE);
                                Intent intent_login = new Intent(getApplicationContext(), Main.class);
                                startActivity(intent_login);
                                Toast.makeText(getApplicationContext(),"자동 로그인 되었습니다.",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else if (result.getMessage().equals("fail")){
                                Toast.makeText(getApplicationContext(),"아이디와 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show();
                            }
                            else if (result.getMessage().equals("certification")){
                                Toast.makeText(getApplicationContext(),"이메일 인증 후 로그인 해주세요.",Toast.LENGTH_SHORT).show();
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

                }
            });
        }
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.btn_login_login:
            {
                String FCM = "notwork";
                editor.putBoolean("SAVE_LOGIN_DATA", checkBox.isChecked());
                userid = id_e_txt.getText().toString();
                userpw = pw_e_txt.getText().toString();

                if((userid.length()==9)&&(userpw.length()>0)) {
                    errtxt_noinput.setVisibility(View.INVISIBLE);
                    Singleton.retrofit.login(userid, userpw,FCM).enqueue(new Callback<LoginResult>() {
                        @Override
                        public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                            if (response.isSuccessful()) {
                                LoginResult result = response.body();
                                if (result != null) {
                                    usertoken = result.getToken();
                                    userTel = result.getTel();
                                    editor.putString("id",userid);
                                    editor.commit();
                                    if ((usertoken.length()!=0)&&(loginsuc.equals(result.getMessage()))) {

                                        if (!pref_info.getString("token", "").equals(usertoken)){
                                            editor.putString("token",usertoken);
                                            editor.putString("name",result.getName());
                                            editor.commit();
                                        }
                                        if (!pref_info.getString("tel","").equals(userTel)){
                                            editor.putString("tel", userTel);
                                            editor.commit();
                                        }

                                        if ((!saveid.equals(userid))||(!savepw.equals(userpw))){
                                            if (checkBox.isChecked()) {
                                                editor.putString("id", userid);
                                                editor.putString("pw", userpw);
                                                editor.commit();
                                            }
                                        }

                                        Log.d("logintest_result_msg", "" + result.message);
                                        Log.d("tokencheck", "" + result.token);
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
             case R.id.btn_login_join:
            {
                // 회원가입화면으로 전환
                Intent intent_signup = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent_signup);
                break;
            }
        }
    }
    public void loadlogindata(){
        loginsave = pref_info.getBoolean("SAVE_LOGIN_DATA", false);
        saveid = pref_info.getString("id", "");
        savepw = pref_info.getString("pw", "");
    }
}
