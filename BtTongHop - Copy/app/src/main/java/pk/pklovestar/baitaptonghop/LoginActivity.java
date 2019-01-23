package pk.pklovestar.baitaptonghop;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import pk.pklovestar.baitaptonghop.API.ApiUtils;
import pk.pklovestar.baitaptonghop.API.OnAPICilent;
import pk.pklovestar.baitaptonghop.Model.UserKhachHangInput;
import pk.pklovestar.baitaptonghop.Model.UserKhachHangOutput;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText edUser, edPass;
    CheckBox checkSavelogin;
    ImageView showPass;
    Button btnLogin;
    private OnAPICilent onAPICilent;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        anhxa();
        if(isOnline() == false){
            Toast.makeText(LoginActivity.this, "Vui lòng kiểm tra kêt nối internet và thử lai", Toast.LENGTH_SHORT).show();
        }
        else {
            onAPICilent = ApiUtils.getAPIService();
            intent = new Intent(LoginActivity.this, BanHangActivity.class);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("check", String.valueOf(""+edPass.getText().toString().trim()==""));
                    if(""+edUser.getText().toString().trim()=="") Toast.makeText(LoginActivity.this, "Tên đăng nhập trống", Toast.LENGTH_SHORT).show();
                    else if(""+edPass.getText().toString().trim()=="") Toast.makeText(LoginActivity.this, "Mật khẫu trống", Toast.LENGTH_SHORT).show();
                    else getTokenLogin();
                }
            });

        }

    }


    private void anhxa() {
        edUser = findViewById(R.id.edt_user);
        edPass = findViewById(R.id.edt_pass);
        checkSavelogin = findViewById(R.id.check_savelogin);
        btnLogin = findViewById(R.id.btn_login);

    }

    private void saveToken(String token){

        SharedPreferences myPrefs = getSharedPreferences("mysample",MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString("token", token);
        editor.commit();
    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }



    private void getTokenLogin() {
        UserKhachHangInput userlogin = new UserKhachHangInput(edUser.getText().toString().trim(),
                edPass.getText().toString().trim(), 1, "4.0");
        onAPICilent.getToken(userlogin).enqueue(new Callback<UserKhachHangOutput>() {
            @Override
            public void onResponse(Call<UserKhachHangOutput> call, Response<UserKhachHangOutput> response) {
                Log.d("check", " " + response.body().getToken());

                if(response.isSuccessful()) {
                    if (response.body().getResultCode() == 1) {

                        if (checkSavelogin.isChecked()) {
                            saveToken(response.body().getToken());
                        }

                        intent.putExtra("token", response.body().getToken());
                        startActivity(intent);
                        finish();


                    }
                    Toast.makeText(LoginActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<UserKhachHangOutput> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
