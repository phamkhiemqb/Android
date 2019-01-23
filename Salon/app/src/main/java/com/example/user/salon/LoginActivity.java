package com.example.user.salon;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.user.salon.MainActivity.BASE_URL;

public class LoginActivity extends Activity {
    Button btnregisterr, btnlogin;
    EditText edtusename,edtpass;
    Retrofit retrofit;
    LoginButton loginButton;
    CallbackManager mcallback;
    private TextView mTvInfo;

    OnApiInterface myRetrofitAPI;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        btnregisterr = (Button)findViewById(R.id.register);
        edtusename = (EditText)findViewById(R.id.username);
        edtpass = (EditText)findViewById(R.id.password);
        btnlogin = (Button)findViewById(R.id.login);
        mTvInfo = (TextView) findViewById(R.id.tv_info);
        mcallback = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        AppEventsLogger.activateApp(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        login();

        if(checkLogin()== ""){
            goHome();
        }
        btnregisterr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

        myRetrofitAPI = retrofit.create(OnApiInterface.class);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usn = edtusename.getText().toString();
                String passs = edtpass.getText().toString();
                myRetrofitAPI.active(new Login(usn, passs)).enqueue(new Callback<Token>() {


                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if (response.isSuccessful()){
                            String token = response.body().getToken();

                            Log.d("aaaaaaaaaa  " , " token " + token);
//                            saveInfo(token);
                            goHome();
                        }
                    }
                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                    }
                });
            }
        });
    }
    private void login() {
        mcallback = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mcallback, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
               goHome();
               finish();
            }
            @Override
            public void onCancel() {
            }
            @Override
            public void onError(FacebookException error) {
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mcallback.onActivityResult(requestCode, resultCode, data);
    }
    private void saveInfo(String tokene){

        SharedPreferences myPrefs = getSharedPreferences("mysample",MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString("login", tokene);
        editor.commit();
    }
    private void goHome(){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    private String checkLogin(){
        SharedPreferences myPrefs = getSharedPreferences("mysample",MODE_PRIVATE);

        String isLogin = myPrefs.getString("login", null );
        return isLogin;
    }

}
