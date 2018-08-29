package injappcenter_and.inumarket_android.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import injappcenter_and.inumarket_android.Activity.letter_form;
import injappcenter_and.inumarket_android.Activity.my_product;
import injappcenter_and.inumarket_android.R;

public class Fragment_mypage_Drawer extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private FrameLayout Drawer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Drawer = (FrameLayout)inflater.inflate(R.layout.fragment_mypage_drawer, container, false);
        ConstraintLayout myproduct_btn = (ConstraintLayout) Drawer.findViewById(R.id.bundle_myproduct);

        myproduct_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),my_product.class);
                startActivity(intent);
            }
        });

        ConstraintLayout myletter_btn = (ConstraintLayout) Drawer.findViewById(R.id.bundle_mymail);

        myletter_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),letter_form.class);
                startActivity(intent);
            }
        });

        return Drawer;
    }
}
