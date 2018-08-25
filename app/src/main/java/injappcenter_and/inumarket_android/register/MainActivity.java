package injappcenter_and.inumarket_android.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;

public class MainActivity extends AppCompatActivity {
        CheckBox checkBox;
        TextView message;
        protected void  onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            checkBox = (CheckBox)findViewById(R.id.checkbox);
            message = (TextView)findViewById(R.id.message);

            ImageView img_next = (ImageView) findViewById(R.id.img_next);
            img_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkBox.isChecked()==true) {
                        message.setText("");
                        Intent intent = new Intent(MainActivity.this,sign2Activity.class);
                        startActivity(intent);
                    }
                    else{
                        message.setText("* 개인정보 수집에 동의해야 합니다.");

                    }



                }
            });
        }
}

