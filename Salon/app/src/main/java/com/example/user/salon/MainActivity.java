package com.example.user.salon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.gson.Gson;

import java.security.MessageDigest;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Myadapter.Ondata {
    Myadapter adapter;
    RecyclerView recyclerView;
    static String BASE_URL = "http://45.77.27.89:8088/api/";
    Retrofit retrofit;
    OnApiInterface myRetrofitAPI;
    ArrayList<Datum> data = new ArrayList<>();
    Button btnout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnout = (Button)findViewById(R.id.out);
        recyclerView = (RecyclerView)findViewById(R.id.rccl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Myadapter(this,data , this);
        recyclerView.setAdapter(adapter);
        retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();
        myRetrofitAPI = retrofit.create(OnApiInterface.class);

        myRetrofitAPI.getlistsalon().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.isSuccessful()) {
                    Example list = response.body();
                    data.addAll(list.getData());
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this, "error",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "failed",Toast.LENGTH_SHORT).show();
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                SharedPreferences myPrefs = getSharedPreferences("mysample",MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.remove("login");
                editor.commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void dtb(Datum s) {
        Datum dt = s;
        Intent intent = new Intent(MainActivity.this, Info.class);
        Gson gson = new Gson();
        String d = gson.toJson(dt);
        intent.putExtra("abc",d);
        startActivity(intent);
    }

    public void key(){
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo("com.example.user.salon", PackageManager.GET_SIGNATURES);
            for(Signature signature: packageInfo.signatures){
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(messageDigest.digest(),Base64.DEFAULT));
            }
        }catch (Exception e){
        }
    }



}
