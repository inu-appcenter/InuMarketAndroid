package injappcenter_and.inumarket_android.Recycler;

import android.app.Activity;
import android.content.Context;
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
                LinearLayout Ll = new LinearLayout(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                        (ViewGroup.LayoutParams.MATCH_PARENT,
                         146);
                Ll.setLayoutParams(params);

                TextView itemTextView = new TextView(context);
                itemTextView.setPadding(subItemPaddingLeft,subItemPaddingTop,0,subItemPaddingBottom);
                LinearLayout.LayoutParams itemTextViewParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        90
                );
                itemTextView.setLayoutParams(itemTextViewParams);
                itemTextView.setTextSize(16);
                itemTextView.setText("텍스트부분입니다");
                itemTextView.setTag("letterInfo");

                Button sendItemButton = new Button(context);
                LinearLayout.LayoutParams sendItemButtonParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        56
                );
                sendItemButton.setLayoutParams(sendItemButtonParams);
                sendItemButton.setText("전송버튼입니다");


                Ll.addView(itemTextView);
                Ll.addView(sendItemButton);
                return new RecyclerView.ViewHolder(Ll) {
                };
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
                        if(item.invisibleChildren == null){
                            item.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferaItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos+1,count);
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
                LinearLayout Ll = (LinearLayout) holder.itemView;
                ((TextView) Ll.findViewWithTag("letterInfo")).setText(data.get(position).text);
                //TextView itemTextView = (TextView) holder.itemView;
                //itemTextView.setText(data.get(position).text);
               // Button sendItemButton = (Button) holder.itemView;
               // sendItemButton.setText("버튼입니다");
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

