package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;

public class Fragment_upload_category_imp extends Fragment {
    ConstraintLayout imp;
    ConstraintLayout cl_Btn;
    RadioButton meeting;
    RadioGroup method;
    TextView meetingTv;
    TextView warningText;
    EditText productInfoEdit;
    EditText methodEditTv;
    String sendCategory,sendName,sendState,sendPrice,sendinfo,sendmethod,sendPlace,category;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        category = getArguments().getString("category");
        sendCategory = getArguments().getString("sendCategory");
        sendName = getArguments().getString("name");
        sendState = getArguments().getString("state");
        sendPrice = getArguments().getString("price");

        final Fragment newFrag = new Fragment_upload_category_img();
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();

        imp = (ConstraintLayout) inflater.inflate(R.layout.fragment_product_upload_imp,container,false);
        method = (RadioGroup) imp.findViewById(R.id.methodGroup);
        meeting = (RadioButton) imp.findViewById(R.id.radio_btn_meeting);
        meetingTv = (TextView) imp.findViewById(R.id.meeting_tv);
        productInfoEdit = (EditText) imp.findViewById(R.id.product_upload_product_info);
        methodEditTv = (EditText) imp.findViewById(R.id.meeting_editTv);
        cl_Btn = (ConstraintLayout) getActivity().findViewById(R.id.next_btn);
        warningText = (TextView) getActivity().findViewById(R.id.upload_warningText);

        cl_Btn.setVisibility(View.VISIBLE);
        warningText.setText("* 상품 설명과 거래 방식 입력해야 합니다.");
        warningText.setVisibility(View.INVISIBLE);



        method.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_btn_meeting:
                        methodEditTv.setText("");
                        methodEditTv.setVisibility(View.VISIBLE);
                        meetingTv.setVisibility(View.VISIBLE);
                        sendmethod = "직거래";
                        break;
                    case R.id.radio_btn_postbox:
                        methodEditTv.setText("post");
                        meetingTv.setVisibility(View.INVISIBLE);
                        methodEditTv.setVisibility(View.INVISIBLE);
                        sendmethod = "택배";
                        break;

                }
            }
        });

        cl_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendinfo = productInfoEdit.getText().toString();
                sendPlace = methodEditTv.getText().toString();
                if(sendinfo.equals("") || sendmethod.equals("")){
                    warningText.setVisibility(View.VISIBLE);
                }
                else{
                    Bundle bundle = new Bundle();
                    bundle.putString("category",category);
                    bundle.putString("sendCategory",sendCategory);
                    bundle.putString("name",sendName);
                    bundle.putString("state",sendState);
                    bundle.putString("price",sendPrice);
                    bundle.putString("info",sendinfo);
                    bundle.putString("method",sendmethod);
                    bundle.putString("place",sendPlace);
                    newFrag.setArguments(bundle);
                    transaction.replace(R.id.upload_frameLayout,newFrag);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

            }
        });
        return imp;
    }
}
