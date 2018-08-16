package injappcenter_and.inumarket_android.Recycler;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import injappcenter_and.inumarket_android.Model.Recycler_categoryDrawer;
import injappcenter_and.inumarket_android.R;

public class ExpandableListAdapter extends RecyclerView.Adapter<ExpandableListAdapter.ViewHolder>{

    public ArrayList<Recycler_categoryDrawer> mDataset;
    public ExpandableListAdapter(ArrayList<Recycler_categoryDrawer> myData) {
        this.mDataset = myData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_recycler,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Icon.setImageResource(mDataset.get(position).getCategory_image());
        holder.name.setText(mDataset.get(position).getCategory_name());
        holder.expand.setImageResource(mDataset.get(position).getExpandbtn());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        public ImageView Icon;
        public TextView name;
        public ImageView expand;

        public ViewHolder(View itemView){
            super(itemView);
            Icon = itemView.findViewById(R.id.image_categoryicon);
            name = itemView.findViewById(R.id.txt_categoryitem_recycler);
            expand = itemView.findViewById(R.id.image_expandbtn);
        }
    }


}
