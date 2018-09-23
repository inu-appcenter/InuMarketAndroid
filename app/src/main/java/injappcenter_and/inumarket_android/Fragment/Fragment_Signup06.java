package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import injappcenter_and.inumarket_android.R;

/**
 * Created by babareun on 2018-09-22.
 */

public class Fragment_Signup06 extends Fragment {
    private View view;
    Button btnsubmit;

    @Nullable
    @Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_signup06, container, false);

       btnsubmit = view.findViewById(R.id.btn_sign6_submit);
       btnsubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getActivity().finish();
           }
       });

       return view;
    }
}
