package si.uni.lj.fe.tnuv.mojaUL;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jsoup.helper.HttpConnection;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class SeznamZaposlenihAdapter extends ArrayAdapter<Zaposlen> {

    private Context mContext;
    private int resource;
    private ImageView image;
    ProgressDialog pD;

    public SeznamZaposlenihAdapter(Context c, int vir, ArrayList<Zaposlen> zaposleni){
        super(c,vir,zaposleni);
        mContext = c;
        resource = vir;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String naziv  = getItem(position).getNaziv();
        String imeInPriimek = getItem(position).getIme()+" "+getItem(position).getPriimek();



        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(resource,parent,false);


        TextView tvImeZaposlenega = (TextView) convertView.findViewById(R.id.ime_zaposlenega);
        TextView tvNazivZaposlenega = (TextView) convertView.findViewById(R.id.naziv_zaposlenega);

        ImageView iV = (ImageView) convertView.findViewById(R.id.zaposleniFotka);

        new ImageDownloader(iV).execute(getItem(position).getPovezavaDoProfilneFotografije());


        tvImeZaposlenega.setText(imeInPriimek);
        tvNazivZaposlenega.setText(naziv);

        return convertView;
    }



}
class ImageDownloader extends  AsyncTask<String,Void,Bitmap>{
    private final WeakReference<ImageView> iVR;
    public  ImageDownloader(ImageView iV){
        iVR  = new WeakReference<ImageView>(iV);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        return downloadBitmap(strings[0]);

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if(isCancelled()){
            bitmap = null;
        }
        if(iVR != null){
            ImageView iV = iVR.get();
            if(iV != null){
                if(bitmap!= null){
                    iV.setImageBitmap(bitmap);
                }else
                {
                    Drawable placeholder =null;
                    placeholder = App.getRes().getDrawable(R.drawable.ic_baseline_account_circle_24);
                            iV.setImageDrawable(placeholder);
                }
            }
        }
    }

    private Bitmap downloadBitmap(String url) {
        HttpURLConnection urlConnection = null;
        try {
            URL uri = new URL(url);
            urlConnection = (HttpURLConnection) uri.openConnection();

            final int responseCode = urlConnection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                return null;
            }

            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream != null) {
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (Exception e) {
            urlConnection.disconnect();

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }
}

