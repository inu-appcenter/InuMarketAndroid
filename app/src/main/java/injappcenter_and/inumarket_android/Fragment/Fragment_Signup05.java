package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import injappcenter_and.inumarket_android.Activity.Signup;
import injappcenter_and.inumarket_android.Model.UserData;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Fragment_Signup05 extends Fragment {
    Retrofit retrofit;
    TextView tvname, tvstdid, tvtel;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup05, container, false);;
        initView();
        initData();

        return view;
    }

    public void initData() {
        tvstdid.setText(UserData.getInstance().getSchoolID());
        tvtel.setText(UserData.getInstance().getPhone());
        tvname.setText(UserData.getInstance().getName());

    }

    public void initView() {
        Button img_next = (Button) view.findViewById(R.id.btn_sign5_next);
        tvname = (TextView) view.findViewById(R.id.txt_signup_step5_name);
        tvstdid = (TextView) view.findViewById(R.id.txt_signup_step5_stdid);
        tvtel = (TextView) view.findViewById(R.id.txt_signup_step5_tel);

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String,Object> info = new HashMap<>();
                info.put("id",UserData.getInstance().getSchoolID());
                info.put("passwd",UserData.getInstance().getPw());
                info.put("name",UserData.getInstance().getName());
                info.put("tel",UserData.getInstance().getPhone());
                Log.e("벨류값",""+info.values());

                Singleton.retrofit.account(UserData.getInstance().getSchoolID(), UserData.getInstance().getPw()
                        ,UserData.getInstance().getName(), UserData.getInstance().getPhone())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            JsonObject result = response.body();
                            Log.d("account_test",""+result);
                            if(String.valueOf(result.get("ans")).equals("true")){
                                ((Signup)getActivity()).changetFragment(new Fragment_Signup06());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
            }
        });
    }
}