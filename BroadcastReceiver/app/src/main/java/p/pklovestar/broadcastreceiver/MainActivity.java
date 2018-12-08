package p.pklovestar.broadcastreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private NetworkChangeReceiver receiver;

    @Override
    protected void onStart() {
        super.onStart();
        receiver = new NetworkChangeReceiver();
        final IntentFilter filter = new IntentFilter("10 phan tram");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}
