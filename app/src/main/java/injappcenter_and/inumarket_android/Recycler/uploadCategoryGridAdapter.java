package injappcenter_and.inumarket_android.Recycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import injappcenter_and.inumarket_android.Fragment.Fragment_upload_category_nsp;
import injappcenter_and.inumarket_android.R;

public class uploadCategoryGridAdapter extends BaseAdapter {
    private Context context;
    private final String category[];
    private FragmentTransaction Frag;
    private final String middle;
    LayoutInflater inf;



    public uploadCategoryGridAdapter(Context context, FragmentTransaction Frag, String[] category, String middle){
        this.context = context;
        this.Frag = Frag;
        this.category = category;
        this.middle = middle;
    }



    final Fragment newFrag = new Fragment_upload_category_nsp();


    @Override
    public int getCount() {
        return category.length;
    }

    @Override
    public Object getItem(int position) {
        return category[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View gridView;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            gridView = new View(context);
            gridView = inf.inflate(R.layout.item_product_upload_category,null);
            TextView tv = (TextView) gridView.findViewById(R.id.product_upload_main_category_tv);
            tv.setText(category[position]);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("category",middle+category[position]);
                    newFrag.setArguments(bundle);
                    Frag.replace(R.id.upload_frameLayout,newFrag);
                    Frag.addToBackStack(null);
                    Frag.commit();
                }
            });
        }else{
            gridView = (View) convertView;
        }


        return gridView;
    }

}
