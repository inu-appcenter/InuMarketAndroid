package injappcenter_and.inumarket_android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import injappcenter_and.inumarket_android.Model.LoginResult;
import injappcenter_and.inumarket_android.Retrofit.LoginRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class forgot_pw extends AppCompatActivity {

    private TextView noinput_txt, notcollect_txt;
    private EditText name_edit, stdid_edit;
    private int count;
    private boolean j,k ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);}

        notcollect_txt = findViewById(R.id.txt_forgot_pw_notcollect);
        noinput_txt = findViewById(R.id.txt_forgot_pw_noinput);
        name_edit = findViewById(R.id.et_forgot_pw_name);
        stdid_edit = findViewById(R.id.et_forgot_pw_stdid);

    }

    public void click_email(View view) {
        String name = name_edit.getText().toString();
        String stdid = stdid_edit.getText().toString();
        if ((name.length() > 2) && (stdid.length() == 9)) {
            // 서버통신 추가 예정
            noinput_txt.setVisibility(View.INVISIBLE);



            AlertDialog.Builder builder = new AlertDialog.Builder(forgot_pw.this);
            builder.setTitle("");
            builder.setMessage("인천대 포탈 웹메일로 임시 비밀번호가 발송되었습니다!");
            builder.setPositiveButton("확인", null);
            builder.show();
        }
        else
            noinput_txt.setVisibility(View.VISIBLE);
    }
}

