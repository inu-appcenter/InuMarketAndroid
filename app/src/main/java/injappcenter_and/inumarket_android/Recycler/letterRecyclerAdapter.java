package injappcenter_and.inumarket_android.Recycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import injappcenter_and.inumarket_android.Activity.letter_send;
import injappcenter_and.inumarket_android.Model.letterDataForm;
import injappcenter_and.inumarket_android.R;

public class letterRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    //private Activity activity;
    //private ArrayList<letterDataForm> list;
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    private List<Item> data=null;

    public letterRecyclerAdapter(List<Item> data) {
        this.data = data;
    }

    public letterRecyclerAdapter(Activity activity, ArrayList<letterDataForm> list) {
        //this.activity = activity;
        //this.list = list;
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        /*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_letter_recycler,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;*/
        View view = null;
        View letterview = null;
        Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
        int subItemPaddingLeft=(int)(20*dp);
        int subItemPaddingTop = (int)(14*dp);
        int subItemPaddingBottom = (int)(27*dp);

        switch(type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.item_letter_recycler,parent,false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                LayoutInflater inflater1 = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                letterview = inflater1.inflate(R.layout.item_letter_context,parent,false);
                ListChildViewHolder child = new ListChildViewHolder(letterview);
                return child;
        }
        return null;
    }

    public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
        /*letterDataForm tmpData = list.get(position);

        holder.tvName.setText(tmpData.getName());*/

        final Item item = data.get(position);
        switch(item.type){
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferaItem = item;
                itemController.header_title.setText(item.text);
                if(item.isRead == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.letter_opened);
                }
                else{
                    itemController.btn_expand_toggle.setImageResource(R.drawable.letter_read);
                }

                itemController.Rclayout.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        System.out.println(item.invisibleChildren);
                        if(item.invisibleChildren == null){
                            item.invisibleChildren = new ArrayList<Item>();
//                            int count = 0;
                            int pos = data.indexOf(itemController.refferaItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1));
//                                count++;
                            }
//                            System.out.println(pos);
//                            System.out.println(count);
                            notifyItemRemoved(pos+1);
//                            System.out.println(item.invisibleChildren);
                            // itemController.btn_expand_toggle.setImageResource(R.drawable.letter_read);
                        }
                        else{
                            int pos = data.indexOf(itemController.refferaItem);
                            int index = pos +1;
                            for(Item i : item.invisibleChildren) {
                                data.add(index,i);
                                index ++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.letter_opened);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD :
                final ListChildViewHolder contentController = (ListChildViewHolder) holder;
//                int[] myHeader = new int[1];
//                for(int i = position; i >= 0; i--){
//                    Item tmpItem = data.get(i);
//                    if(tmpItem.type == HEADER && tmpItem.invisibleChildren != null){
//                        if(tmpItem.invisibleChildren.get(0) == contentController.contentItem){
//                             myHeader[0] = i;
//                        }
//                    }
//                }
                contentController.child_content.setText(data.get(position).text);
                contentController.contentItem = item;

                contentController.close_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        System.out.println(item.invisibleChildren);
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<Item>();
//                            int count = 0;
                            int pos = data.indexOf(contentController.contentItem);
                            while (data.size() > pos && data.get(pos).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos));
//                                count++;
                            }
//                            System.out.println(pos);
//                            System.out.println(count);
//                            notifyItemRangeRemoved(pos, count);
                            notifyItemRemoved(pos);
//                            System.out.println(item.invisibleChildren);
                        }
                    }
                });

                contentController.send_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(),letter_send.class );
                        v.getContext().startActivity(intent);
                    }
                });

                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }
/*
    @Override
    public int getItemCount() {
        return list.size();
    }
*//*
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ViewGroup Rclayout;
        public ViewHolder(View Lview) {
            super(Lview);
            //tvName = (TextView) itemView.findViewById(R.id.letter_Rv_Tv);
            Rclayout = (ViewGroup) Lview.findViewById(R.id.letter_Rv_Vc);


        }
    }*/


    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;
        public ImageView btn_expand_toggle;
        public Item refferaItem;
        public ViewGroup Rclayout;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.letter_Rv_Tv);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.letter_Rv_Rb);
            Rclayout = (ViewGroup) itemView.findViewById(R.id.letter_Rv_Vc);

        }
    }

    private static class ListChildViewHolder extends RecyclerView.ViewHolder {
        public Item contentItem;
        public TextView child_content;
        public Button send_btn;
        public Button close_btn;
        public ViewGroup Ctlayout;

        public ListChildViewHolder(View contentVIew) {
            super(contentVIew);
            child_content = (TextView) contentVIew.findViewById(R.id.letter_Context_text);
            send_btn = (Button) contentVIew.findViewById(R.id.letter_Context_sendBtn);
            close_btn = (Button) contentVIew.findViewById(R.id.letter_Context_closeBtn);
            Ctlayout = (ViewGroup) contentVIew.findViewById(R.id.letter_Context);
        }
    }

    public static class Item {
        public int type;
        public String text;
        public Boolean bool;
        public List<Item> invisibleChildren;
        public List<Item> isRead;

        public Item() {

        }

        public Item(int type, String text) {
            this.type = type;
            this.text = text;
        }

        public Item(String text){
            this.text = text;
        }

    }

}

