package injappcenter_and.inumarket_android.Server;

import injappcenter_and.inumarket_android.Model.MainProductResult;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ProductService {
    @POST("main")
    public Call<MainProductResult>
    mainproduct(@Header("x-access-token") String main_token);
}
