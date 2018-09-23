package injappcenter_and.inumarket_android.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
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

public class Fragment_Signup03 extends Fragment {
    TextView txt_pwlength,txt_pwdif;
    EditText password1,password2;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup03, container, false);
        initView();
        return view;
    }

    public void initData() {

    }

    public void initView() {

        txt_pwlength = view.findViewById(R.id.txt_signup_step3_less8);
        txt_pwdif = view.findViewById(R.id.txt_signup_step3_dif);

        password1 = (EditText) view.findViewById(R.id.et_signup_step3_password1);
        password2 = (EditText) view.findViewById(R.id.et_signup_step3_password2);
        final Button btn_next = view.findViewById(R.id.btn_sign3_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (password1.getText().toString().trim().length() == 0 || password2.getText().toString().trim().length() == 0) {
//                    message.setText("* 비밀번호를 입력해야 합니다.");
//                } else if (!password1.getText().toString().trim().equals(password2.getText().toString().trim())) {
//                    //비밀번호 불일치
//                } else {
                    // 다음 버튼을 눌렀을때 다음화면으로 이동해야할 activity 정의
                    Fragment_Signup04 fragment_signup04 = new Fragment_Signup04();

                    UserData.getInstance().setPw(password1.getText().toString().trim());
                                     ((Signup)getActivity()).changetFragment(fragment_signup04);
                    // 비밀번호 데이터를 전달받았던 인텐트에 추가

                //}

            }
        });

        password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if (text.length() < 8) {

                    txt_pwlength.setTextColor(ContextCompat.getColor(getContext(),R.color.orangey_red));
                    txt_pwlength.setText("* 8글자 이상 입력해야 합니다.");
                } else {
                    txt_pwlength.setTextColor(ContextCompat.getColor(getContext(),R.color.apple_green));
                    txt_pwlength.setText("* 사용할 수 있는 비밀번호입니다.");
                }
            }
        });

        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                final String text1 = s.toString();
                final String text2 = password1.getText().toString();
                UserData.getInstance().setPw(password2.getText().toString());

                if (text1.equals(text2)) {
                    txt_pwdif.setTextColor(ContextCompat.getColor(getContext(),R.color.apple_green));
                    txt_pwdif.setText("* 비밀번호가 일치합니다.");
                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (text1.equals(text2)) {
                                ((Signup) getActivity()).changetFragment(new Fragment_Signup04());
                            }
                        }


                    });

                } else {
                    txt_pwdif.setTextColor(ContextCompat.getColor(getContext(),R.color.orangey_red));
                    txt_pwdif.setText("* 비밀번호가 일치하지 않습니다.");
                }
            }
        });
    }
}


