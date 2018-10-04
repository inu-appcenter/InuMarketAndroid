package injappcenter_and.inumarket_android.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import injappcenter_and.inumarket_android.Model.CategoryProduct;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.CategoryRecyclerAdapter;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_category_book_product extends Fragment {
    RecyclerView recyclerView;
    CategoryRecyclerAdapter mAdapter;
//    Spinner spinner;
//    String[] spinneritem = {"최신 상품", "높은 가격", "낮은 가격"};

    TextView txt_category;
    ImageView img_category;
    String parent,child;
    Integer catimage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_category_book_product,container,false);

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
        catimage = getArguments().getInt("categoryimage");

        txt_category = rootview.findViewById(R.id.txt_category_name_num);
        img_category = rootview.findViewById(R.id.image_category_product_icon);

        txt_category.setText(parent +" - "+ child);
        img_category.setImageResource(catimage);

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView_category_book);
        recyclerView.setHasFixedSize(true);

        String fullcategory = parent+child;
        Log.d("fullcategory", fullcategory);

        Singleton.retrofit.category(fullcategory).enqueue(new Callback<ArrayList<CategoryProduct>>() {
            @Override
            public void onResponse(Call<ArrayList<CategoryProduct>> call, Response<ArrayList<CategoryProduct>> response) {
                if (response.isSuccessful()){
                    ArrayList<CategoryProduct> result = response.body();
                    mAdapter.mDataset.addAll(result);
                    mAdapter.notifyDataSetChanged();
                    Log.d("category_product_load", "카테고리별 상품 검색 로딩성공" +result);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CategoryProduct>> call, Throwable t) {

            }
        });

        mAdapter = new CategoryRecyclerAdapter();
        mAdapter.setItemClick(new CategoryRecyclerAdapter.ItemClick() {

            @Override
            public void onClick(View view, int position) {
                String pid = mAdapter.mDataset.get(position).getProductId();
                Intent intent_detail = new Intent(getActivity(), ProductDetail.class);
                intent_detail.putExtra("id",pid);
                startActivity(intent_detail);
            }
        });
        RecyclerView.LayoutManager mLayoutManager;
        mLayoutManager = new GridLayoutManager(getActivity(),3);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        return rootview;
    }
}
