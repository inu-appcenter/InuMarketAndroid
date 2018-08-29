package injappcenter_and.inumarket_android.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;

public class Fragment_changepw extends Fragment {

    TextView noinput, diff, ok , same, less8;
    EditText etcurrentpw, newpw, newpwagain;

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

        rootview.findViewById(R.id.button_pwchange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etcurrentpw.getText().toString().length()==0){
                    noinput.setVisibility(View.VISIBLE);
                }

            }
        });


        return rootview;
    }

}
