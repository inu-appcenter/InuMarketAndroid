package injappcenter_and.inumarket_android;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
            getWindow().setStatusBarColor(Color.WHITE);}

        notcollect_txt = findViewById(R.id.txt_forgot_pw_notcollect);
        noinput_txt = findViewById(R.id.txt_forgot_pw_noinput);
        name_edit = findViewById(R.id.et_forgot_pw_name);
        stdid_edit = findViewById(R.id.et_forgot_pw_stdid);
        String name = name_edit.getText().toString();
        String std_id = stdid_edit.getText().toString();

        name_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                String name = s.toString();
                if(name.length()>=3)
                    noinput_txt.setVisibility(View.INVISIBLE);
                else
                    noinput_txt.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        stdid_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               String stdid = charSequence.toString();
                if(stdid.length()==9)
                    noinput_txt.setVisibility(View.INVISIBLE);
                else
                    noinput_txt.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public void click_email(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(forgot_pw.this);
        builder.setTitle("");
        builder.setMessage("인천대 포탈 웹메일로 임시 비밀번호가 발송되었습니다!");
        builder.setPositiveButton("확인",null);
        builder.show();
    }

}

