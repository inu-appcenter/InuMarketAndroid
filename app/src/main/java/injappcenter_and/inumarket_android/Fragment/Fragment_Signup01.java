package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import injappcenter_and.inumarket_android.Activity.Signup;
import injappcenter_and.inumarket_android.R;

public class Fragment_Signup01 extends Fragment {
    private CheckBox checkBox;
    private TextView message;
    Button btn_nextstep;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_signup01, container, false);

        checkBox = view.findViewById(R.id.checkbox_sign_step1);
        message = view.findViewById(R.id.txt_signup_step1_msg);

        btn_nextstep = view.findViewById(R.id.btn_sign1_next);
        btn_nextstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    message.setVisibility(View.INVISIBLE);
                    ((Signup) getActivity()).changetFragment(new Fragment_Signup02());

                } else {
                    message.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }
}

