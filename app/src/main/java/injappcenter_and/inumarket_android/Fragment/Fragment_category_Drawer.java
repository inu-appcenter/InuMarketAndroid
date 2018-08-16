package injappcenter_and.inumarket_android.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import injappcenter_and.inumarket_android.Model.Recycler_categoryDrawer;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.ExpandableListAdapter;

import static android.support.v7.widget.LinearLayoutManager.*;

public class Fragment_category_Drawer extends Fragment {

    private FrameLayout Drawer;
    RecyclerView recyclerview;
    ExpandableListAdapter mAdapter;
    ArrayList<Recycler_categoryDrawer> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       Drawer = (FrameLayout) inflater.inflate(R.layout.fragment_categorydraw,container,false);
       recyclerview = (RecyclerView) Drawer.findViewById(R.id.recyclerView_category);
       recyclerview.setHasFixedSize(true);
       mAdapter = new ExpandableListAdapter(list);
       recyclerview.setLayoutManager(new LinearLayoutManager(this.getActivity()));

       list.add(new Recycler_categoryDrawer(R.drawable.book,"책",R.drawable.erase));
       list.add(new Recycler_categoryDrawer(R.drawable.cloth,"의류",R.drawable.erase));
       list.add(new Recycler_categoryDrawer(R.drawable.electric,"가전/가구",R.drawable.erase));
       list.add(new Recycler_categoryDrawer(R.drawable.etc,"잡화",R.drawable.erase));
       list.add(new Recycler_categoryDrawer(R.drawable.room,"자취방",R.drawable.erase));
       list.add(new Recycler_categoryDrawer(R.drawable.ticket,"식권",R.drawable.erase));

       recyclerview.setItemAnimator(new DefaultItemAnimator());
       recyclerview.setAdapter(mAdapter);

        return Drawer;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
