package injappcenter_and.inumarket_android.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Model.Recycler_product_main;
import injappcenter_and.inumarket_android.Activity.ProductDetail;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.Mainproduct_Adapter;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class main_product extends android.support.v4.app.Fragment {

    Retrofit retrofit;
    RecyclerView recyclerView;
    Mainproduct_Adapter mAdapter;
    ArrayList<Recycler_product_main> list = new ArrayList<>();
    Spinner spinner;
    String[] spinneritem = {"최신 상품 순", "높은 가격 순", "낮은 가격 순"};
    SharedPreferences pref;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_main_product,null);
        spinner = rootview.findViewById(R.id.spinner_main);
        ArrayAdapter<String> sAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinneritem);
        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(sAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pref =getActivity().getSharedPreferences("userinfo",MODE_PRIVATE);


        String token =  pref.getString("token","");
/*
        if (token != null) {
            Log.d("Sharedpreferences test", "토큰 받은거 확인" + token);
            Singleton.mainproduct.main(token).enqueue(new Callback<MainProductResult>() {
                @Override
                public void onResponse(Call<MainProductResult> call, Response<MainProductResult> response) {

                    if (response.isSuccessful()) {
                        MainProductResult result = response.body();
                        Log.d("maintest", "메인 상품 로딩성공" + result);
                        List<MainProductResult> image = result.new
                        String name = result.productName;
                        String price = result.productPrice;
                        int product_image = (int) image.get(0);

                        do {
                            list.add(new Recycler_product_main(product_image , name , price));
                        }while(result != null);
                    }
                }

                @Override
                public void onFailure(Call<MainProductResult> call, Throwable t) {
                    Log.d("fail", "안돼");
                }
            });
        }
*/

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView_main_product);
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

        for (int i = 0 ; i<12 ; i ++) {
            list.add(new Recycler_product_main(R.drawable.erase,"상품이름","가격"));
        }
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return rootview;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
