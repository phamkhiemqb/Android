package p.pklovestar.serviceproject.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class BoundService extends Service {
    private IBinder binder = new RandomService();
    public class RandomService extends Binder{
        public BoundService radom(){
            return BoundService.this;
        }

    }
    public BoundService(){}
    @Override
    public IBinder onBind(Intent intent) {
        return this.binder;
    }
    @Override
    public void onRebind(Intent intent) {
        Log.e("BoundService", "onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("BoundService", "onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("BoundService", "onDestroy");
    }



}
