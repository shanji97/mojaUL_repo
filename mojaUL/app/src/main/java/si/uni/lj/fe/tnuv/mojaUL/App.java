package si.uni.lj.fe.tnuv.mojaUL;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

public class App extends Application {
    private static App mInstance;
    private static Resources res;
    private  static Context ctx;


    private static boolean prviZagon = false;
    private static String filename = "";


    public String UUIDaplikacije;


    public String pisanjeDatotekeInformacija;
    public boolean pisanjeDatotekeUspesno = false;

    public String branjeDatotekeInformacija;
    public boolean branjeDatotekeUspesno = false;

    public static void nastaviPodatke(String vrednost,String tip) {

        SharedPreferences sp = ctx.getSharedPreferences(tip,Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putString(tip,vrednost);
        e.apply();

    }
    public  static String pridobiPodatke(String tip){
       SharedPreferences prefs = ctx.getSharedPreferences(tip,Context.MODE_PRIVATE);



        return prefs.getString(tip,"N/A");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        res = getResources();
        ctx = getApplicationContext();
        UUIDaplikacije = AppId();
    }



    public static App getInstance() {
        return mInstance;
    }

    public static Resources getRes() {
        return res;
    }

    public static Context app_getContext(){ return ctx;}

    private String AppId(){

        String uniqueID = null;
        final String uniqueID_app = ctx.getResources().getString(R.string.unikatnaKodaAplikacije);
        if(uniqueID==null){
            SharedPreferences sp  = ctx.getSharedPreferences(uniqueID_app,Context.MODE_PRIVATE);
            uniqueID = sp.getString(uniqueID_app,null);
            if(uniqueID == null){
                prviZagon = true;
                uniqueID = java.util.UUID.randomUUID().toString();
                SharedPreferences.Editor e  = sp.edit();
                e.putString(uniqueID_app,uniqueID);
                e.apply();

            }
        }
        if(prviZagon) {
            kreiranjeDatotek();
        }
        return uniqueID;
    }

    //Še od prejšnjič
    private   static void kreiranjeDatotek(){

        String [] datoteke = new String[]{
                ctx.getResources().getString(R.string.datotekaZaBelezenjeAkcij),
                ctx.getResources().getString(R.string.izkljucnoBelezenjeNapak)
        };
        //kreiraj datoteke do konca
    }
    public void vpisiDatoteko(String vrsta, String vsebina){
        String datoteka="";
        switch (vrsta){
            //Beleženje akcij
            case "NAPAKA": datoteka = getResources().getString(R.string.izkljucnoBelezenjeNapak); break;
            case    "BELEZENJE": datoteka = getResources().getString(R.string.datotekaZaBelezenjeAkcij); break;
        }
        try{
            FileOutputStream fos = openFileOutput(datoteka,Context.MODE_PRIVATE | Context.MODE_APPEND);
            //Točno določi format vsebine
            fos.write(vsebina.getBytes());
            fos.close();
        }catch (FileNotFoundException e) {
            Log.e("mojaUL "+ UUIDaplikacije,getRes().getString(R.string.datotekeNiMogoceNajti),e);
            pisanjeDatotekeInformacija = getRes().getString(R.string.datotekeNiMogoceNajti);
            pisanjeDatotekeUspesno = false;

        }catch (IOException e){
            Log.e("mojaUL "+ UUIDaplikacije,getRes().getString(R.string.ioNapaka),e);
            pisanjeDatotekeInformacija = getRes().getString(R.string.ioNapaka);
            pisanjeDatotekeUspesno = false;
        }
        pisanjeDatotekeInformacija = getRes().getString(R.string.pisanjeDatotekeUspesno);
        pisanjeDatotekeUspesno = true;
    }
    private String beriIzDatoteke(String datoteka){
        FileInputStream is;
        java.io.File f = new java.io.File(getFilesDir(),datoteka);
        int length = (int) f.length();
        byte[] bytes = new byte[length];

        try{
            is = openFileInput(datoteka);
            is.read(bytes);
            is.close();
        }catch (IOException e){

            Log.e("mojaUL "+ UUIDaplikacije,getRes().getString(R.string.ioNapaka),e);
            branjeDatotekeInformacija = getRes().getString(R.string.ioNapaka);
            branjeDatotekeUspesno = false;
            return null;

        }




        return new String(bytes);
    }
        /*private void vpisiVZunanjoDatoteko(String vsebina, String datoteka){
        if(isExternalStorageWritable()){
            File f = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),datoteka);
            android.util.Log.d("Vpis", f.getAbsolutePath());
            try{
                OutputStream os = new FileOutputStream(f);
                os.write(vsebina.getBytes());
                os.close();
            }catch (IOException e){
                android.util.Log.w("ExternalStorage", "Napaka pri pisanju datoteke"+f,e);
                vpisiDatoteko(getString(R.string.napaka),getString(R.string.napakaPriPisanjuVZunanjoDatoteko));
              }
            }
        }*/

    public boolean jeInternetnaPovezavaVzpostavljena(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
