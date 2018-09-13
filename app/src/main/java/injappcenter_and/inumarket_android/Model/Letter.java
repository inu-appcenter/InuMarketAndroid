package injappcenter_and.inumarket_android.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Letter {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("letterId")
    @Expose
    private String letterId;
    @SerializedName("sendId")
    @Expose
    private String sendId;
    @SerializedName("reciveId")
    @Expose
    private String reciveId;
    @SerializedName("sellBuy")
    @Expose
    private Boolean sellBuy;
    @SerializedName("letterRead")
    @Expose
    private Boolean letterRead;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productCategory")
    @Expose
    private String productCategory;
    @SerializedName("productSelled")
    @Expose
    private Boolean productSelled;
    @SerializedName("sendDate")
    @Expose
    private String sendDate;
    @SerializedName("senderPhone")
    @Expose
    private String senderPhone;
    @SerializedName("senderName")
    @Expose
    private String senderName;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLetterId() {
        return letterId;
    }

    public void setLetterId(String letterId) {
        this.letterId = letterId;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getReciveId() {
        return reciveId;
    }

    public void setReciveId(String reciveId) {
        this.reciveId = reciveId;
    }

    public Boolean getSellBuy() {
        return sellBuy;
    }

    public void setSellBuy(Boolean sellBuy) {
        this.sellBuy = sellBuy;
    }

    public Boolean getLetterRead() {
        return letterRead;
    }

    public void setLetterRead(Boolean letterRead) {
        this.letterRead = letterRead;
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Boolean getProductSelled() {
        return productSelled;
    }

    public void setProductSelled(Boolean productSelled) {
        this.productSelled = productSelled;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
