package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import injappcenter_and.inumarket_android.Activity.Signup;
import injappcenter_and.inumarket_android.Model.UserData;
import injappcenter_and.inumarket_android.R;

public class Fragment_Signup04 extends Fragment {
    TextView telnoinput;
    EditText phone_num;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup04, container, false);
        initView();
        return view;
    }

    public void initData() {

    }

    public void initView() {
        telnoinput = (TextView) view.findViewById(R.id.txt_signup_step4_noinput);
        phone_num = (EditText) view.findViewById(R.id.et_signup_step4);
        Button img_next = (Button) view.findViewById(R.id.btn_sign4_next);

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone_num.length() != 11) {
                    telnoinput.setVisibility(View.VISIBLE);
                } else {
                    telnoinput.setVisibility(View.INVISIBLE);

                    Fragment_Signup05 fragment_signup05 = new Fragment_Signup05();
                    UserData.getInstance().setPhone(phone_num.getText().toString());
                    ((Signup)getActivity()).changetFragment(fragment_signup05);
                }
            }
        });
    }

}
