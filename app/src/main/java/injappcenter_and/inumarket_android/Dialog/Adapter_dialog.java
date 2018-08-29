package injappcenter_and.inumarket_android.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


import injappcenter_and.inumarket_android.R;

import static injappcenter_and.inumarket_android.R.id.btn_di_phone_change_cancle;
import static injappcenter_and.inumarket_android.R.id.btn_di_phone_change_submit;

public class Adapter_dialog extends Dialog implements View.OnClickListener{

    public Adapter_dialog(@NonNull Context context) {
        super(context);
    }

    protected Button submitButton;
    protected Button cancleButton;

    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_phone_change);

        submitButton = findViewById(R.id.btn_di_phone_change_submit);
        cancleButton = findViewById(R.id.btn_di_phone_change_cancle);

        submitButton.setOnClickListener(this);
        cancleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_di_phone_change_cancle: {
                cancel();
                break;
            }
            case R.id.btn_di_phone_change_submit:
            {   cancel();
                break;
            }
        }
    }
}