package com.example.user.salon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.user.salon.MainActivity.BASE_URL;

public class RegisterActivity extends Activity {
    Button btnregister;
    EditText edtfirst,edtlast,edtemail,edtphone,edtpass,edtgender;
    Retrofit retrofit;

    OnApiInterface myRetrofitAPI;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        anhxa();
        Registerr();
        retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

        myRetrofitAPI = retrofit.create(OnApiInterface.class);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first =edtfirst.getText().toString();
                String last =edtlast.getText().toString();
                String email =edtemail.getText().toString();
                String phone =edtphone.getText().toString();
                String pass =edtpass.getText().toString();
                String gender =edtgender.getText().toString();
                myRetrofitAPI.postNewSong(new Register(first,last,email,pass,phone,gender)).enqueue(new Callback<Object>() {

                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        if (response.isSuccessful()){
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {

                    }
                });
            }
        });
    }



    private void Registerr() {
        String email =edtemail.getText().toString();
        String phone =edtphone.getText().toString();
        String pass =edtpass.getText().toString();
    }

    private void anhxa() {
        btnregister = (Button)findViewById(R.id.btnregister);
        edtfirst = (EditText)findViewById(R.id.firstname);
        edtlast = (EditText)findViewById(R.id.lastname);
        edtemail = (EditText)findViewById(R.id.registeremail);
        edtpass = (EditText)findViewById(R.id.registerpass);
        edtphone = (EditText)findViewById(R.id.numberphone);
        edtgender = (EditText)findViewById(R.id.gender);
    }
}
