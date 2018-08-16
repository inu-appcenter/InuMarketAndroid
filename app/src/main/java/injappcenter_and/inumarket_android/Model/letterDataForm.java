package injappcenter_and.inumarket_android.Model;

public class letterDataForm {
    private String productName;
    private String senderName;
    private String senderTel;
    private boolean letterRead;

    public letterDataForm(String productName){
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name){
        this.productName = productName;
    }
}
