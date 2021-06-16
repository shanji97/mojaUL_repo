package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class zaposleniActivity extends AppCompatActivity {
    private Zaposlen z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaposleni);

        //Pridobimo iz intenta
        Intent i = getIntent();
        String zaposlenJson = i.getStringExtra("Zaposlen");
        z = new Gson().fromJson(zaposlenJson,Zaposlen.class);

        //Nastavimo podatke

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





    }
}