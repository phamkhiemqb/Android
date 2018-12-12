package p.pklovestar.picassolibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView hinhanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hinhanh = findViewById(R.id.im_hinhanh);
        String url = "http://file.vforum.vn/hinh/2018/03/hinh-nen-dien-thoai-dep-nhat-full-hd-cho-dien-thoai-iphone-android-3.jpg";
        Picasso.get()
                .load(url)
                .resize(500,1000)
                .centerCrop()
                .into(hinhanh);

    }
}
