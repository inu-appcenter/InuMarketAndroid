package injappcenter_and.inumarket_android.Server;

import injappcenter_and.inumarket_android.Model.forgotpw_Result;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface stateChangeService {
    @FormUrlEncoded
    @POST("newPassword")
    public Call<forgotpw_Result>
    forgot_pw(@Field("id") String id, @Field("name") String name);
}
