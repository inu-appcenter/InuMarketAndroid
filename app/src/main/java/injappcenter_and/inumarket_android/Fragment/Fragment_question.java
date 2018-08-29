package injappcenter_and.inumarket_android.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import injappcenter_and.inumarket_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
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
                        else
                            rootview.findViewById(R.id.txt_question_noinput).setVisibility(View.INVISIBLE);
                    }
                });

       return rootview;
    }
}
