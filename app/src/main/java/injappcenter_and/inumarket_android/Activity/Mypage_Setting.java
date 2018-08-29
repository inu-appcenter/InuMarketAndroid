package injappcenter_and.inumarket_android.Activity;

import android.graphics.Color;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import injappcenter_and.inumarket_android.Dialog.Adapter_dialog;
import injappcenter_and.inumarket_android.Fragment.Fragment_changepw;
import injappcenter_and.inumarket_android.Fragment.Fragment_member_out;
import injappcenter_and.inumarket_android.Fragment.Fragment_phone_change;
import injappcenter_and.inumarket_android.Fragment.Fragment_push_alarm;
import injappcenter_and.inumarket_android.Fragment.Fragment_question;
import injappcenter_and.inumarket_android.R;

public class Mypage_Setting extends AppCompatActivity implements View.OnClickListener{

    ConstraintLayout phonenum, push, question, changepw, logout, out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage__setting);

        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        phonenum = findViewById(R.id.bundle_phonenum);
        push = findViewById(R.id. bundle_push);
        question = findViewById(R.id.bundle_question);
        changepw = findViewById(R.id.bundle_pwchange);
        logout = findViewById(R.id. bundle_logout);
        out = findViewById(R.id.bundle_out);

        phonenum.setOnClickListener(this);
        push.setOnClickListener(this);
        question.setOnClickListener(this);
        changepw.setOnClickListener(this);
        logout.setOnClickListener(this);
        out.setOnClickListener(this);
 //       findViewById(R.id.bundle_out).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bundle_phonenum:{
                Fragment_phone_change phone_change = new Fragment_phone_change();
                getFragmentManager().beginTransaction()
                        .replace(R.id.setting, phone_change)
                        .addToBackStack(null)
                        .commit();
                break;
            }
            case R.id.bundle_push:{
                Fragment_push_alarm push_alarm = new Fragment_push_alarm();
                getFragmentManager().beginTransaction()
                        .replace(R.id.setting, push_alarm)
                        .addToBackStack(null)
                        .commit();
                break;
            }
            case R.id.bundle_question:{
                Fragment_question question = new Fragment_question();
                getFragmentManager().beginTransaction()
                        .replace(R.id.setting, question)
                        .addToBackStack(null)
                        .commit();
                break;
            }
            case R.id.bundle_pwchange:{
                Fragment_changepw changepw = new Fragment_changepw();
                getFragmentManager().beginTransaction()
                        .replace(R.id.setting, changepw)
                        .addToBackStack(null)
                        .commit();
                break;
            }
            case R.id.bundle_logout:{
                //Adapter_dialog dialog_logout = new Adapter_dialog(this);

                break;
            }
            case R.id.bundle_out:{
                Fragment_member_out out = new Fragment_member_out();
                getFragmentManager().beginTransaction()
                        .replace(R.id.setting , out)
                        .addToBackStack(null)
                        .commit();
                break;
            }
        }
    }
}
