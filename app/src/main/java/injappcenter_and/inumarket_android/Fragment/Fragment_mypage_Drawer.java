package injappcenter_and.inumarket_android.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

import javax.security.auth.callback.Callback;

import injappcenter_and.inumarket_android.Activity.Mypage_Setting;
import injappcenter_and.inumarket_android.Activity.letter_form;
import injappcenter_and.inumarket_android.Activity.my_product;
import injappcenter_and.inumarket_android.Activity.product_upload;
import injappcenter_and.inumarket_android.Model.Letter;
import injappcenter_and.inumarket_android.Model.searchId;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import retrofit2.Call;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Fragment_mypage_Drawer extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private FrameLayout Drawer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Drawer = (FrameLayout)inflater.inflate(R.layout.fragment_mypage_drawer, container, false);


        TextView mail_num = (TextView) Drawer.findViewById(R.id.txt_mypage_newmail);

        SharedPreferences pref = Objects.requireNonNull(getActivity()).getSharedPreferences("userinfo",MODE_PRIVATE);
        String token =  pref.getString("token","");
        String id = pref.getString("id","");

        Singleton.retrofit.searchId(token, id).enqueue(new retrofit2.Callback<ArrayList<searchId>>() {
            @Override
            public void onResponse(Call<ArrayList<searchId>> call, Response<ArrayList<searchId>> response) {
                if (response.isSuccessful()){
                    TextView myproduct_num = (TextView) Drawer.findViewById(R.id.txt_mypage_newproduct);
                    ArrayList<searchId> result = response.body();
                    String num = String.valueOf(result.size());
                    myproduct_num.setText(num);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<searchId>> call, Throwable t) {

            }
        });

        Singleton.retrofit.letter(token, id).enqueue(new retrofit2.Callback<ArrayList<Letter>>() {
            @Override
            public void onResponse(Call<ArrayList<Letter>> call, Response<ArrayList<Letter>> response) {
                if (response.isSuccessful()){
                    TextView mail_num = (TextView) Drawer.findViewById(R.id.txt_mypage_newmail);
                    ArrayList<Letter> result = response.body();
                    String mailnum = String.valueOf(result.size());
                    Log.d("letter_service",mailnum);
                    mail_num.setText(mailnum);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Letter>> call, Throwable t) {

            }
        });

        ConstraintLayout myproduct_btn = (ConstraintLayout) Drawer.findViewById(R.id.bundle_myproduct);

        myproduct_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),my_product.class);
                startActivity(intent);
            }
        });

        ConstraintLayout myletter_btn = (ConstraintLayout) Drawer.findViewById(R.id.bundle_mymail);

        myletter_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),letter_form.class);
                startActivity(intent);
            }
        });

        Drawer.findViewById(R.id.bundle_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_setting = new Intent(getActivity(), Mypage_Setting.class);
                startActivity(intent_setting);
                DrawerLayout drawer = getActivity().findViewById(R.id.drawer);
                drawer.closeDrawer(Gravity.END);
            }
        });

        ConstraintLayout upload_btn = (ConstraintLayout) Drawer.findViewById(R.id.bundle_product_regist);

        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),product_upload.class);
                startActivity(intent);
            }
        });

        return Drawer;
    }
}