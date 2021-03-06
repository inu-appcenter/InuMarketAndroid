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

public class Adapter_dialog_onebutton extends Dialog{

    public Adapter_dialog_onebutton(@NonNull Context context) {
        super(context);
    }

    @BindView(R.id.btn_di_submit) protected Button okButton;

    private TextView mTitleView;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_custom_onebutton);
        ButterKnife.bind(this);
        mTitleView = findViewById(R.id.txt_di_one);
        setdialogtxt(mTitle);
    }
    public Adapter_dialog_onebutton(Context context, String title){
        super(context);
        this.mTitle = title;
    }

    public void setdialogtxt(String text){
        mTitleView.setText(text);
    }

    @OnClick(R.id.btn_di_submit)
    public void okButton(){
        dismiss();
    }
}
