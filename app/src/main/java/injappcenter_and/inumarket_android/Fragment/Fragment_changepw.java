package injappcenter_and.inumarket_android.Fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;

import injappcenter_and.inumarket_android.Dialog.Adapter_dialog;
import injappcenter_and.inumarket_android.Dialog.Adapter_dialog_onebutton;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Fragment_changepw extends Fragment {

    TextView noinput, diff, ok , same, less8;
    EditText etcurrentpw, newpw, newpwagain;
    Boolean length,sametxt;
    String id,pw;
    SharedPreferences.Editor editor;
    SharedPreferences pref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview =(ViewGroup)inflater.inflate(R.layout.fragment_changepw, container, false);

        length = true;

        noinput =rootview.findViewById(R.id.txt_newpw_noinput);
        diff = rootview.findViewById(R.id.txt_newpw_diff);
        ok = rootview.findViewById(R.id.txt_newpw_ok);
        same = rootview.findViewById(R.id.txt_newpw_same);
        less8 = rootview.findViewById(R.id.txt_newpw_8);

        etcurrentpw = rootview.findViewById(R.id.et_currentpw);
        newpw =rootview.findViewById(R.id.et_newpw);
        newpwagain = rootview.findViewById(R.id.et_newpw_again);

        pref = getActivity().getSharedPreferences("userinfo",MODE_PRIVATE);
        id = pref.getString("id","");
        pw = pref.getString("pw","");

        newpw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length()<8) {
                    less8.setVisibility(View.VISIBLE);
                    ok.setVisibility(View.INVISIBLE);
                    length = false;
                }
                else {
                    less8.setVisibility(View.INVISIBLE);
                    ok.setVisibility(View.VISIBLE);
                   length = true;
                }

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        newpwagain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (length) {
                    if (s.toString().equals(newpw.getText().toString())) {
                        same.setVisibility(View.VISIBLE);
                        diff.setVisibility(View.INVISIBLE);
                        sametxt = true;
                    } else {
                        diff.setVisibility(View.VISIBLE);
                        same.setVisibility(View.INVISIBLE);
                        sametxt = false;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        etcurrentpw = rootview.findViewById(R.id.et_currentpw);

        rootview.findViewById(R.id.button_pwchange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if((etcurrentpw.getText().toString().equals(pw))){
                   if((sametxt)&&(length)){
                    //noinput.setVisibility(View.VISIBLE);
                   Adapter_dialog dialog = new Adapter_dialog(getActivity(),"확인을 누르시면 새로운\n비밀번호로 변경됩니다.");
                   dialog.setOnOkButtonClickListener(new Adapter_dialog.OnOkButtonClickListener() {
                       @Override
                       public void onClick() {
                           final String st_newpw = newpw.getText().toString();

                           Singleton.retrofit.changePasswd(id ,pw ,st_newpw).enqueue(new Callback<JsonObject>() {
                               @Override
                               public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                   if(response.isSuccessful()){
                                       assert response.body() != null;
                                       JsonObject result = response.body();
                                       Log.d("changeTel_test",""+result);
                                       if(String.valueOf(result.get("ans")).equals("true")){
                                           if(!pw.equals(st_newpw)){
                                               editor = pref.edit();
                                               editor.putString("pw", st_newpw);
                                               editor.apply();
                                           }
                                           FragmentManager fragmentManager = getActivity().getFragmentManager();
                                           fragmentManager.beginTransaction().remove(Fragment_changepw.this).commit();
                                       }
                                   }
                               }
                               @Override
                               public void onFailure(Call<JsonObject> call, Throwable t) {

                               }
                           });
                       }
                   });

                   dialog.show();}
               }
               else{
                   Adapter_dialog_onebutton dialog_incorrect
                           = new Adapter_dialog_onebutton(getActivity(),"현재 비밀번호가\n일치하지 않습니다.");
                   dialog_incorrect.show();
               }
            }
        });

        return rootview;
    }

}
