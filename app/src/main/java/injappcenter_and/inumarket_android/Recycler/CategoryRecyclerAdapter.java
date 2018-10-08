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
import injappcenter_and.inumarket_android.Model.CategoryProduct;
import injappcenter_and.inumarket_android.R;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder> {

    public ArrayList<CategoryProduct> mDataset = new ArrayList<>();
    public CategoryRecyclerAdapter.ItemClick itemClick;
    public interface ItemClick{
        public void onClick(View view, int position);
    }

    public void setItemClick(CategoryRecyclerAdapter.ItemClick itemClick){
        this.itemClick = itemClick;
    }

    // Data is passed into the constructor
    public CategoryRecyclerAdapter(){

    }
    public CategoryRecyclerAdapter(ArrayList<CategoryProduct> myData) {
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
    public CategoryRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_main_recycler,parent,false);
        return new CategoryRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerAdapter.ViewHolder holder, final int position) {
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
