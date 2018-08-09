package injappcenter_and.inumarket_android.Server;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import injappcenter_and.inumarket_android.Model.LoginResult;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LoginService {

    @FormUrlEncoded
    @POST("login")
    public Call<LoginResult>
    login(@Field("id") String id, @Field("passwd") String passwd);

}
