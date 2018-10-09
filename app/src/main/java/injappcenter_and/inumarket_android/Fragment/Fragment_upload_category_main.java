package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import injappcenter_and.inumarket_android.R;

public class Fragment_upload_category_main extends Fragment {
    ConstraintLayout cl_Btn;
    TextView warningText;
    public Fragment_upload_category_main(){

    }

    ConstraintLayout cm;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        final Fragment newFrag = new Fragment_upload_category_grid();
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        cl_Btn = (ConstraintLayout) getActivity().findViewById(R.id.next_btn);
        warningText = (TextView) getActivity().findViewById(R.id.upload_warningText);

        cl_Btn.setVisibility(View.INVISIBLE);
        warningText.setVisibility(View.INVISIBLE);

        cm = (ConstraintLayout)inflater.inflate(R.layout.fragment_product_upload_category_main,container,false);
        ConstraintLayout Book_btn = (ConstraintLayout)cm.findViewById(R.id.product_upload_category_book);
        ConstraintLayout Cloth_btn = (ConstraintLayout)cm.findViewById(R.id.product_upload_category_cloth);
        ConstraintLayout Electric_btn = (ConstraintLayout)cm.findViewById(R.id.product_upload_category_electric);
        ConstraintLayout Etc_btn = (ConstraintLayout)cm.findViewById(R.id.product_upload_category_etc);
        ConstraintLayout Room_btn = (ConstraintLayout)cm.findViewById(R.id.product_upload_category_room);
        ConstraintLayout Ticket_btn = (ConstraintLayout)cm.findViewById(R.id.product_upload_category_ticket);

        Book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] bookCategory = {
                        "2호관","3호관","4호관","5호관","6호관","7호관","8호관","9호관",
                        "12호관","15호관","16호관","19호관","22호관",
                        "27호관","28호관","29호관"
                };
                String[] sendCategory = {
                        "책2호관","책3호관","책4호관","책5호관","책6호관","책7호관","책8호관","책9호관",
                        "책12호관","책15호관","책16호관","책19호관","책22호관",
                        "책27호관","책28호관","책29호관"
                };
                Bundle bundle = new Bundle();
                bundle.putString("middle","책");
                bundle.putStringArray("category",bookCategory);
                bundle.putStringArray("sendCategory",sendCategory);
                newFrag.setArguments(bundle);
                transaction.replace(R.id.upload_frameLayout,newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        Cloth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] clothCategory = {
                        "여성 의류","남성 의류","가방류","기타"
                };
                String[] sendCategory={
                        "의류여성의류","의류남성의류","의류가방류","의류"
                };
                Bundle bundle = new Bundle();
                bundle.putString("middle","의류");
                bundle.putStringArray("category",clothCategory);
                bundle.putStringArray("sendCategory",sendCategory);
                newFrag.setArguments(bundle);
                transaction.replace(R.id.upload_frameLayout,newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        Electric_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String[] electricCategory = {
                        "컴퓨터","스마트폰","태블릿","TV / 모니터","책상",
                        "의자","매트리스","기타"
                };
                String[] sendCategory={
                        "가전가구컴퓨터","가전가구스마트폰","가전가구태블릿","가전가구TV모니터","가전가구책상",
                        "가전가구의자","가전가구매트리스","가전가구"
                };
                Bundle bundle = new Bundle();
                bundle.putString("middle","가전 / 가구");
                bundle.putStringArray("category",electricCategory);
                bundle.putStringArray("sendCategory",sendCategory);
                newFrag.setArguments(bundle);
                transaction.replace(R.id.upload_frameLayout,newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        Etc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] etcCategory = {
                        "생활/사무","기타"
                };
                String[] sendCategory={
                        "잡화생활사무","잡화"
                };
                Bundle bundle = new Bundle();
                bundle.putString("middle","잡화");
                bundle.putStringArray("category",etcCategory);
                bundle.putStringArray("sendCategory",sendCategory);
                newFrag.setArguments(bundle);
                transaction.replace(R.id.upload_frameLayout,newFrag);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        Room_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] roomCategory = {
                        "원룸","투룸","복층","기타"
                };
                String[] sendCategory={
                        "자취방원룸","자취방투룸","자취방복층","자취방기타"
                };
                Bundle bundle = new Bundle();
                bundle.putString("middle","자취방");
                bundle.putStringArray("category",roomCategory);
                bundle.putStringArray("sendCategory",sendCategory);
                newFrag.setArguments(bundle);
                transaction.replace(R.id.upload_frameLayout,newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        Ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] ticketCategory = {
                        "학생식당","제 1 기숙사","제 2 기숙사"
                };
                String[] sendCategory={
                        "식권학생식당","식권제1기숙사","식권제2기숙사"
                };
                Bundle bundle = new Bundle();
                bundle.putString("middle","식권");
                bundle.putStringArray("category",ticketCategory);
                bundle.putStringArray("sendCategory",sendCategory);
                newFrag.setArguments(bundle);
                transaction.replace(R.id.upload_frameLayout,newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return cm;
    }
}
