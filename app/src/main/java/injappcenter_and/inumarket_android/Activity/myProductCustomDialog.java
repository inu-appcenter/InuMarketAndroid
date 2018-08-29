package injappcenter_and.inumarket_android.Activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import injappcenter_and.inumarket_android.R;

public class myProductCustomDialog extends Dialog {
    @BindView(R.id.my_product_di_state) protected TextView stateChange;
    @BindView(R.id.my_product_di_delete) protected TextView productDelete;
    @BindView(R.id.my_product_di_ok) protected Button okButton;
    @BindView(R.id.my_product_di_cancle) protected Button cancleButton;


    private String selectWhat;

    public myProductCustomDialog(Context context){super(context); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_for_my_product);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.my_product_di_state)
    public void stateChange(){
        selectWhat="change";
    }

    @OnClick(R.id.my_product_di_delete)
    public void productDelete(){
        selectWhat="delete";
    }

    @OnClick(R.id.my_product_di_ok)
    public void okButton(){
        dismiss();
    }

    @OnClick(R.id.my_product_di_cancle)
    public void cancleButton(){
        dismiss();
    }

    public String getSelectWhat() {return selectWhat;}
    public void setSelectWhat(String selectWhat) {this.selectWhat = selectWhat;}

}
