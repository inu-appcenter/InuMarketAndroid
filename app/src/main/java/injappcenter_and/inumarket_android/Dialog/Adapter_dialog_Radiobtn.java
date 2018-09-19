package injappcenter_and.inumarket_android.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import injappcenter_and.inumarket_android.R;

public class Adapter_dialog_Radiobtn extends Dialog{
    public Adapter_dialog_Radiobtn(@NonNull Context context) {
        super(context);
    }

    @BindView(R.id.btn_di_radio_submit) protected Button okButton;
    @BindView(R.id.btn_di_radio_cancle) protected Button cancleButton;

    public RadioGroup radio,radio2;

    public interface OnOkButtonClickListener{
        void onClick();
    }
    public interface OnCancelButtonClickListener{
        void onClick();
    }

    private Adapter_dialog.OnOkButtonClickListener okButtonClickListener = null;
    private Adapter_dialog.OnCancelButtonClickListener cancelButtonClickListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_radiobtn);
        ButterKnife.bind(this);

        radio = findViewById(R.id.rg_dialog);
        radio2 = findViewById(R.id.group);
    }

    public void setOnOkButtonClickListener(Adapter_dialog.OnOkButtonClickListener listener){
        okButtonClickListener = listener;
    }
    public void setOnCancelButtonClickListener(Adapter_dialog.OnCancelButtonClickListener listener){
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
}
