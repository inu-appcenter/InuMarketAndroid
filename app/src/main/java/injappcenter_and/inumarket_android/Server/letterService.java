package injappcenter_and.inumarket_android.Server;

import injappcenter_and.inumarket_android.Model.letterDataForm;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.Call;

public interface letterService {
    @FormUrlEncoded
    @POST("list")
    public Call<letterDataForm>
    letter_form(@Field("id") String id);
}
