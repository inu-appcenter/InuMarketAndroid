package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import java.util.Vector;

import injappcenter_and.inumarket_android.Model.Category_Parent;
import injappcenter_and.inumarket_android.Model.Category_child;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.ParentAdapter;

public class Fragment_category_Drawer extends Fragment {
    private ExpandableListView categoryListView;

    private FrameLayout Drawer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       Drawer = (FrameLayout) inflater.inflate(R.layout.fragment_categorydraw,container,false);

        Vector<Category_Parent> data = new Vector<>();
        categoryListView = Drawer.findViewById(R.id.recyclerView_category);
        Category_Parent item1 = new Category_Parent(R.drawable.book,"책",R.drawable.erase);
        Category_Parent item2 = new Category_Parent(R.drawable.cloth,"의류",R.drawable.erase);
        Category_Parent item3 = new Category_Parent(R.drawable.electric,"가전/가구",R.drawable.erase);
        Category_Parent item4 = new Category_Parent(R.drawable.etc,"잡화",R.drawable.erase);
        Category_Parent item5 = new Category_Parent(R.drawable.room,"자취방",R.drawable.erase);
        Category_Parent item6 = new Category_Parent(R.drawable.ticket,"식권",R.drawable.erase);

        item1.child.add(new Category_child("전체"));
        data.add(item1);
        data.add(item2);
        data.add(item3);
        data.add(item4);
        data.add(item5);
        data.add(item6);

        ParentAdapter adapter = new ParentAdapter(this.getActivity(),data);
        categoryListView.setAdapter(adapter);

        return Drawer;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
