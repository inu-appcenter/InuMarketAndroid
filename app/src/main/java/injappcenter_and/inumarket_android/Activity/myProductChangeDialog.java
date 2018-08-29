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

public class myProductChangeDialog extends Dialog {
    @BindView(R.id.di_change_tv) protected TextView chText;
    @BindView(R.id.di_change_submit) protected Button submitButton;
    @BindView(R.id.di_change_cancle) protected Button cancleButton;

    private String answer;
    private String productName;

    public myProductChangeDialog(Context context){super(context);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_change_product);
        ButterKnife.bind(this);
        System.out.println(chText.getText());
        chText.setText("'"+productName+"'을(를)");
    }

    @OnClick(R.id.di_change_submit)
    public void submitButton(){
        answer = "change";
        dismiss();
    }

    @OnClick(R.id.di_change_cancle)
    public void cancleButton(){
        answer = "cancle";
        dismiss();
    }

    public String getAnswer() {return answer;}
    public void setAnswer(String answer) {this.answer = answer;}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
