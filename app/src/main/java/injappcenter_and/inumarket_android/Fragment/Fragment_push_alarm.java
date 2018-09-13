package injappcenter_and.inumarket_android.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import injappcenter_and.inumarket_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_push_alarm extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_push_alarm, container, false);

        rootview.findViewById(R.id.btn_push_setting)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

        return rootview;
    }

}
