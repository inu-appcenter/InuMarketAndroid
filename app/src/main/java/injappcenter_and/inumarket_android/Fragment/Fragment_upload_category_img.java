package injappcenter_and.inumarket_android.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;
import injappcenter_and.inumarket_android.Model.imageList;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Recycler.uploadImgRecyclerAdapter;

public class Fragment_upload_category_img extends Fragment {
    ConstraintLayout img;
    RecyclerView imgRv;
    Button addBtn;
    ConstraintLayout cl_Btn;
    uploadImgRecyclerAdapter uIRv = new uploadImgRecyclerAdapter();
    ArrayList<Uri> addUriList = new ArrayList<Uri>();
    ArrayList<String> sendPhotoList = new ArrayList<String>();
    String sendCategory,sendName,sendState,sendPrice,sendinfo,sendmethod,sendPlace,category;



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        category = getArguments().getString("category");
        sendCategory = getArguments().getString("sendCategory");
        sendName = getArguments().getString("name");
        sendState = getArguments().getString("state");
        sendPrice = getArguments().getString("price");
        sendinfo = getArguments().getString("info");
        sendmethod = getArguments().getString("method");
        sendPlace = getArguments().getString("place");

        final Fragment newFrag = new Fragment_upload_product_detail();
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        cl_Btn = (ConstraintLayout) getActivity().findViewById(R.id.next_btn);
        img = (ConstraintLayout) inflater.inflate(R.layout.fragment_product_upload_img,container,false);
        imgRv = img.findViewById(R.id.upload_img_rv);

        final TedBottomPicker bottomSheetDialogFragment = new TedBottomPicker.Builder(getContext())
                .setOnMultiImageSelectedListener(new TedBottomPicker.OnMultiImageSelectedListener() {
                    @Override
                    public void onImagesSelected(ArrayList<Uri> uriList) {
                        addUriList.clear();
                        uIRv.clearItem();
                        for(int i =0 ; i < uriList.size() ; i++){
                            addUriList.add(uriList.get(i));
                            sendPhotoList.add(uriList.get(i).toString());
                            uIRv.addItem(new imageList(uriList.get(i),false));
                            uIRv.notifyDataSetChanged();
                        }
                    }
                })
                .setPeekHeight(1600)
                .setSelectMaxCount(8)
                .setSelectMinCount(0)
                .setSelectedUriList(addUriList)
                .showTitle(false)
                .setCompleteButtonText("선택")
                .setEmptySelectionText("No Select")
                .create();


        cl_Btn.setVisibility(View.VISIBLE);
        addBtn = (Button) img.findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialogFragment.show(getFragmentManager());
            }
        });


        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),4);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);


        imgRv.setLayoutManager(gridLayoutManager);





        imgRv.setAdapter(uIRv);
        imgRv.addItemDecoration(new uploadRVDecorator(10,10));

        cl_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category",category);
                bundle.putString("sendCategory",sendCategory);
                bundle.putString("name",sendName);
                bundle.putString("state",sendState);
                bundle.putString("price",sendPrice);
                bundle.putString("info",sendinfo);
                bundle.putString("method",sendmethod);
                bundle.putString("place",sendPlace);
                bundle.putStringArrayList("photo",sendPhotoList);
                newFrag.setArguments(bundle);
                transaction.replace(R.id.upload_frameLayout,newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return img;
    }
}


