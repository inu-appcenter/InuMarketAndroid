package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

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

        return Drawer;
    }
}
