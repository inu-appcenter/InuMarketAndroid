package injappcenter_and.inumarket_android.Server;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import injappcenter_and.inumarket_android.Model.Letter;
import injappcenter_and.inumarket_android.Model.LoginResult;
import injappcenter_and.inumarket_android.Model.MainProductResult;
import injappcenter_and.inumarket_android.Model.forgotpw_Result;
import injappcenter_and.inumarket_android.Model.nonSellResult;
import injappcenter_and.inumarket_android.Model.searchId;
import injappcenter_and.inumarket_android.Recycler.ProductDetailAdapter;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitService {

    @FormUrlEncoded
    @POST("tlogin")
    public Call<LoginResult>
    login(@Field("id") String id, @Field("passwd") String passwd,@Field("FCM") String FCM);

    @FormUrlEncoded
    @POST("taccount")
    public Call<JsonObject>
    account(@Field("id") String id, @Field("passwd") String pw, @Field("name") String name, @Field("tel") String tel);

    @FormUrlEncoded
    @POST("tstateChange/newPassword")
    public Call<forgotpw_Result>
    forgot_pw(@Field("id") String id, @Field("name") String name);

    @FormUrlEncoded
    @POST("tstateChange/changeTel")
    public Call<JsonObject>
    changeTel(@Field("id") String id, @Field("newTel") String tel);

    @FormUrlEncoded
    @POST("tstateChange/changePasswd")
    public Call<JsonObject>
    changePasswd(@Field("id") String id, @Field("pastPasswd") String pastpw, @Field("newPasswd") String newpw);

    @POST("tPSelect/main")
    public Call <ArrayList<MainProductResult>>
    main(@Header("x-access-token") String main_token);

    @FormUrlEncoded
    @POST("tPSelect/oneItem")
    public Call<ProductDetailAdapter>
    detail(@Header("x-access-token") String main_token, @Field("productId") String productId);

    @FormUrlEncoded
    @POST("tPSelect/searchId")
    public Call<ArrayList<searchId>>
    searchId(@Header("x-access-token") String main_token, @Field("seller") String sellerid);

    @FormUrlEncoded
    @POST("tPSelect/nonsell")
    public Call<ArrayList<nonSellResult>>
    nonsell(@Header("x-access-token") String main_token, @Field("sellerId") String productId);

    @FormUrlEncoded
    @POST("tletter/list")
    public Call<ArrayList<Letter>>
    letter(@Header("x-access-token") String token, @Field("id") String sellerid);
//
//    @FormUrlEncoded
//    @POST("report")
//    public Call

}

