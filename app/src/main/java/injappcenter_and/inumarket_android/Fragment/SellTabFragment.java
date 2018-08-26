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

import java.util.ArrayList;
import java.util.List;

import injappcenter_and.inumarket_android.Model.letterDataHeader;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.letterRecyclerAdapter;

public class SellTabFragment extends Fragment{


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
        ArrayList<letterDataHeader> list = new ArrayList<>();
        list.add(new letterDataHeader("1"));
        list.add(new letterDataHeader("2"));
        list.add(new letterDataHeader("3"));
        list.add(new letterDataHeader("4"));
        list.add(new letterDataHeader("5"));
*/

        /*List<letterRecyclerAdapter.Item> list = new ArrayList<>();
        ArrayList HeaderArray = new ArrayList();
        ArrayList ChildArray = new ArrayList();
        ArrayList<String> ReadArray = new ArrayList<String>();

        HeaderArray.add("첫번째 쪽지");
        HeaderArray.add("두번째 쪽지");
        HeaderArray.add("세번째 쪽지");
        ChildArray.add("구매자이름 : 임동완\n전화번호 : 010-2167-5629");
        ChildArray.add("두번째 쪽지내용");
        ChildArray.add("세번째 쪽지내용");
        ReadArray.add("true");
        ReadArray.add("false");
        ReadArray.add("true");



        int i;
        for(i=0;i<HeaderArray.size();i++){
            letterRecyclerAdapter.Item places = new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER, HeaderArray.get(i).toString());
            places.invisibleChildren = new ArrayList<>();
            places.invisibleChildren.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,ChildArray.get(i).toString()));
            places.isRead = new ArrayList<>();
            places.isRead.add(new letterRecyclerAdapter.Item(ReadArray.get(i)));
            list.add(places);
        }*/

/*
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER, "첫번째 쪽지"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,"첫번째 쪽지 내용"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER, "두번째 쪽지"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,"두번째 쪽지 내용"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER, "세번째 쪽지"));
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,"세번째 쪽지 내용"));*/
        //rcvAdapter = new letterRecyclerAdapter(getActivity(),list);
/*
        letterRecyclerAdapter.Item places = new letterRecyclerAdapter.Item(letterRecyclerAdapter.HEADER,"네번째 쪽지");
        places.invisibleChildren = new ArrayList<>();
        list.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.READ, "false"));
        places.invisibleChildren.add(new letterRecyclerAdapter.Item(letterRecyclerAdapter.CHILD,"네번째 쪽지 내용"));

        list.add(places);*/
        /*rcv.setAdapter(new letterRecyclerAdapter(list));*/


        /*rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","임동완","010-2167-5629","가전가구기타",false,0));
        rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","임동완","010-2167-5629","가전가구기타",false,0));
        rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","임동완","010-2167-5629","가전가구기타",false,0));

        rcv.setAdapter(rcvAdapter);*/
        return rootview;
    }
}
