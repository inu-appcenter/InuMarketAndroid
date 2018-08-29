package injappcenter_and.inumarket_android.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import injappcenter_and.inumarket_android.Activity.letter_send;
import injappcenter_and.inumarket_android.Model.letterDataHeader;
import injappcenter_and.inumarket_android.R;

public class letterRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    //private Activity activity;
    //private ArrayList<letterDataHeader> list;
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    private ArrayList<letterDataHeader> data = new ArrayList<>();



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        View letterview = null;
        Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;

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

    public void onBindViewHolder (RecyclerView.ViewHolder holder,final int position) {

        final letterDataHeader LDH = data.get(position);
        if(holder instanceof ListHeaderViewHolder) {
            ListHeaderViewHolder header = (ListHeaderViewHolder) holder;

            header.header_title.setText(LDH.getProductName());
            if(LDH.isLetterRead()){
                header.btn_expand_toggle.setImageResource(R.drawable.letter_opened);
            }
            else{
                header.btn_expand_toggle.setImageResource(R.drawable.letter_read);
            }

            header.Rclayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(LDH.getLetterDataChild() == null){
                        int position = data.indexOf(LDH);
                        data.add(position+1,new letterDataHeader(LDH.getProductName(),LDH.getSenderName(),LDH.getSenderTel(),LDH.getCategory(),LDH.isLetterRead(),1, LDH));
                        LDH.setLetterDataChild(LDH);
                        notifyItemInserted(position+1);
                    }
                    else{
                        int position = data.indexOf(LDH.getLetterDataChild());
                        data.remove(position+1);
                        notifyItemRemoved(position+1);
                        LDH.setLetterDataChild(null);
                    }

                }
            });
        }
        else{
            ListChildViewHolder child = (ListChildViewHolder) holder;

            child.child_content.setText(LDH.getSenderName()+"\n"+"전화번호 : "+LDH.getSenderTel());

            child.close_btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = data.indexOf(LDH);
                    data.remove(position);
                    LDH.getLetterDataChild().setLetterDataChild(null);
                    notifyItemRemoved(position);

                    System.out.println(position);
                    System.out.println(LDH.getLetterDataChild());
                }

            });

            child.send_btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),letter_send.class );
                    intent.putExtra("tel",LDH.getSenderTel());
                    intent.putExtra("name",LDH.getSenderName());
                    v.getContext().startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;
        public ImageView btn_expand_toggle;
        public ViewGroup Rclayout;
        public boolean isRead;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.letter_Rv_Tv);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.letter_Rv_Rb);
            Rclayout = (ViewGroup) itemView.findViewById(R.id.letter_Rv_Vc);

        }
    }

    private static class ListChildViewHolder extends RecyclerView.ViewHolder {
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



    public void addItem(letterDataHeader Data)  {
        data.add(Data);
        notifyItemInserted(data.size()-1);
    }
}

