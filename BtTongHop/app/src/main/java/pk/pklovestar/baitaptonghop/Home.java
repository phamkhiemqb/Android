package pk.pklovestar.baitaptonghop;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import pk.pklovestar.baitaptonghop.Fragment.CanhanFragment;


public class Home extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "vi"));
    }
}