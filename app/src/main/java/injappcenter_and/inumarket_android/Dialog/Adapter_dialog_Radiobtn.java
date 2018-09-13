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
import injappcenter_and.inumarket_android.R;

public class Adapter_dialog_Radiobtn extends Dialog{
    public Adapter_dialog_Radiobtn(@NonNull Context context) {
        super(context);
    }

    @BindView(R.id.btn_di_radio_submit) protected Button okButton;
    @BindView(R.id.btn_di_radio_cancle) protected Button cancleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_radiobtn);
        ButterKnife.bind(this);
    }

}
