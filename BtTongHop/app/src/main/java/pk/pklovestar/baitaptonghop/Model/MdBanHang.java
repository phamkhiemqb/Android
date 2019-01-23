package pk.pklovestar.baitaptonghop.Model;

import android.widget.ImageView;

public class MdBanHang {
    int img;
    int title;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public MdBanHang() {

    }

    public MdBanHang(int img, int title) {
        this.img = img;
        this.title = title;
    }
}
