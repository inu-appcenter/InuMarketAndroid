package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.uploadCategoryGridAdapter;

public class Fragment_upload_category_grid extends android.support.v4.app.Fragment {

    public Fragment_upload_category_grid(){

    }
    ConstraintLayout cg;
    ConstraintLayout cl_Btn;
    GridView gv;
    FragmentActivity fragmentActivity;
    TextView warningText;



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        cl_Btn = (ConstraintLayout) getActivity().findViewById(R.id.next_btn);
        warningText = (TextView) getActivity().findViewById(R.id.upload_warningText);

        cl_Btn.setVisibility(View.INVISIBLE);
        warningText.setVisibility(View.INVISIBLE);

        cg = (ConstraintLayout)inflater.inflate(R.layout.fragment_product_upload_category_grid,container,false);
        if(getArguments() != null){


            String[] category = getArguments().getStringArray("category");
            String[] sendCategory = getArguments().getStringArray("sendCategory");
            String middle = getArguments().getString("middle");


            TextView middletv = (TextView) cg.findViewById(R.id.middleCategory);
            middletv.setText(middle);
            uploadCategoryGridAdapter GA = new uploadCategoryGridAdapter(getActivity(),transaction,
                    category,middle,sendCategory);

            GridView gv = (GridView) cg.findViewById(R.id.category_grid);
            gv.setAdapter(GA);
        }

        return cg;
    }
}
