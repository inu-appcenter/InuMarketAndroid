package injappcenter_and.inumarket_android.Recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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
            final ListHeaderViewHolder header = (ListHeaderViewHolder) holder;
            String category_first_char = LDH.getCategory().substring(0,1);
            switch (category_first_char){
                case "책":
                    header.category.setImageResource(R.drawable.book);
                    break;
                case "의":
                    header.category.setImageResource(R.drawable.cloth);
                    break;
                case "가":
                    header.category.setImageResource(R.drawable.electric);
                    break;
                case "잡":
                    header.category.setImageResource(R.drawable.etc);
                    break;
                case "자":
                    header.category.setImageResource(R.drawable.room);
                    break;
                case "식":
                    header.category.setImageResource(R.drawable.ticket);
                    break;
                    default:
                        break;
            }
            header.header_title.setText(LDH.getProductName());
            if(LDH.isSelled()){
                header.isSelled.setVisibility(View.VISIBLE);
            }
            else{
                header.isSelled.setVisibility(View.GONE);
                header.Rclayout.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(LDH.getLetterDataChild() == null){
                            int position = data.indexOf(LDH);
                            data.add(position+1,new letterDataHeader(LDH.getProductName(),LDH.getSenderName(),LDH.getSenderTel(),LDH.getCategory(),LDH.isSelled(),1, LDH));
                            header.btn_expand_toggle.setImageResource(R.drawable.list_down);
                            LDH.setLetterDataChild(LDH);
                            notifyItemInserted(position+1);
                        }
                        else{
                            int position = data.indexOf(LDH.getLetterDataChild());
                            data.remove(position+1);
                            header.btn_expand_toggle.setImageResource(R.drawable.list_up);
                            notifyItemRemoved(position+1);
                            LDH.setLetterDataChild(null);
                        }

                    }
                });
            }


        }
        else{
            ListChildViewHolder child = (ListChildViewHolder) holder;

            child.child_content.setText("이름 : " +LDH.getSenderName()+"\n"+"전화번호 : "+LDH.getSenderTel());

//            child.close_btn.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    int position = data.indexOf(LDH);
//                    data.remove(position);
//                    LDH.getLetterDataChild().setLetterDataChild(null);
//
//                    notifyItemRemoved(position);
//
//                    System.out.println(position);
//                    System.out.println(LDH.getLetterDataChild());
//                }
//
//            });

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
        public ImageView category;
        public ViewGroup Rclayout;
        public TextView isSelled;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.letter_Rv_Tv);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.letter_open_iv);
            category = (ImageView) itemView.findViewById(R.id.letter_Rv_Iv);
            Rclayout = (ViewGroup) itemView.findViewById(R.id.letter_Rv_Vc);
            isSelled = (TextView) itemView.findViewById(R.id.selled_Text);

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
            //close_btn = (Button) contentVIew.findViewById(R.id.letter_Context_closeBtn);
            Ctlayout = (ViewGroup) contentVIew.findViewById(R.id.letter_Context);
        }
    }



    public void addItem(letterDataHeader Data)  {
        data.add(Data);
        notifyItemInserted(data.size()-1);
    }
}

