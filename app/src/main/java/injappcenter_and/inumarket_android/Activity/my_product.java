package injappcenter_and.inumarket_android.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import injappcenter_and.inumarket_android.Model.myProductData;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.myProductAdapter;

public class my_product extends AppCompatActivity {

    private Button mp_more_btn;
    RecyclerView rcv;
    myProductAdapter rcvAdapter = new myProductAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_product);
        rcv = (RecyclerView) findViewById(R.id.my_product_rv_form);
        rcvAdapter = new myProductAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.addItemDecoration(new DividerItemDecoration(this,linearLayoutManager.getOrientation()));
        rcv.setLayoutManager(linearLayoutManager);




        rcvAdapter.addItem(new myProductData("fdsafasd","첫번째 물품","가전가구",false));
        rcvAdapter.addItem(new myProductData("vjklasdf","두번째 물품","가전가구",false));
        rcvAdapter.addItem(new myProductData("fdsafasd","세번째 물품","가전가구",false));

        rcv.setAdapter(rcvAdapter);

    }
}

