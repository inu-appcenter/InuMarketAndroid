package injappcenter_and.inumarket_android.Recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import injappcenter_and.inumarket_android.Model.Recycler_product_main;
import injappcenter_and.inumarket_android.R;

class ViewHolder extends RecyclerView.ViewHolder{
    ImageView productImage;
    TextView productName, productPrice;

    public ViewHolder(View itemView){
        super(itemView);
        productImage = itemView.findViewById(R.id.view_main_product_image);
        productName = itemView.findViewById(R.id.txt_main_productname);
        productPrice = itemView.findViewById(R.id.txt_main_productprice);

    }
}

public class Mainproduct_Adapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private int resourceId;
    private List<Recycler_product_main> dataList;

    public Mainproduct_Adapter(Context context, int resourceId, List<Recycler_product_main> dataList) {
        this.context = context;
        this.resourceId = resourceId;
        this.dataList = dataList;


}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(resourceId,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Recycler_product_main recycler_product_main = dataList.get(i);
        //viewHolder.productImage.setImageDrawable(recycler_product_main.getProduct_image());
        viewHolder.productName.setText(recycler_product_main.getProduct_name());
        viewHolder.productPrice.setText(recycler_product_main.getProduct_cost());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}