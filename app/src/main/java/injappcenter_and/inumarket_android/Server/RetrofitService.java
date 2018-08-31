package injappcenter_and.inumarket_android.Server;

import android.support.v4.media.AudioAttributesCompat;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import injappcenter_and.inumarket_android.Model.LoginResult;
import injappcenter_and.inumarket_android.Model.MainProductResult;
import injappcenter_and.inumarket_android.Model.forgotpw_Result;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitService {

    @FormUrlEncoded
    @POST("login")
    public Call<LoginResult>
    login(@Field("id") String id, @Field("passwd") String passwd);

    @FormUrlEncoded
    @POST("stateChange/newPassword")
    public Call<forgotpw_Result>
    forgot_pw(@Field("id") String id, @Field("name") String name);

    @POST("PSelect/main")
    public Call<MainProductResult>
    main(@Header("x-access-token") String token);
}

