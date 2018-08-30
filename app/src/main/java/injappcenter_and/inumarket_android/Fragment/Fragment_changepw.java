package injappcenter_and.inumarket_android.Fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import injappcenter_and.inumarket_android.Dialog.Adapter_dialog;
import injappcenter_and.inumarket_android.R;

public class Fragment_changepw extends Fragment {

    TextView noinput, diff, ok , same, less8;
    EditText etcurrentpw, newpw, newpwagain;
    Boolean length,sametxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview =(ViewGroup)inflater.inflate(R.layout.fragment_changepw, container, false);

        noinput =rootview.findViewById(R.id.txt_newpw_noinput);
        diff = rootview.findViewById(R.id.txt_newpw_diff);
        ok = rootview.findViewById(R.id.txt_newpw_ok);
        same = rootview.findViewById(R.id.txt_newpw_same);
        less8 = rootview.findViewById(R.id.txt_newpw_8);

        etcurrentpw = rootview.findViewById(R.id.et_currentpw);
        newpw =rootview.findViewById(R.id.et_newpw);
        newpwagain = rootview.findViewById(R.id.et_newpw_again);

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

        rootview.findViewById(R.id.button_pwchange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if((etcurrentpw.getText().toString().length()!=0)&&(sametxt)&&(length)){
                    //noinput.setVisibility(View.VISIBLE);
                    Adapter_dialog dialog = new Adapter_dialog(getActivity(),"확인을 누르시면 새로운\n비밀번호로 변경됩니다.");
                    dialog.show();
               }
            }
        });

        return rootview;
    }

}
