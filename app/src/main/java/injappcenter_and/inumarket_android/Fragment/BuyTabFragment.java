package injappcenter_and.inumarket_android.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import injappcenter_and.inumarket_android.Model.letterDataForm;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.Mainproduct_Adapter;
import injappcenter_and.inumarket_android.Recycler.letterRecyclerAdapter;

public class BuyTabFragment extends Fragment{
    RecyclerView rcv;
    letterRecyclerAdapter rcvAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_tab_buy,null);

        rcv = rootview.findViewById(R.id.letterRecycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.addItemDecoration(new DividerItemDecoration(getActivity(),linearLayoutManager.getOrientation()));
        rcv.setLayoutManager(linearLayoutManager);
/*
        ArrayList<letterDataForm> list = new ArrayList<>();
        list.add(new letterDataForm("1"));
        list.add(new letterDataForm("2"));
        list.add(new letterDataForm("3"));
        list.add(new letterDataForm("4"));
        list.add(new letterDataForm("5"));
*/

        List<letterRecyclerAdapter.Item> list = new ArrayList<>();

        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER, "첫번째 쪽지"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.READ, "false"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,"첫번째 쪽지 내용"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER, "두번째 쪽지"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.READ, "false"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,"두번째 쪽지 내용"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER, "세번째 쪽지"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.READ, "false"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,"세번째 쪽지 내용"));
        //rcvAdapter = new letterRecyclerAdapter(getActivity(),list);
/*
        letterRecyclerAdapter.Item places = new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER,"네번째 쪽지");
        places.invisibleChildren = new ArrayList<>();
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.READ, "false"));
        places.invisibleChildren.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,"네번째 쪽지 내용"));

        list.add(places);*/
        rcv.setAdapter(new letterRecyclerAdapter(list));
        return rootview;
    }
}
