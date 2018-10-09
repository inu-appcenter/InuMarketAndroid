package injappcenter_and.inumarket_android.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Activity.Main;
import injappcenter_and.inumarket_android.R;

public class Fragment_upload_product_detail extends Fragment {
    ConstraintLayout pDetail, add_product_btn;
    Button letterSend_Btn;
    TextView activity_textview, activity_bottom_tv, detail_name_tv, detail_price_tv, detail_info_tv, detail_state_tv, detail_method_tv, detail_place_tv, detail_category_tv;
    ArrayList<String> sendPhotoList = new ArrayList<String>();
    String sendCategory,sendName,sendState,sendPrice,sendinfo,sendmethod,sendPlace,category;


    public Fragment_upload_product_detail(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        pDetail = (ConstraintLayout)inflater.inflate(R.layout.activity_product_detail,container,false);
        activity_textview = getActivity().findViewById(R.id.upload_tv);
        letterSend_Btn = (Button) pDetail.findViewById(R.id.btn_productdetail_question);
        activity_bottom_tv = getActivity().findViewById(R.id.upload_bottom_tv);
        detail_name_tv = pDetail.findViewById(R.id.txt_productdetail_name);
        detail_price_tv = pDetail.findViewById(R.id.txt_productdetail_price);
        detail_info_tv = pDetail.findViewById(R.id.txt_productdetail_info);
        detail_state_tv = pDetail.findViewById(R.id.txt_productdetail_status);
        detail_method_tv = pDetail.findViewById(R.id.txt_productdetail_method);
        detail_place_tv = pDetail.findViewById(R.id.txt_productdetail_dealplace);
        detail_category_tv = pDetail.findViewById(R.id.txt_productdetail_category);
        add_product_btn = getActivity().findViewById(R.id.next_btn);

        sendPhotoList = getArguments().getStringArrayList("photo");
        sendCategory = getArguments().getString("sendCategory");
        category = getArguments().getString("category");
        sendName = getArguments().getString("name");
        sendState = getArguments().getString("state");
        sendPrice = getArguments().getString("price");
        sendinfo = getArguments().getString("info");
        sendmethod = getArguments().getString("method");
        sendPlace = getArguments().getString("place");

        activity_textview.setText("상품 등록 미리보기");
        activity_bottom_tv.setText("등록");
        detail_name_tv.setText(sendName);
        detail_price_tv.setText(sendPrice);
        detail_info_tv.setText(sendinfo);
        detail_state_tv.setText("- 상품 상태 : "+sendState);
        detail_method_tv.setText("- 거래 방식 : "+sendmethod);
        detail_place_tv.setText("- 거래 장소 : "+sendPlace);
        detail_category_tv.setText("- 카테고리 : "+category);
        letterSend_Btn.setVisibility(View.INVISIBLE);

        add_product_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("성공");
                alertDialog.setMessage("물품 등록이 성공하였습니다.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(v.getContext(),Main.class);
                                v.getContext().startActivity(intent);
                            }
                        });
                alertDialog.show();
            }
        });

        return pDetail;
    }
}
