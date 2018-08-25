package injappcenter_and.inumarket_android.register;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.register.utils.Const;

public class sign3Activity extends AppCompatActivity {
    TextView message;
    TextView pasword_msg;
    TextView pasword_msg2;
    EditText password1;
    EditText password2;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 전달받은 intent 를 전역변수 mIntent에 넣어두기
        mIntent = getIntent();

        setContentView(R.layout.sign_password);

        message = (TextView) findViewById(R.id.message);
        pasword_msg = (TextView) findViewById(R.id.pasword_msg);
        pasword_msg2 = (TextView) findViewById(R.id.pasword_msg2);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);

        ImageView img_next = (ImageView) findViewById(R.id.img_next);

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password1.getText().toString().trim().length() == 0 || password2.getText().toString().trim().length() == 0) {
                    message.setText("* 비밀번호를 입력해야 합니다.");
                }else if(!password1.getText().toString().trim().equals(password2.getText().toString().trim())){
                    //비밀번호 불일치
                }else{
                    // 다음 버튼을 눌렀을때 다음화면으로 이동해야할 activity 정의
                    mIntent.setClass(getApplicationContext(), sign4Activity.class);
                    // 비밀번호 데이터를 전달받았던 인텐트에 추가

                    mIntent.putExtra(Const.CONST_PASS, password1.getText().toString().trim());
                    startActivity(mIntent);
                }

            }
        });
        password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s)
            {
                String text = s.toString();
                if (text.length() < 8 && text.length() > 0) {
                    message.setText("");
                    pasword_msg.setTextColor(Color.parseColor("#fb3a2f"));
                    pasword_msg.setText("* 8글자 이상 입력해야 합니다.");
                }
                else  {
                    pasword_msg.setTextColor(Color.parseColor("#7bd21c"));
                    pasword_msg.setText("* 사용할 수 있는 비밀번호입니다.");
                }
            }
        });

        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s)
            {
               final String text1 = s.toString();
               final String text2 = password1.getText().toString();

                if(text1.equals(text2)){
                    pasword_msg2.setTextColor(Color.parseColor("#7bd21c"));
                    pasword_msg2.setText("* 비밀번호가 일치합니다.");

                    /*img_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(text1.equals(text2)){

                                Intent intent = new Intent(sign3Activity.this,sign4Activity.class);

                                startActivity(intent);
                            }
                            }


                    });*/

                }
                else {
                    pasword_msg2.setTextColor(Color.parseColor("#fb3a2f"));
                    pasword_msg2.setText("* 비밀번호가 일치하지 않습니다.");
                }
                }
        });


    }
}


