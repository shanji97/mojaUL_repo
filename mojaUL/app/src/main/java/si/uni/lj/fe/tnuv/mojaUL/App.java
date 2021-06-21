package si.uni.lj.fe.tnuv.mojaUL;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

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

    public String mailUspesnoPoslan;
    public boolean mailUspesnoPoslanStatus = false;


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
    public static void izbrisiPodatke(String tip){
        SharedPreferences sp = ctx.getSharedPreferences(tip,Context.MODE_PRIVATE);
        sp.edit().remove(tip).apply();


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


    //FILES
    private   static void kreiranjeDatotek(){

        String [] datoteke = new String[]{
                ctx.getResources().getString(R.string.datotekaZaBelezenjeAkcij),
                ctx.getResources().getString(R.string.izkljucnoBelezenjeNapak)
        };
        //kreiraj datoteke do konca
    }
    public void vpisiDatoteko(String vrsta, String vsebina){
        String datoteka="";
        vsebina = String.join("\n",vsebina);
        switch (vrsta){
            //Beleženje akcij
            default:
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
        if(vrsta.equals("NAPAKA") && jeInternetnaPovezavaVzpostavljena()){
            String[] razvijalec = {
                    res.getString(R.string.razvijalec),

            };

            //-> bi edino smiselno blo delati s HTTP requesti

            //String vsebina_datoteke = beriIzDatoteke(getResources().getString(R.string.izkljucnoBelezenjeNapak));
            //posljiDebugEmail(razvijalec,null,res.getString(R.string.NAPAKA_V_APLIKACIJI),vsebina_datoteke);

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



    //HTTP(S) requesti
    //(v študentsko prehrano ni vpisanih podatkov za menzo, da bi lahko uporabil lastno napisan parser)



    //SPLOSNO
    public  String eToString(Exception e){
        Writer w =  new StringWriter();
        e.printStackTrace(new PrintWriter(w));
        return String.join("\n",UUIDaplikacije + ": "+ w.toString());
    }


    public boolean jeInternetnaPovezavaVzpostavljena(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
