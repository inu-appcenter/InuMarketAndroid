package injappcenter_and.inumarket_android.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import injappcenter_and.inumarket_android.Dialog.Adapter_dialog;
import injappcenter_and.inumarket_android.R;

public class Fragment_question extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_question, container, false);

        rootview.findViewById(R.id.btn_question_send)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText question = rootview.findViewById(R.id.et_question);
                        if (question.getText().toString().length()==0)
                        {
                            rootview.findViewById(R.id.txt_question_noinput).setVisibility(View.VISIBLE);
                        }
                        else {
                            rootview.findViewById(R.id.txt_question_noinput).setVisibility(View.INVISIBLE);
                            Adapter_dialog dialog_send = new Adapter_dialog(getActivity(),"확인을 누르시면\n문의사항이 전송됩니다.");
                            dialog_send.show();
                        }
                    }
                });

       return rootview;
    }
}
