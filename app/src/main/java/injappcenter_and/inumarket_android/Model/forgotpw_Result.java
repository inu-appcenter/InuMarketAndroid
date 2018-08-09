package injappcenter_and.inumarket_android.Model;

import com.google.gson.annotations.SerializedName;

public class forgotpw_Result {
    @SerializedName("ans")
    public String ans;

    public forgotpw_Result(String ans) {
        this.ans = ans;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}