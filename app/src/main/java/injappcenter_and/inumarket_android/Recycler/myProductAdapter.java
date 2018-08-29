package injappcenter_and.inumarket_android.Recycler;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Activity.myProductChangeDialog;
import injappcenter_and.inumarket_android.Activity.myProductCustomDialog;
import injappcenter_and.inumarket_android.Model.myProductData;
import injappcenter_and.inumarket_android.R;

public class myProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<myProductData> data = new ArrayList<>();
    LayoutInflater inflater;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = null;

        inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_my_product_recycler,parent,false);
        ListViewHolder holder = new ListViewHolder(view);
        return holder;

    }

    public void onBindViewHolder( RecyclerView.ViewHolder holder, final int position) {
        final myProductData MPD = data.get(position);
        final ListViewHolder listholder = (ListViewHolder) holder;
        listholder.product_name.setText(MPD.getProductName());

        listholder.Rclayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        listholder.more_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final myProductCustomDialog mpDialog = new myProductCustomDialog(inflater.getContext());
                mpDialog.show();

                mpDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        String selectWhat = mpDialog.getSelectWhat();
                        if(selectWhat=="delete"){
                            System.out.println("this is delete dialog");
                        }
                        else if(selectWhat == "change"){
                            System.out.println(listholder.product_name.getText());
                            final myProductChangeDialog mpCDialog = new myProductChangeDialog(inflater.getContext());
                            mpCDialog.setProductName(listholder.product_name.getText().toString());
                            mpCDialog.show();
                        }
                    }
                });
            }
        });



    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    private static class ListViewHolder extends RecyclerView.ViewHolder{
        public TextView product_name;
        public ImageView category;
        public ViewGroup Rclayout;
        public ImageButton more_btn;

        public ListViewHolder(View itemView) {
            super(itemView);
            product_name = (TextView) itemView.findViewById(R.id.mp_rv_tv);
            category = (ImageView) itemView.findViewById(R.id.mp_rv_category);
            Rclayout = (ViewGroup) itemView.findViewById(R.id.my_product_rv_item);
            more_btn = (ImageButton) itemView.findViewById(R.id.mp_rv_more);
        }
    }

    public void addItem(myProductData Data) {
        data.add(Data);
        notifyItemInserted(data.size()-1);
    }


}
