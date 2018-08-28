package injappcenter_and.inumarket_android.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import injappcenter_and.inumarket_android.Activity.Mypage_Setting;
import injappcenter_and.inumarket_android.R;

public class Fragment_mypage_Drawer extends android.support.v4.app.Fragment implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public TextView txtproductnum,txtmail;
    ConstraintLayout product, mail, regist, setting;

    private FrameLayout Drawer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Drawer = (FrameLayout)inflater.inflate(R.layout.fragment_mypage_drawer, container, false);

        txtproductnum = Drawer.findViewById(R.id.txt_mypage_newproduct);
        txtmail = Drawer.findViewById(R.id.txt_mypage_newmail);

        product = Drawer.findViewById(R.id.bundle_myproduct);
        mail = Drawer.findViewById(R.id.bundle_mymail);
        regist =Drawer.findViewById(R.id.bundle_product_regist);
        setting = Drawer.findViewById(R.id.bundle_setting);

        product.setOnClickListener(this);
        mail.setOnClickListener(this);
        regist.setOnClickListener(this);
        setting.setOnClickListener(this);

        return Drawer;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bundle_myproduct:{

            }
            case R.id.bundle_mymail:{

            }
            case R.id.bundle_product_regist:{

            }
            case R.id.bundle_setting:{
                Intent intent_setting = new Intent(getActivity(), Mypage_Setting.class);
                startActivity(intent_setting);
            }
        }
    }
}
