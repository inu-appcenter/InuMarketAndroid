package injappcenter_and.inumarket_android.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import injappcenter_and.inumarket_android.R;
import injappcenter_and.inumarket_android.Retrofit.Singleton;
import injappcenter_and.inumarket_android.Server.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Adapter_dialog extends Dialog{

    public Adapter_dialog(@NonNull Context context) {
        super(context);
    }

    @BindView(R.id.btn_di_phone_change_submit) protected Button okButton;
    @BindView(R.id.btn_di_phone_change_cancle) protected Button cancelButton;

    public interface OnOkButtonClickListener{
        void onClick();
    }
    public interface OnCancelButtonClickListener{
        void onClick();
    }

    private OnOkButtonClickListener okButtonClickListener = null;
    private OnCancelButtonClickListener cancelButtonClickListener = null;
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

    public void setOnOkButtonClickListener(OnOkButtonClickListener listener){
        okButtonClickListener = listener;
    }
    public void setOnCancelButtonClickListener(OnCancelButtonClickListener listener){
        cancelButtonClickListener = listener;
    }
    @OnClick(R.id.btn_di_phone_change_submit)
    public void okButton(){
        if(okButtonClickListener != null){
            okButtonClickListener.onClick();
        }
        dismiss();
    }

    @OnClick(R.id.btn_di_phone_change_cancle)
    public void cancleButton(){
        if(cancelButtonClickListener != null){
            cancelButtonClickListener.onClick();
        }
        dismiss();
    }

//    public String getSelectWhat() {return selectWhat;}
//    public void setSelectWhat(String selectWhat) {this.selectWhat = selectWhat;}
}