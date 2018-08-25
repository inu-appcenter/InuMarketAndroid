package injappcenter_and.inumarket_android.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.register.utils.Const;

public class sign4Activity extends AppCompatActivity {
    TextView message;
    EditText phone_num;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntent = getIntent();
        // sign4 액티비티도 sign3 액티비티랑 똑같은 과정을 거칩니다. getIntent로 전달받은 데이터를 mIntent에 셋팅
         Log.d("TEST", mIntent.getStringExtra(Const.CONST_NAME));// 이런 형식으로 원하는 데이터를 하나씩 뽑아서 활용하시면 됩니다. 감사합니다

         // 이런식으로 가시면 됩니다 // 네 이런식으로 sign5 액티비티 까지 가세요 // 어떤식으로 하신건가요?

        setContentView(R.layout.sign_mobile);

        message = (TextView) findViewById(R.id.message);
        phone_num = (EditText) findViewById(R.id.phone_num);
        ImageView img_next = (ImageView) findViewById(R.id.img_next);

//        final Intent intent = new Intent(sign4Activity.this,sign5Activity.class);

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone_num.length() == 0 ) {
                    message.setText("* 핸드폰번호를 입력해야 합니다.");
                } else {
                    message.setText("");
                    // sign3 에서 했던거랑 똑같죠? 넵!

                    //sign5 에서도 역시 getintent로 받아오셔서
                    mIntent.setClass(getApplicationContext(), sign5Activity.class);
                    mIntent.putExtra(Const.CONST_PHONE, phone_num.getText().toString());

                    startActivity(mIntent);

                }
            }
        });
    }
}
