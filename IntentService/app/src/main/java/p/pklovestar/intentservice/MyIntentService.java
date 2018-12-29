package p.pklovestar.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MyIntentService extends IntentService {
    private Bitmap mBitmap = null;
    private String mUrl;
    public HinhAnh mHinhanh;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public interface HinhAnh{
        void reTurnBitmap(Bitmap bitmap);

    }
    public void returnHinhanh(HinhAnh hinhAnh){
        this.mHinhanh = hinhAnh;
    }
    public MyIntentService() {
        super("DownloadBitmap");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        mUrl=intent.getStringExtra("url");
        Log.e("hinhanh", "onHandleIntent: "+mUrl);
        try {
            URL url = new URL(mUrl);
            InputStream inputStream = url.openConnection().getInputStream();
            mBitmap = BitmapFactory.decodeStream(inputStream);
            while(mBitmap==null){}

            if(mBitmap!=null){
                mHinhanh.reTurnBitmap(mBitmap);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
