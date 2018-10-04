package injappcenter_and.inumarket_android.Activity;

import android.Manifest;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import injappcenter_and.inumarket_android.Fragment.Fragment_upload_category_main;
import injappcenter_and.inumarket_android.R;

public class product_upload extends FragmentActivity {

    private ViewPager viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_upload);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        final PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(product_upload.this,"Permission grant",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(product_upload.this,"Permission Denied\n"+ deniedPermissions.toString(),Toast.LENGTH_SHORT).show();
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission] ")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        Fragment_upload_category_main fucm = new Fragment_upload_category_main();

        fragmentTransaction.add(R.id.upload_frameLayout,fucm);
        fragmentTransaction.commit();

        /*
        String[] category = {
                "2호관","3호관","4호관","5호관","6호관","7호관","8호관","9호관",
                "12호관","15호관","16호관","19호관","22호관",
                "27호관","28호관","29호관"
        };

        uploadCategoryGridAdapter GA = new uploadCategoryGridAdapter(product_upload.this,
                category);

        GridView gv = (GridView)findViewById(R.id.category_grid);
        gv.setAdapter(GA);*/
        //그리드 아답터

/*
        viewpager = (ViewPager)findViewById(R.id.product_upload_vp);
        PagerAdapter_upload mPagerAdapter = new PagerAdapter_upload(getSupportFragmentManager(),0);
        viewpager.setAdapter(mPagerAdapter);
*/
    }
}
