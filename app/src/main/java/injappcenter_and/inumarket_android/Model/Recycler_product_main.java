package injappcenter_and.inumarket_android.Model;

import android.widget.ImageView;

import java.util.List;

public class Recycler_product_main {

    private int product_image;
    private String product_name;
    private String product_cost;
    private String product_id;

    public Recycler_product_main(List image, String name, String price, String product_id){

    }

    public Recycler_product_main(int product_image, String product_name, String product_cost, String product_id){
        this.product_image = product_image;
        this.product_name = product_name;
        this.product_cost = product_cost;
        this.product_id = product_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }

    public String getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(String product_cost) {
        this.product_cost = product_cost;
    }
}
