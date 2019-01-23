package pk.pklovestar.baitaptonghop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                SharedPreferences myPrefs = getSharedPreferences("mysample",MODE_PRIVATE);
                token = myPrefs.getString("token",null);
                if(token != null){

                    Intent intent1 = new Intent(FirstActivity.this,BanHangActivity.class);
                    intent1.putExtra("token",token);
                    startActivity(intent1);
                    finish();
                }
                else {

                    Intent intent2 = new Intent(FirstActivity.this, LoginActivity.class);
                    startActivity(intent2);
                    finish();

                }
                //do something
            }
        }, 3000);


    }
}
