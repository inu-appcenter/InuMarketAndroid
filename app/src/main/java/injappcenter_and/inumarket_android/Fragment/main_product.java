package injappcenter_and.inumarket_android.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Model.MainProductResult;
import injappcenter_and.inumarket_android.Model.Recycler_product_main;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.Mainproduct_Adapter;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.support.v7.widget.GridLayoutManager.*;

public class main_product extends android.support.v4.app.Fragment {

    Retrofit retrofit;
    RecyclerView recyclerView;
    Mainproduct_Adapter mAdapter;
    ArrayList<Recycler_product_main> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_main_product,null);

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView_main_product);
        recyclerView.setHasFixedSize(true);
        mAdapter = new Mainproduct_Adapter(list);

        RecyclerView.LayoutManager mLayoutManager;
        mLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
        return rootview;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
      //  prepareData();
    }
    public void prepareData(){
        Bundle bundle = this.getArguments();
        if (bundle!=null){
            String token = bundle.getString("usertoken");
            Log.d("bundletest","액티비티에서 프래그먼트로 토근전송"+ token);
            Singleton.mainproduct.main(token).enqueue(new Callback<MainProductResult>() {
                @Override
                public void onResponse(Call<MainProductResult> call, Response<MainProductResult> response) {
                    MainProductResult result = response.body();
                    if (response.isSuccessful()){
                        Log.d("maintest", "메인 상품 로딩성공");
                        ImageView image = result.getProductImg();
                        list.add(new Recycler_product_main(image,"name","sdf"));
                    }
                }

                @Override
                public void onFailure(Call<MainProductResult> call, Throwable t) {

                }
            });
        }



    }

}
