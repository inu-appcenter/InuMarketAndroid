package injappcenter_and.inumarket_android.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Activity.ProductDetail;
import injappcenter_and.inumarket_android.Model.MainProductResult;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.Mainproduct_Adapter;

public class Fragment_category_electronic_product extends Fragment {
    RecyclerView recyclerView;
    Mainproduct_Adapter mAdapter;
    ArrayList<MainProductResult> list = new ArrayList<>();
//    Spinner spinner;
//    String[] spinneritem = {"최신 상품", "높은 가격", "낮은 가격"};

    TextView txt_category;
    String parent,child;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_category_electronic_product,container,false);

//        spinner = rootview.findViewById(R.id.spinner_category_elec);
//        ArrayAdapter<String> sAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinneritem);
//        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(sAdapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        parent = getArguments().getString("parent","");
        child = getArguments().getString("child","");

        txt_category = rootview.findViewById(R.id.txt_category_elec_name);
        txt_category.setText(parent +" - "+ child);

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView_category_elec);
        recyclerView.setHasFixedSize(true);
        mAdapter = new Mainproduct_Adapter(list);
        mAdapter.setItemClick(new Mainproduct_Adapter.ItemClick() {
            @Override
            public void onClick(View view, int position) {
                Intent intent_detail = new Intent(getActivity(), ProductDetail.class);
                startActivity(intent_detail);
            }
        });
        RecyclerView.LayoutManager mLayoutManager;
        mLayoutManager = new GridLayoutManager(getActivity(),3);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        return rootview;

    }
}
