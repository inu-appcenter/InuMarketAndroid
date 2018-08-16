package injappcenter_and.inumarket_android.Retrofit;

import injappcenter_and.inumarket_android.Server.LoginService;
import injappcenter_and.inumarket_android.Server.ProductService;
import injappcenter_and.inumarket_android.Server.letterService;
import injappcenter_and.inumarket_android.Server.stateChangeService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singleton {

    public static final Singleton ourInstance = new Singleton();
    public static final LoginService retrofitLogin = new Retrofit.Builder()
            .baseUrl("http://117.16.231.66:7000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoginService.class);

    public static final ProductService mainproduct = new Retrofit.Builder()
            .baseUrl("http://117.16.231.66:7000/PSelect/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductService.class);

    public static final stateChangeService statechange = new Retrofit.Builder()
            .baseUrl("http://117.16.231.66:7000/stateChange/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(stateChangeService.class);

    public static final letterService letterWork = new Retrofit.Builder()
            .baseUrl("http://117.16.231.66:7000/letter/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(letterService.class);



    public Singleton() {
    }
}
