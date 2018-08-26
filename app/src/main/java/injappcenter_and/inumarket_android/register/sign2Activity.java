package injappcenter_and.inumarket_android.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.register.utils.Const;

public class sign2Activity extends AppCompatActivity {
    TextView message;
    EditText schoolnum;
    EditText name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_student);

        message = (TextView)findViewById(R.id.message);

        name1 = (EditText) findViewById(R.id.name1);
        schoolnum = (EditText) findViewById(R.id.schoolnum);
        ImageView img_next = (ImageView) findViewById(R.id.img_next);


        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name1.getText().toString().trim().length()>0 || schoolnum.getText().toString().trim().length()>0) {
                    Intent intent = new Intent(sign2Activity.this,sign3Activity.class);

                    message.setText("");

                    intent.putExtra(Const.CONST_NAME, name1.getText().toString().trim());
                    intent.putExtra(Const.CONST_SCHOOL_NUM, schoolnum.getText().toString().trim());
                    startActivity(intent);

                }


                else{
                    message.setText("학생정보를 입력해야됩니다");
                }
            }
        });
    }
}