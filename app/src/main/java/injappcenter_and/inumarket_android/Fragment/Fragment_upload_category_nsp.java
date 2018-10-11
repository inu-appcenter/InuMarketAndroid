package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;

public class Fragment_upload_category_nsp extends android.support.v4.app.Fragment {
    ConstraintLayout nsp;
    ConstraintLayout cl_Btn;
    String sendCategory;
    TextView warningText;
    EditText productNameEdit;
    EditText productStateEdit;
    EditText productPriceEdit;
    String productName;
    String productState;
    String productPrice;


    public Fragment_upload_category_nsp(){

    }

    @NonNull
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        sendCategory = getArguments().getString("category");

        final Fragment newFrag = new Fragment_upload_category_imp();
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();


        cl_Btn = (ConstraintLayout) getActivity().findViewById(R.id.next_btn);
        warningText = (TextView) getActivity().findViewById(R.id.upload_warningText);

        cl_Btn.setVisibility(View.VISIBLE);
        warningText.setText("*상품정보를 입력해야 합니다.");
        warningText.setVisibility(View.INVISIBLE);

        nsp = (ConstraintLayout) inflater.inflate(R.layout.fragment_product_upload_nsp,container,false);



        cl_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productNameEdit = (EditText) nsp.findViewById(R.id.product_upload_product_name);
                productStateEdit = (EditText) nsp.findViewById(R.id.product_upload_product_state);
                productPriceEdit = (EditText) nsp.findViewById(R.id.product_upload_product_price);
                productName = productNameEdit.getText().toString();
                productPrice = productPriceEdit.getText().toString();
                productState = productStateEdit.getText().toString();
                if(productName.equals("") || productPrice.equals("") || productState.equals("")){
                    warningText.setVisibility(View.VISIBLE);
                }
                else{
                    Bundle bundle = new Bundle();
                    bundle.putString("category",sendCategory);
                    bundle.putString("name",productName);
                    bundle.putString("state",productState);
                    bundle.putString("price",productPrice);
                    newFrag.setArguments(bundle);
                    transaction.replace(R.id.upload_frameLayout,newFrag);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        return nsp;
    }
}
