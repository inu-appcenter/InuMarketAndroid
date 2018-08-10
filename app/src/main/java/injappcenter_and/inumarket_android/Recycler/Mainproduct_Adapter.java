package injappcenter_and.inumarket_android.Recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import injappcenter_and.inumarket_android.Model.Recycler_product_main;
import injappcenter_and.inumarket_android.R;



public class Mainproduct_Adapter extends RecyclerView.Adapter<Mainproduct_Adapter.ViewHolder> {

    public ArrayList<Recycler_product_main> mDataset;

    // Data is passed into the constructor
    public Mainproduct_Adapter(ArrayList<Recycler_product_main> myData) {
        this.mDataset = myData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView productimg;
        public TextView name,price;

        public ViewHolder(View itemView){
            super(itemView);
            productimg = itemView.findViewById(R.id.view_main_product_image);
            name = itemView.findViewById(R.id.txt_main_productname);
            price =itemView.findViewById(R.id.txt_main_productprice);
        }
    }

    // Inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_main_recycler,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mainproduct_Adapter.ViewHolder holder, int position) {
        holder.name.setText(mDataset.get(position).getProduct_name());
        holder.price.setText(mDataset.get(position).getProduct_cost());
    }

    // Total number of cells
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}