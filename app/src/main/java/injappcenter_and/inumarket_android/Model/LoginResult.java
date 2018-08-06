package injappcenter_and.inumarket_android.Model;

import com.google.gson.annotations.SerializedName;

public class LoginResult {
    @SerializedName("message")
    public String message;

    @SerializedName("token")
    public String token;

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("tel")
    public String tel;

    public LoginResult(String message, String token , String id, String name , String tel) {
        this.message = message;
        this.token = token;
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.token = name;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String gettel(String tel) { return tel;}

    public void settel(String tel) { this.tel = tel; }

}
