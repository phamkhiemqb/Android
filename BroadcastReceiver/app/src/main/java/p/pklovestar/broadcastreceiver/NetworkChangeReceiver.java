package p.pklovestar.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int i = intent.getIntExtra("value",1);
        //Toast.makeText(context, "10 phan tram "+i, Toast.LENGTH_SHORT).show();
        Log.e("phantram", "onHandleIntent: "+i+" phan tram");
    }
}
