package p.pklovestar.broadcastreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {
    int i;
    Intent intent;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *

     */
    public MyIntentService() {
        super("Intent Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intent = new Intent();
        intent.putExtra("value",i);
        intent.setAction("phantram");
    }

    @Override
    protected void onHandleIntent( @Nullable Intent intent) {
        for (i=0; i<100; i++){
            Log.e("phantram", "onHandleIntent: "+i);
            if(i==5){
                sendBroadcast(intent);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }
}
