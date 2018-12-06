package p.pklovestar.serviceproject.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class Dem extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.e("Service","Create ok ");


        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int[] n = new int[] {1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < 9; i++){
            Log.e("Service",""+i);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("Service","Stop finish");
        super.onDestroy();
    }
}
