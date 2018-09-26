package injappcenter_and.inumarket_android.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import injappcenter_and.inumarket_android.Dialog.Adapter_dialog_onebutton;
import injappcenter_and.inumarket_android.Model.LoginResult;
import injappcenter_and.inumarket_android.Model.forgotpw_Result;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
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
            Singleton.retrofit.forgot_pw(stdid,name).enqueue(new Callback<forgotpw_Result>() {
                @Override
                public void onResponse(Call<forgotpw_Result> call, Response<forgotpw_Result> response) {
                    if (response.isSuccessful()) {
                        forgotpw_Result result = response.body();
                        if (result != null) {
                            if (result.getAns().equals("true")){
                                notcollect_txt.setVisibility(View.INVISIBLE);
                                Log.d("testpasswd",""+result.getAns());
                                Adapter_dialog_onebutton dialog = new Adapter_dialog_onebutton(getApplicationContext());
                                dialog.show();
                            }
                            else{
                                notcollect_txt.setVisibility(View.VISIBLE);
                                Log.d("testpasswd",""+result.getAns());
                            }
                        }
                        else{
                            Log.d("testpwerr",""+result.getAns());
                            Toast.makeText(getApplicationContext(),"서버연결을 확인해 주세요",Toast.LENGTH_LONG).show();
                            }
                        }

                    else{
                        Toast.makeText(getApplicationContext(),"서버연결을 확인해 주세요",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<forgotpw_Result> call, Throwable t) {
                    Log.d("errtxt", "서버연결에러");
                }
            });
        }
        else
            noinput_txt.setVisibility(View.VISIBLE);
    }
}

