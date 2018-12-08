package p.pklovestar.intentservice;

import android.content.Intent;
import android.support.annotation.Nullable;

public class IntentService extends android.app.IntentService {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */


    public IntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent( @Nullable Intent intent) {

    }
}
