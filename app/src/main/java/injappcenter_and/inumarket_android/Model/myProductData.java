package injappcenter_and.inumarket_android.Model;

public class myProductData {
    private String productId;
    private String productName;
    private String category;
    private boolean productSelled;

    public myProductData(String productId, String productName, String category, boolean productSelled) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.productSelled = productSelled;
    }


    public String getProductId() {
        return productId;
    }

    public boolean isProductSelled() {
        return productSelled;
    }

    public void setProductSelled(boolean productSelled) {
        this.productSelled = productSelled;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
