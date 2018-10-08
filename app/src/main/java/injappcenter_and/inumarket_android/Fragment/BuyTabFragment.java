package injappcenter_and.inumarket_android.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Model.Letter;
import injappcenter_and.inumarket_android.Model.letterDataHeader;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.letterRecyclerAdapter;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class BuyTabFragment extends Fragment{
    RecyclerView rcv;
    letterRecyclerAdapter rcvAdapter = new letterRecyclerAdapter();
    String userId,userToken;
    SharedPreferences pref_info;
    ArrayList<Letter> selledArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        pref_info = this.getActivity().getSharedPreferences("userinfo",MODE_PRIVATE);

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_tab_buy,null);
        userId = pref_info.getString("id","20000000");
        userToken = pref_info.getString("token","");

        rcv = rootview.findViewById(R.id.letterRecycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.addItemDecoration(new DividerItemDecoration(getActivity(),linearLayoutManager.getOrientation()));
        rcv.setLayoutManager(linearLayoutManager);

        if(userId != null){
            Singleton.retrofit.buyLetterList(userToken,userId).enqueue(new Callback<ArrayList<Letter>>() {
                @Override
                public void onResponse(Call<ArrayList<Letter>> call, Response<ArrayList<Letter>> response) {
                    Log.d("sharetest",""+response.code());
                    Log.d("response",""+response.body());
                    if (response.isSuccessful()) {
                        ArrayList<Letter> buyLetterList = response.body();
                        if(buyLetterList != null){
                            for(int i =0; i<buyLetterList.size();i++){
                                Log.d("name",buyLetterList.get(i).getProductName());
                                Log.d("sender",buyLetterList.get(i).getSenderName());
                                if(buyLetterList.get(i).getProductSelled()){
                                    selledArray.addAll(buyLetterList);
                                }
                                else{
                                    rcvAdapter.addItem(new letterDataHeader(buyLetterList.get(i).getProductName(),buyLetterList.get(i).getSenderName(),buyLetterList.get(i).getSenderPhone(),buyLetterList.get(i).getProductCategory(),buyLetterList.get(i).getProductSelled(),0,null));
                                    rcvAdapter.notifyDataSetChanged();
                                }
                            }
                            if(selledArray != null){
                                for(int j = 0 ; j< selledArray.size(); j++){
                                    rcvAdapter.addItem(new letterDataHeader(selledArray.get(j).getProductName(),selledArray.get(j).getSenderName(),selledArray.get(j).getSenderPhone(),selledArray.get(j).getProductCategory(),selledArray.get(j).getProductSelled(),0,null));
                                    rcvAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Letter>> call, Throwable t) {
                    Log.d("err",""+t);
                }
            });
        }

      //  rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","구매자 이름 : 임동완","010-2167-5629","가전가구기타",false,0,null));
      //  rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","구매자 이름 : 임동완","010-2167-5629","가전가구기타",false,0,null));
      //  rcvAdapter.addItem(new letterDataHeader("첫번째 쪽지","구매자 이름 : 임동완","010-2167-5629","가전가구기타",false,0,null));

        rcv.setAdapter(rcvAdapter);

        return rootview;
    }

}
