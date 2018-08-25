package injappcenter_and.inumarket_android.register;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by babareun on 2018-08-24.
 */

public interface ApiService {
    public static final String API_URL = "http://117.16.231.66:7000/";

    @FormUrlEncoded
    @POST("account")
    Call<ResponseBody>getPostCommenStr(@Field("id") String CONST_SCHOOL_NUM , @Field("passwd") String CONST_PASS, @Field("name") String CONST_NAME, @Field("tel") String CONST_PHONE);
}
