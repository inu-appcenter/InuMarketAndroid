package injappcenter_and.inumarket_android.Retrofit;

import injappcenter_and.inumarket_android.Config;
import injappcenter_and.inumarket_android.Server.RetrofitService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Singleton {

    public static final Singleton ourInstance = new Singleton();
    public static final RetrofitService retrofit = new Retrofit.Builder()
            .baseUrl(Config.serverUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService.class);

    public Singleton() {
    }
}
