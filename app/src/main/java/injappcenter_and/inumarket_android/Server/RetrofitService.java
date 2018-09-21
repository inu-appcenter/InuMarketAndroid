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
    @POST("login")
    public Call<LoginResult>
    login(@Field("id") String id, @Field("passwd") String passwd,@Field("FCM") String FCM);

    @FormUrlEncoded
    @POST("account")
    public Call<JsonObject>
    account(@Field("id") String id, @Field("passwd") String pw, @Field("name") String name, @Field("tel") String tel);

    @FormUrlEncoded
    @POST("stateChange/newPassword")
    public Call<forgotpw_Result>
    forgot_pw(@Field("id") String id, @Field("name") String name);

    @FormUrlEncoded
    @POST("stateChange/changeTel")
    public Call<JsonObject>
    changeTel(@Field("id") String id, @Field("newTel") String tel);

    @FormUrlEncoded
    @POST("stateChange/changePasswd")
    public Call<JsonObject>
    changePasswd(@Field("id") String id, @Field("pastPasswd") String pastpw, @Field("newPasswd") String newpw);

    @POST("PSelect/main")
    public Call <ArrayList<MainProductResult>>
    main(@Header("x-access-token") String main_token);

    @FormUrlEncoded
    @POST("PSelect/oneItem")
    public Call<ProductDetailAdapter>
    detail(@Header("x-access-token") String main_token, @Field("productId") String productId);

    @FormUrlEncoded
    @POST("PSelect/searchId")
    public Call<ArrayList<searchId>>
    searchId(@Header("x-access-token") String main_token, @Field("seller") String sellerid);

    @FormUrlEncoded
    @POST("PSelect/nonsell")
    public Call<ArrayList<nonSellResult>>
    nonsell(@Header("x-access-token") String main_token, @Field("sellerId") String productId);

    @FormUrlEncoded
    @POST("letter/list")
    public Call<ArrayList<Letter>>
    letter(@Header("x-access-token") String token, @Field("id") String sellerid);
//
//    @FormUrlEncoded
//    @POST("report")
//    public Call

}

