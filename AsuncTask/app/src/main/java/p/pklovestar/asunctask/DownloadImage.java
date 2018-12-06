package p.pklovestar.asunctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImage extends AsyncTask<String,Void,Bitmap> {
    Bitmap mBitmap;
    public KqBitmap mKqBitmap;

    public interface KqBitmap{
        void hinhBitmap(Bitmap bitmap);
    }
    public void reTurnBitmap(KqBitmap kqBitmap){
        this.mKqBitmap = kqBitmap;

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            InputStream inputStream = url.openConnection().getInputStream();
            mBitmap = BitmapFactory.decodeStream(inputStream);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mBitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mKqBitmap.hinhBitmap(bitmap);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }



}
