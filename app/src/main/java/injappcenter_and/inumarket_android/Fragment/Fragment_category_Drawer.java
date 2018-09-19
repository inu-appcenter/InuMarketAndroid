package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Vector;

import injappcenter_and.inumarket_android.Model.Category_Parent;
import injappcenter_and.inumarket_android.Model.Category_child;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.CategoryAdapter;

public class Fragment_category_Drawer extends Fragment {
    private ExpandableListView categoryListView;

    private FrameLayout Drawer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       Drawer = (FrameLayout) inflater.inflate(R.layout.fragment_categorydraw,container,false);

        categoryListView = Drawer.findViewById(R.id.expandablelist_category);
        Category_Parent item1 = new Category_Parent(R.drawable.book,"책");
        Category_Parent item2 = new Category_Parent(R.drawable.cloth,"의류");
        Category_Parent item3 = new Category_Parent(R.drawable.electric,"가전/가구");
        Category_Parent item4 = new Category_Parent(R.drawable.etc,"잡화");
        Category_Parent item5 = new Category_Parent(R.drawable.room,"자취방");
        Category_Parent item6 = new Category_Parent(R.drawable.ticket,"식권");
        final Category_Parent List[] = new Category_Parent[] {item1,item2,item3,item4,item5,item6};

        String[] string_item;

        for (int i = 0 ; i <6 ; i ++){
            List[i].child.add(new Category_child("전체"));
            switch (i){
                case 0:{
                    for (int j = 2 ; j <= 29 ; j ++){
                        if ((((j>9)&&(j<15))&&(j!=12))||(((j>19)&&(j<27))&&(j!=22))) {
                        }
                        else
                            List[0].child.add(new Category_child(Integer.toString(j)+ "호관"));
                    }
                    break;
                }
                case 1:{
                    string_item = new String[]{"남성 의류", "여성 의류", "가방류"};
                    for (String aString_item : string_item) {
                        List[i].child.add(new Category_child(aString_item));
                    }
                    break;
                }
                case 2:{
                    string_item = new String[]{"컴퓨터", "스마트폰", "태블릿","TV/모니터","책상","의자","매트리스"};
                    for (String aString_item : string_item) {
                        List[i].child.add(new Category_child(aString_item));
                    }
                    break;
                }
                case 3:{
                    List[i].child.add(new Category_child("생활/사무"));
                    break;
                }
                case 4:{
                    string_item = new String[]{"원룸", "투룸", "복층"};
                    for (String aString_item : string_item) {
                        List[i].child.add(new Category_child(aString_item));
                    }
                    break;
                }
                case 5:{
                    string_item = new String[]{"학식", "제 1기식", "제 2기식"};
                    for (String aString_item : string_item) {
                        List[i].child.add(new Category_child(aString_item));
                    }
                    break;
                }
            }
            List[i].child.add(new Category_child("기타"));
        }

        Vector<Category_Parent> data = new Vector<>(Arrays.asList(List).subList(0, 6));

        CategoryAdapter adapter = new CategoryAdapter(this.getActivity(),data);
        categoryListView.setAdapter(adapter);

        //child클릭이벤트 넣기
        categoryListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                int image = List[groupPosition].getCategory_image();
                String namechild = List[groupPosition].child.get(childPosition).getChildname();
                String nameparent = List[groupPosition].getCategory_name();

                Bundle bundle = new Bundle();
                bundle.putString("child",namechild);
                bundle.putString("parent",nameparent);
                bundle.putInt("categoryimage", image);

                if (nameparent.equals("가전/가구")){
                    Fragment_category_electronic_product category_electronic_product = new Fragment_category_electronic_product();
                    category_electronic_product.setArguments(bundle);

                    getActivity().getFragmentManager().beginTransaction()
                            .replace(R.id.container, category_electronic_product)
                            .addToBackStack(null)
                            .commit();
                }
                else {
                    Fragment_category_book_product categoryproduct = new Fragment_category_book_product();
                    categoryproduct.setArguments(bundle);

                    getActivity().getFragmentManager().beginTransaction()
                            .replace(R.id.container, categoryproduct)
                            .addToBackStack(null)
                            .commit();
                }

                DrawerLayout drawer = getActivity().findViewById(R.id.drawer);
                drawer.closeDrawer(Gravity.START);

                categoryListView.collapseGroup(groupPosition);

                return false;
            }
        });

        categoryListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                parent.smoothScrollToPosition(groupPosition);
                ImageView iv = v.findViewById(R.id.image_expandbtn);

                if (parent.isGroupExpanded(groupPosition)) {
                    iv.setImageResource(R.drawable.list_down);
                } else {
                    iv.setImageResource(R.drawable.list_up);
                }
                return false;
            }
        });

        return Drawer;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
