package injappcenter_and.inumarket_android.Model;

import android.widget.ImageView;

public class Recycler_product_main {

    private ImageView product_image;
    private String product_name;
    private String product_cost;

    public Recycler_product_main(){

    }

    public Recycler_product_main(ImageView product_image, String product_name, String product_cost){
        this.product_image = product_image;
        this.product_name = product_name;
        this.product_cost = product_cost;
    }

    public ImageView getProduct_image() {
        return product_image;
    }

    public void setProduct_image(ImageView product_image) {
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
