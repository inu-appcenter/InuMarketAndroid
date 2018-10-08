package injappcenter_and.inumarket_android.Model;

public class letterDataHeader {
    private String productName;
    private String senderName;
    private String senderTel;
    private String category;
    private boolean isSelled;
    private int type;
    private letterDataHeader letterDataChild;



    public letterDataHeader(String productName, String senderName, String senderTel, String category, boolean isSelled, int type, letterDataHeader letterDataChild) {
        this.productName = productName;
        this.senderName = senderName;
        this.senderTel = senderTel;
        this.category = category;
        this.isSelled = isSelled;
        this.type = type;

        this.letterDataChild = letterDataChild;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSelled() {
        return isSelled;
    }

    public void setSelled(boolean isSelled) {
        this.isSelled = isSelled;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public letterDataHeader getLetterDataChild() {
        return letterDataChild;
    }

    public void setLetterDataChild(letterDataHeader letterDataChild) {
        this.letterDataChild = letterDataChild;
    }


}

