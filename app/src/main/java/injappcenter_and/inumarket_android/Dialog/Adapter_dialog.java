package injappcenter_and.inumarket_android.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import injappcenter_and.inumarket_android.R;

public class Adapter_dialog extends Dialog{

    public Adapter_dialog(@NonNull Context context) {
        super(context);
    }

    @BindView(R.id.btn_di_phone_change_submit) protected Button okButton;
    @BindView(R.id.btn_di_phone_change_cancle) protected Button cancleButton;

    private TextView mTitleView;
    private String mTitle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_custom_settingpage);
        ButterKnife.bind(this);
        mTitleView = findViewById(R.id.txt_phonedialog);
        setdialogtxt(mTitle);
    }
    public Adapter_dialog(Context context, String title){
        super(context);
        this.mTitle = title;
    }

//
//    @OnClick(R.id.my_product_di_state)
//    public void stateChange(){
//        selectWhat="change";
//    }
//
//    @OnClick(R.id.my_product_di_delete)
//    public void productDelete(){
//        selectWhat="delete";
//    }

    public void setdialogtxt(String text){
        mTitleView.setText(text);
    }

    @OnClick(R.id.btn_di_phone_change_submit)
    public void okButton(){
        dismiss();
    }

    @OnClick(R.id.btn_di_phone_change_cancle)
    public void cancleButton(){
        dismiss();
    }

//    public String getSelectWhat() {return selectWhat;}
//    public void setSelectWhat(String selectWhat) {this.selectWhat = selectWhat;}
}