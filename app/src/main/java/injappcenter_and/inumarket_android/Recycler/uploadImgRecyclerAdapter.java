package injappcenter_and.inumarket_android.Recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Model.imageList;
import injappcenter_and.inumarket_android.R;

public class uploadImgRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<imageList> data = new ArrayList<>(8);
    LayoutInflater inflater;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;

        inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_product_upload_img,parent,false);
        ListViewHolder imageholder = new ListViewHolder(view);
        return imageholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Log.d("viewHolder", String.valueOf(position));
        final imageList iL = data.get(position);
        final ListViewHolder listholder = (ListViewHolder) holder;
        listholder.uploadImage.setImageURI(iL.getImageUri());

    }

    private class ListViewHolder extends RecyclerView.ViewHolder{
        public ImageView uploadImage;

        public ListViewHolder(View itemView){
            super(itemView);
            uploadImage = (ImageView) itemView.findViewById(R.id.upload_img_iv);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void clearItem() {
        for(int i=0; i<data.size();i++){
            notifyItemRemoved(i);
        }
        data = new ArrayList<>();
    }

    public void addItem(imageList Data){
        data.add(Data);
        notifyDataSetChanged();
    }
}
