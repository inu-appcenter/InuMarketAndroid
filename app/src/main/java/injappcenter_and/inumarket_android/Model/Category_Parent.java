package injappcenter_and.inumarket_android.Model;

import java.util.Vector;

public class Category_Parent {

    private int category_image;
    private String category_name;
    private int expandbtn;
    public Vector<Category_child> child;

    public int getExpandbtn() {
        return expandbtn;
    }

    public void setExpandbtn(int expandbtn) {
        this.expandbtn = expandbtn;
    }

    public Category_Parent(int category_image, String category_name, int expandbtn){
        this.category_image = category_image;
        this.category_name = category_name;
        this.expandbtn = expandbtn;
        child = new Vector<>();
    }

    public int getCategory_image() {
        return category_image;
    }

    public void setCategory_image(int category_image) {
        this.category_image = category_image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
