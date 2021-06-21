package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class zaposleniActivity extends AppCompatActivity {
    private Zaposlen z;
    private boolean paused = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaposleni);


        //Pridobimo iz intenta
        Intent i = getIntent();
        String zaposlenJson = i.getStringExtra("Zaposlen");
        z = new Gson().fromJson(zaposlenJson,Zaposlen.class);


        //Nastavimo podatke
        Toast.makeText(this,getResources().getString(R.string.nalagamZaposlenega),Toast.LENGTH_SHORT).show();
        TextView tV = (TextView) findViewById(R.id.zaposlen_naslov);
            tV.setText(z.getPolniNazivZaposlenega());
        tV = (TextView) findViewById(R.id.email_zaposlenega);
            tV.setText(z.getEmail());
        tV = (TextView) findViewById(R.id.telefonska_stevilka);
            tV.setText(z.getTelefonskaStevilka());
        tV = (TextView) findViewById(R.id.st_sobe);
                tV.setText(z.getProstor());
        tV = (TextView) findViewById(R.id.druge_informacije);
            tV.setText(z.getOpis());
        if(!App.getInstance().jeInternetnaPovezavaVzpostavljena()){
            Toast.makeText(this,getResources().getString(R.string.niInternetnePoveezave),Toast.LENGTH_LONG).show();
            return;
        }
        ImageView iV = (ImageView) findViewById(R.id.profilnaFotkaProfesorja);

        new ImageDownloader(iV).execute(z.getPovezavaDoProfilneFotografije());




    }
    @Override
    protected void onPause() {
        super.onPause();
        paused = true;

    }
    @Override
    protected void onResume() {
        super.onResume();
        if(paused){
            Intent i = new Intent(this,glavniPanelActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }

    }
}