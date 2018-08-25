package injappcenter_and.inumarket_android.register;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.register.utils.Const;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class sign5Activity extends AppCompatActivity {
    Retrofit retrofit;
    ApiService apiService;
    TextView tex_name;
    TextView num_student;
    TextView tex_number;
    private Intent mIntent;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_impo);
        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);

        mIntent = getIntent();

        ImageView img_next = (ImageView) findViewById(R.id.img_next);


//intent에서 불러오기
        final String name = mIntent.getStringExtra(Const.CONST_NAME);
        final String id = mIntent.getStringExtra(Const.CONST_SCHOOL_NUM);
        final String passwd = mIntent.getStringExtra(Const.CONST_PASS);
        final String tel = mIntent.getStringExtra(Const.CONST_PHONE);

        Log.d("TEST", mIntent.getStringExtra(Const.CONST_NAME));
        Log.d("TEST", mIntent.getStringExtra(Const.CONST_SCHOOL_NUM));
        Log.d("TEST", mIntent.getStringExtra(Const.CONST_PASS));
        Log.d("TEST", mIntent.getStringExtra(Const.CONST_PHONE));
        // 불러온 스트링 데이터를 셋팅

        tex_name = (TextView) findViewById(R.id.tex_name);
        num_student = (TextView) findViewById(R.id.num_student);
        tex_number = (TextView) findViewById(R.id.tex_number);


        num_student.setText(id);
        tex_number.setText(tel);
        tex_name.setText(name);

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Call<ResponseBody> comment = apiService.getPostCommenStr(id,passwd,name,tel);

                comment.enqueue(new Callback<ResponseBody>(){
                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        try {
                            Log.v("Test" , response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t){

                    }




                    });
                alertOneButton();
            }

            public void alertOneButton() {

                new AlertDialog.Builder(sign5Activity.this)
                        .setMessage("회원가입이 완료되었습니다. 이메일 인증완료후 로그인해주세요.")

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {



                                dialog.cancel();
                            }
                        }).show();
            }

        });
    }
}