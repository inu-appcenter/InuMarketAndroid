package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import injappcenter_and.inumarket_android.Model.letterDataHeader;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.letterRecyclerAdapter;

public class BuyTabFragment extends Fragment{
    RecyclerView rcv;
    letterRecyclerAdapter rcvAdapter = new letterRecyclerAdapter();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_tab_buy,null);

        rcv = rootview.findViewById(R.id.letterRecycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.addItemDecoration(new DividerItemDecoration(getActivity(),linearLayoutManager.getOrientation()));
        rcv.setLayoutManager(linearLayoutManager);

        rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","구매자 이름 : 임동완","010-2167-5629","가전가구기타",false,0,null));
        rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","구매자 이름 : 임동완","010-2167-5629","가전가구기타",false,0,null));
        rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","구매자 이름 : 임동완","010-2167-5629","가전가구기타",false,0,null));

        rcv.setAdapter(rcvAdapter);

        return rootview;
    }

}
