package injappcenter_and.inumarket_android.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import injappcenter_and.inumarket_android.Dialog.Adapter_dialog;
import injappcenter_and.inumarket_android.R;

public class Fragment_member_out extends Fragment {

    EditText stdid, pw;
    TextView noinput, incorrect;
    Boolean i ,j;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_member_out, container, false);

        stdid = rootview.findViewById(R.id.et_out_studentid);
        pw = rootview.findViewById(R.id.et_out_pw);
        noinput = rootview.findViewById(R.id.txt_out_noinput);
        incorrect = rootview.findViewById(R.id.txt_out_incorrect);

        if ((stdid.getText().toString().length() ==0)||(pw.getText().toString().length()==0)){
            noinput.setVisibility(View.VISIBLE);
            incorrect.setVisibility(View.INVISIBLE);

        }
        else{
            //서버통신 후 작성
            //incorrect.setVisibility(View.VISIBLE);
        }

        rootview.findViewById(R.id.btn_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Adapter_dialog dialog_out
                        = new Adapter_dialog(getActivity(),"확인을 누르시면 회원 탈퇴됩니다.");
                dialog_out.show();
            }
        });



        return rootview;
    }

}
