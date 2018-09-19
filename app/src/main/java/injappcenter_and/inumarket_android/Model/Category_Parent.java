package injappcenter_and.inumarket_android.Model;

import java.util.Vector;

public class Category_Parent {

    private int category_image;
    private String category_name;

    public Vector<Category_child> child;

    public Category_Parent(int category_image, String category_name){
        this.category_image = category_image;
        this.category_name = category_name;

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
