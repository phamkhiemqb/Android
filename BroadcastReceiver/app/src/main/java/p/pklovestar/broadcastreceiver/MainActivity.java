package p.pklovestar.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private NetworkChangeReceiver receiver;

    @Override
    protected void onStart() {
        super.onStart();
        receiver = new NetworkChangeReceiver();
        final IntentFilter filter = new IntentFilter("phantram");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, MyIntentService.class);
        startService(intent);

    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}
