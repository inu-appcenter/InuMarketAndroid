package injappcenter_and.inumarket_android.register;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by babareun on 2018-08-12.
 */

public class RegisterRequest extends StringRequest {

    final static private String URL = " http://117.16.231.66:7000/account";
    private Map<String, String> parameters;

    public RegisterRequest(String id, String passwd, String name, String tel, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("id", id);
        parameters.put("passwd", passwd);
        parameters.put("name", name);
        parameters.put("tel", tel );
    }
@Override
    public Map<String, String> getParams(){
        return parameters;
}

}
