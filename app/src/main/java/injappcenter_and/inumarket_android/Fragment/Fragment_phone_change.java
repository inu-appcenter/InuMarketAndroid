package injappcenter_and.inumarket_android.Fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import injappcenter_and.inumarket_android.Dialog.Adapter_dialog;
import injappcenter_and.inumarket_android.R;

public class Fragment_phone_change extends Fragment {
    Button btn_change;
    EditText newphone;

    public Fragment_phone_change() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_phone_change, container, false);

        newphone = rootview.findViewById(R.id.et_phone_change_num);

        btn_change = rootview.findViewById(R.id.btn_phone_change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newphone.length() <10){
                    rootview.findViewById(R.id.txt_phone_noinput).setVisibility(View.VISIBLE);
                }
                else {
                    rootview.findViewById(R.id.txt_phone_noinput).setVisibility(View.INVISIBLE);
                    final Adapter_dialog dialog = new Adapter_dialog(getActivity());
                    dialog.show();
                }
            }
        });

        return rootview;
    }

}
