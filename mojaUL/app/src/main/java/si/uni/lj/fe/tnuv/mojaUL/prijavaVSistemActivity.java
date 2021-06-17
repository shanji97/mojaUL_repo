package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

public class prijavaVSistemActivity extends AppCompatActivity {
    private Button prijavaVSistem;
    private String geslo="";
    private  String email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava_v_sistem);
        prijavaVSistem = (Button)findViewById(R.id.prijavaVsistem);

        prijavaVSistem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Dobimo text iz obeh textViewov
               // TextView ui = (TextView)
                //Preverimo, če e-mail ustreza REGEXU za študentski mail
                    //če ne uporabnika obestimo preko toasta

                //sicer gremo preveriti geslo

                //preverimo če je internetna povezava
                if(!App.getInstance().jeInternetnaPovezavaVzpostavljena()){
                    Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.niInternetnePoveezave),Toast.LENGTH_LONG);
                    return;
                }
                //preverimo, če je uporabnik v sistemu (zaenkrat statično, brez strežnikov
                if(email.equals("ak3900@student.uni-lj.si") && geslo.equals("NekonakljucnoGeslo1234#$###")){
                    // vse je vredu, naloži json iz neta
                    Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.prijavaVsistemUspesna),Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.kombinacijaNeObstaja),Toast.LENGTH_LONG);
                }
            }
        });
    }
}
/* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vstop = (Button) findViewById(R.id.gumbZaVstopVAplikacijo);


        vstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.dobrodosli), Toast.LENGTH_LONG);
                //Intent myIntent = new Intent(view.getContext(),zaposleniActivity.class);

                startActivity(new Intent(v.getContext(),prijavaVSistemActivity.class));
            }
        });*/