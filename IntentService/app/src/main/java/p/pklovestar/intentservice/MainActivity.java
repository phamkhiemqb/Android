package p.pklovestar.intentservice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText edtUrl;
    private Button btnDownload;
    private ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        khoitao();
        final Intent intent = new Intent(MainActivity.this,MyIntentService.class);


        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mUrl = edtUrl.getText().toString();
                intent.putExtra("url",mUrl);
                startService(intent);
                MyIntentService myIntentService = new MyIntentService();
                myIntentService.returnHinhanh(new MyIntentService.HinhAnh() {
                    @Override
                    public void reTurnBitmap(Bitmap bitmap) {
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
