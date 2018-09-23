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

public class Fragment_Signup02 extends Fragment {
    TextView txtnoinput, txtincorrect;
    EditText stdid ,name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_signup02, container, false);

        txtnoinput = view.findViewById(R.id.txt_signup_step2_noinput);
        txtincorrect = view.findViewById(R.id.txt_signup_step2_notcollect);
        name = view.findViewById(R.id.et_signup_step2_name);
        stdid = view.findViewById(R.id.et_signup_step2_stdid);
        Button btn_next = view.findViewById(R.id.btn_sign2_next);

        final Fragment_Signup03 fragment_signup03 = new Fragment_Signup03();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String userid = stdid.getText().toString();
                if ((username.length() > 0)&&(userid.length() > 0)) {

                    txtnoinput.setVisibility(View.INVISIBLE);
                    UserData.getInstance().setName(username);

                    if (userid.length()==9){
                        txtincorrect.setVisibility(View.INVISIBLE);
                        UserData.getInstance().setSchoolID(userid);
                        ((Signup)getActivity()).changetFragment(fragment_signup03);
                    }
                    else
                        txtincorrect.setVisibility(View.VISIBLE);
                } else {
                    txtnoinput.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }
}