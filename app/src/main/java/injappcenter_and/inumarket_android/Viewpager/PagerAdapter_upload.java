package injappcenter_and.inumarket_android.Viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import injappcenter_and.inumarket_android.Fragment.Fragment_upload_category_grid;
import injappcenter_and.inumarket_android.Fragment.Fragment_upload_category_main;

public class PagerAdapter_upload extends FragmentStatePagerAdapter {

    Context context;
    public static int pageNum;

    public PagerAdapter_upload(FragmentManager fragmentManager, int pageNum){
        super(fragmentManager);
        PagerAdapter_upload.pageNum = pageNum;
    }
    @Override
    public Fragment getItem(int pageNum) {
        System.out.print(pageNum);
        switch(pageNum){
            case 0:
                Fragment_upload_category_main fc1 = new Fragment_upload_category_main();
                Log.d("test","switch1");
                return fc1;
            case 1:
                Fragment_upload_category_grid fc2 = new Fragment_upload_category_grid();
                Log.d("test","switch2");
                return fc2;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return pageNum;
    }


}
