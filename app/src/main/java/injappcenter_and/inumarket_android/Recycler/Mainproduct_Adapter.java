package injappcenter_and.inumarket_android.Recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Config;
import injappcenter_and.inumarket_android.Model.MainProductResult;
import injappcenter_and.inumarket_android.R;



public class Mainproduct_Adapter extends RecyclerView.Adapter<Mainproduct_Adapter.ViewHolder> {

    public ArrayList<MainProductResult> mDataset = new ArrayList<>();
    public ItemClick itemClick;
    public interface ItemClick{
        public void onClick(View view, int position);
    }

    public void setItemClick(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    // Data is passed into the constructor
    public Mainproduct_Adapter(){

    }
    public Mainproduct_Adapter(ArrayList<MainProductResult> myData) {
        this.mDataset.addAll(myData);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView productimg;
        public TextView name,price;
        public String productid;

        public ViewHolder(View itemView){
            super(itemView);
            productimg = itemView.findViewById(R.id.image_main_product);
            name = itemView.findViewById(R.id.txt_main_productname);
            price =itemView.findViewById(R.id.txt_main_productprice);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_main_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mainproduct_Adapter.ViewHolder holder, final int position) {
//        holder.productimg.setImageResource(mDataset.get(position).getProduct_image());
        holder.name.setText(mDataset.get(position).getProductName());
        holder.price.setText(mDataset.get(position).getProductPrice() + "");
        Glide.with(holder.productimg).load(Config.serverUrl + "imgload/" + mDataset.get(position).getProductImg().get(0)).into(holder.productimg);
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (itemClick != null){
                    itemClick.onClick(v,position);
                }
            }
        });
    }

    // Total number of cells
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}