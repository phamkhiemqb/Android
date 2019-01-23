package pk.pklovestar.baitaptonghop.Model;

import android.widget.ImageView;

public class MdBanHang {
    int img;
    String title;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MdBanHang() {

    }

    public MdBanHang(int img, String title) {

        this.img = img;
        this.title = title;
    }
}
