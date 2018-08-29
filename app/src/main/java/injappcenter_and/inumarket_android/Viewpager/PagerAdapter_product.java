package injappcenter_and.inumarket_android.Viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import injappcenter_and.inumarket_android.R;
public class PagerAdapter_product extends PagerAdapter {
    Context context;
    private int[] mResources;

    public PagerAdapter_product(Context context, int[] mResources){
        this.mResources = mResources;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewpager_detail_model,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.image_viewpager_productimage);
        imageView.setImageResource(mResources[position]);
        container.addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }
}
