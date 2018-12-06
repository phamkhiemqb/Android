package p.pklovestar.asunctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbDownloadr;
    private EditText edtUrl;
    private Button btnDownload;
    private ImageView imgHinh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        khoitao();
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadImage downloadImage= new DownloadImage();
                downloadImage.execute(edtUrl.getText().toString());
                downloadImage.reTurnBitmap(new DownloadImage.KqBitmap() {
                    @Override
                    public void hinhBitmap(Bitmap bitmap) {

                        if(bitmap!=null){
                            imgHinh.setImageBitmap(bitmap);
                        }
                    }
                });


            }
        });




    }

    public void khoitao(){
        edtUrl = findViewById(R.id.txt_url);
        btnDownload = findViewById(R.id.btn_download);
        imgHinh = findViewById(R.id.img_hinh);

    }
}

