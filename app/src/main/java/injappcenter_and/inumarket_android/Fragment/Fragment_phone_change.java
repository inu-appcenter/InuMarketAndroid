package injappcenter_and.inumarket_android.Fragment;


import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import injappcenter_and.inumarket_android.Dialog.Adapter_dialog;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Fragment_phone_change extends Fragment {
    Button btn_change;
    TextView phone;
    EditText newphone;
    Adapter_dialog dialog;
    String id,userTel, newTel;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_phone_change, container, false);
        phone = rootview.findViewById(R.id.txt_phone_current_num);


        final SharedPreferences pref = getActivity().getSharedPreferences("userinfo",MODE_PRIVATE);
        id = pref.getString("id","");
        userTel = pref.getString("tel", "");
        phone.setText(userTel);
        newphone = rootview.findViewById(R.id.et_phone_new_Tel);

        dialog = new Adapter_dialog(getActivity(),"확인을 누르시면 새로운\n전화번호로 변경됩니다.");

        dialog.setOnOkButtonClickListener(new Adapter_dialog.OnOkButtonClickListener() {
            @Override
            public void onClick() {
                newTel = newphone.getText().toString();
                Log.d("newTel", newTel);

                Singleton.retrofit.changeTel(id ,newTel).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if(response.isSuccessful()){
                            assert response.body() != null;
                            JsonObject result = response.body();
                            Log.d("changeTel_test",""+result);
                            if(String.valueOf(result.get("ans")).equals("true")){
                                if(!userTel.equals(newTel)){
                                    editor = pref.edit();
                                    editor.putString("tel", newTel);
                                    editor.apply();
                                    FragmentManager fragmentManager = getActivity().getFragmentManager();
                                    fragmentManager.beginTransaction().remove(Fragment_phone_change.this).commit();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
            }
        });


        btn_change = rootview.findViewById(R.id.btn_phone_change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newphone.length() <10){
                    rootview.findViewById(R.id.txt_phone_noinput).setVisibility(View.VISIBLE);
                }
                else {
                    rootview.findViewById(R.id.txt_phone_noinput).setVisibility(View.INVISIBLE);
                    dialog.show();
                }
            }
        });

        return rootview;
    }
}
