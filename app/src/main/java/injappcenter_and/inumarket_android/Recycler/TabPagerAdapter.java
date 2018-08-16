package injappcenter_and.inumarket_android.Recycler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import injappcenter_and.inumarket_android.Fragment.BuyTabFragment;
import injappcenter_and.inumarket_android.Fragment.SellTabFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                BuyTabFragment buyTabFragment = new BuyTabFragment();
                return buyTabFragment;
            case 1:
                SellTabFragment sellTabFragment = new SellTabFragment();
                return sellTabFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
