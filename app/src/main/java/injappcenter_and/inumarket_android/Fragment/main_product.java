package injappcenter_and.inumarket_android.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
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
import java.util.List;

import injappcenter_and.inumarket_android.Activity.ProductDetail;
import injappcenter_and.inumarket_android.Activity.letter_form;
import injappcenter_and.inumarket_android.Model.Letter;
import injappcenter_and.inumarket_android.Model.MainProductResult;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.Mainproduct_Adapter;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class main_product extends android.support.v4.app.Fragment {

    ConstraintLayout btn_mail;
    RecyclerView recyclerView;
    Mainproduct_Adapter mAdapter;
    ArrayList<MainProductResult> list = new ArrayList<>();
    Spinner spinner;
    String[] spinneritem = {"최신 상품 순", "높은 가격 순", "낮은 가격 순"};
    SharedPreferences pref;
    List<String> product_image;
    private String name, productid;
    Integer price;
    ImageView productimg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_main_product,null);
        spinner = rootview.findViewById(R.id.spinner_main);
        ArrayAdapter<String> sAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinneritem);
        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        productimg = (ImageView) rootview.findViewById(R.id.image_main_product);

        btn_mail = rootview.findViewById(R.id.btn_main_mail);
        btn_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),letter_form.class);
                startActivity(intent);
            }
        });

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

        pref =getActivity().getSharedPreferences("userinfo",MODE_PRIVATE);
        String token =  pref.getString("token","");
        String id = pref.getString("id","");

        Singleton.retrofit.letter(token, id).enqueue(new retrofit2.Callback<ArrayList<Letter>>() {
            @Override
            public void onResponse(Call<ArrayList<Letter>> call, Response<ArrayList<Letter>> response) {
                if (response.isSuccessful()){
                    TextView newmail = rootview.findViewById(R.id.txt_mainproduct_newmail);
                    ArrayList<Letter> result = response.body();
                    String mailnum = String.valueOf(result.size());
                    Log.d("letter_service",mailnum);
                    newmail.setText(mailnum);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Letter>> call, Throwable t) {

            }
        });
        if (!token.equals("")) {
            Log.d("Sharedpreferences test", "토큰 받은거 확인" + token);
            Singleton.retrofit.main(token).enqueue(new Callback<ArrayList<MainProductResult>>() {
                @Override
                public void onResponse(Call<ArrayList<MainProductResult>> call, Response<ArrayList<MainProductResult>> response) {
                    Log.d("main recycler test", ""+response.code());
                    if (response.isSuccessful()) {
                        ArrayList<MainProductResult> result = response.body();
                        if (result == null){

                        }
                        mAdapter.mDataset.addAll(result);
                        mAdapter.notifyDataSetChanged();
                        Log.d("maintest", "메인 상품 로딩성공" + result.get(0).getProductId());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<MainProductResult>> call, Throwable t) {
                    Log.d("fail", "안돼");
                }
            });
        }

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView_main_product);
        recyclerView.setHasFixedSize(true);

        mAdapter = new Mainproduct_Adapter();
        mAdapter.setItemClick(new Mainproduct_Adapter.ItemClick() {

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
