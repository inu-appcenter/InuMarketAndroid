package injappcenter_and.inumarket_android.Model;

import android.graphics.ImageFormat;

public class Recycler_product_main {

    private ImageFormat product_image;
    private String product_name;
    private String product_cost;

    public Recycler_product_main(ImageFormat product_image, String product_name, String product_cost){
        this.product_image = product_image;
        this.product_name = product_name;
        this.product_cost = product_cost;
    }

    public ImageFormat getProduct_image() {
        return product_image;
    }

    public void setProduct_image(ImageFormat product_image) {
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
