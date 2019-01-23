package p.pklovestar.bitp_salong;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import p.pklovestar.bitp_salong.Adapter.Adapter2;
import p.pklovestar.bitp_salong.Adapter.MyAdapter;
import p.pklovestar.bitp_salong.Salon.ListSalon;
import p.pklovestar.bitp_salong.Salon.Relationships;
import p.pklovestar.bitp_salong.Salon.Service;
import p.pklovestar.bitp_salong.Salon.TTSalon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private APIRequest mAPIRequest;
    private Adapter2 myAdapter;
    List<Service> mylist2;
    RecyclerView mRecyclerView;
    ImageView hinhanh;
    TextView tieude, sodienthoai,diachi,thoigianmocua, chitiet;
    Button btnBook2, viewmore;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Intent intent = getIntent();
        Gson gson = new Gson();
        TTSalon data = gson.fromJson(intent.getStringExtra("data"),TTSalon.class);
        anhxa();

        Picasso.get()
                .load(data.getImageSalon().get(new Random().nextInt(data.getImageSalon().size()) ))
                .resize(1080,607)
                .centerCrop()
                .into(hinhanh);
        tieude.setText(data.getNameSalon());
        sodienthoai.setText(data.getPhone());
        diachi.setText(data.getAddress());
        thoigianmocua.setText(data.getOpeningHours());
        chitiet.setText(data.getDescription());
        mylist2= new ArrayList<Service>();
        mylist2.addAll(data.getRelationships().getServices());
        myAdapter = new Adapter2(DetailActivity.this,mylist2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(myAdapter);
        viewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chitiet.setMaxLines(30);
                viewmore.setText(null);

            }
        });


    }

    private void anhxa() {
        mAPIRequest = ApiUtils.getAPIService();
        mRecyclerView = findViewById(R.id.rcview2);
        hinhanh =findViewById(R.id.im_photo);
        btnBook2 =findViewById(R.id.btn_book2);
        viewmore =findViewById(R.id.btn_viewmore);
        tieude =findViewById(R.id.txt_title);
        sodienthoai =findViewById(R.id.txt_phone);
        diachi =findViewById(R.id.txt_adress);
        thoigianmocua =findViewById(R.id.txt_opentime);
        chitiet =findViewById(R.id.txt_about_salon);
        viewmore.setAlpha((float) 0.9);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

}
