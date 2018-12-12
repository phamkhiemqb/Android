package com.example.admin.mylib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView img;

    final String BASE_URL = "http://45.77.27.89:8088/api/";

    Retrofit retrofit;

    OnApiInterface myRetrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.imgv);

        String url = "http://i.imgur.com/DvpvklR.png";

       Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).load(url)

                .into(img);



         retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

         myRetrofitAPI = retrofit.create(OnApiInterface.class);

        myRetrofitAPI.getListSongs().enqueue(new Callback<SongList>() {
            @Override
            public void onResponse(Call<SongList> call, Response<SongList> response) {
                if(response.isSuccessful()) {
                    SongList list = response.body();
                    for(int i=0;i<list.getData().size();i++){
                        Log.d("Song", list.getData().get(i).getSong());
                    }

                }else{
                    Toast.makeText(MainActivity.this, "error",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SongList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void addSong(View v){
        myRetrofitAPI.postNewSong(new AddSong("dddd","dddd","dddd","dddd")).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"error"+response.message(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
