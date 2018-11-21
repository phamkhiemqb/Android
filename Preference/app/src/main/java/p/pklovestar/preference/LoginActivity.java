package p.pklovestar.preference;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.MailTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPass;
    Button btnLogin;
    final String user1 = "admin";
    final String pass1 = "12345";
    String acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(checkLogin()){
            goHome();
        }

        edtPass = (EditText)findViewById(R.id.edt_pass);
        edtUsername = (EditText)findViewById(R.id.edt_username);
        btnLogin = (Button)findViewById(R.id.btn_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acc = edtUsername.getText().toString().trim();
                if(acc.equals(user1)
                        && edtPass.getText().toString().trim().equals(pass1)){
                    saveInfo();
                    goHome();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Sai tên hoặc sai mật khẩu",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void saveInfo(){
        SharedPreferences myPrefs = getSharedPreferences("mysample",MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putBoolean("login", true);
        editor.commit();
    }

    private void goHome(){
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        intent.putExtra("user1", acc);
        startActivity(intent);
        finish();
    }

    private boolean checkLogin(){
        SharedPreferences myPrefs = getSharedPreferences("mysample",MODE_PRIVATE);
        boolean isLogin = myPrefs.getBoolean("login",false);
        return isLogin;
    }

}
