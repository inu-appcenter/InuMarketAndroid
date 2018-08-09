package injappcenter_and.inumarket_android.Model;

import com.google.gson.annotations.SerializedName;

public class MainProductResult {
    @SerializedName("productImg")
    public String[] productImg;

    @SerializedName("productId")
    public String productId;

    @SerializedName("productName")
    public String productName;

    @SerializedName("productPrice")
    public String productPrice;

    @SerializedName("category")
    public String category;

    @SerializedName("productSelled")
    public String productSelled;

    @SerializedName("updateDate")
    public String updateDate;

    @SerializedName("__v")
    public String __v;


    public String[] getProductImg() {
        return productImg;
    }

    public void setProductImg(String[] productImg) {
        this.productImg = productImg;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductSelled() {
        return productSelled;
    }

    public void setProductSelled(String productSelled) {
        this.productSelled = productSelled;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }
}
