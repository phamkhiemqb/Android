package pk.pklovestar.baitaptonghop;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements NetworkStateReceiver.NetworkStateReceiverListener {
    String token;
    private NetworkStateReceiver networkStateReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener(this);
        this.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public void onDestroy() {
        super.onDestroy();
        networkStateReceiver.removeListener(this);
        this.unregisterReceiver(networkStateReceiver);
    }

    @Override
    public void networkAvailable() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                SharedPreferences myPrefs = getSharedPreferences("mysample", MODE_PRIVATE);
                token = myPrefs.getString("token", null);
                if (token != null) {

                    Intent intent1 = new Intent(FirstActivity.this, BanHangActivity.class);
                    intent1.putExtra("token", token);
                    startActivity(intent1);
                    finish();
                } else {

                    Intent intent2 = new Intent(FirstActivity.this, LoginActivity.class);
                    startActivity(intent2);
                    finish();

                }

            }
        }, 3000);

    }

    @Override
    public void networkUnavailable() {
        Toast.makeText(FirstActivity.this, "Vui lòng kiểm tra kêt nối internet và thử lai", Toast.LENGTH_LONG).show();

    }
}
