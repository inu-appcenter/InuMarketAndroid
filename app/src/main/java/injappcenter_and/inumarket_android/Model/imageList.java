package injappcenter_and.inumarket_android.Model;

import android.net.Uri;

public class imageList {
    private Uri imageUri;
    private boolean addimg;

    public imageList(Uri imageUri, boolean addimg) {
        this.imageUri = imageUri;
        this.addimg = addimg;

    }

    public boolean isAddimg() {
        return addimg;
    }

    public void setAddimg(boolean addimg) {
        this.addimg = addimg;
    }


    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }
}
