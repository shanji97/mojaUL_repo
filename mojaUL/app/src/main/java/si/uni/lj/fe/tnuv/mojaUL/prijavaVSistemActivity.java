package si.uni.lj.fe.tnuv.mojaUL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.gson.Gson;

import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

public class prijavaVSistemActivity extends AppCompatActivity {

    private Button prijavaVSistem;
    private TextView pomocPriPrijavi_tv;
    private String geslo="";
    private  String email="";

    private  boolean paused = false;

    //LifeCycle Events
    @Override
    protected void onPause() {
        super.onPause();
        paused = true;

    }
    @Override
    protected void onResume() {
        super.onResume();
        if(paused){


            Intent i = new Intent(this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava_v_sistem);

        prijavaVSistem = (Button)findViewById(R.id.prijavaVsistem);
        pomocPriPrijavi_tv = (TextView)findViewById(R.id.pomocPriPrijavi);

        pomocPriPrijavi_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!App.getInstance().jeInternetnaPovezavaVzpostavljena()){
                    Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.niInternetnePoveezave),Toast.LENGTH_LONG).show();
                    return;
                }

                Intent i = new Intent(v.getContext(),WebviewActivity.class);
                i.putExtra(getResources().getString(R.string.linkZaPomoc),getResources().getString(R.string.link_pomoc));
                startActivity(i);
            }
        });
        prijavaVSistem.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.prijavljam),Toast.LENGTH_SHORT).show();
                        EditText ui = (EditText) findViewById(R.id.emailStudenta);

                        email = ui.getText().toString();


                        if(!email.matches("[a-z]{2}[0-9]{4}@student.uni-lj.si") || email.equals("")){
                            Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.mailNiPravegaFormata),Toast.LENGTH_LONG).show();
                            return;
                        }

                        EditText g = (EditText)findViewById(R.id.gesloStudenta);

                        geslo  = g.getText().toString();

                        if(geslo.equals("")){
                            Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.niVneseanegaGesla),Toast.LENGTH_LONG).show();
                            return;
                        }

                        if(!App.getInstance().jeInternetnaPovezavaVzpostavljena()){
                            Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.niInternetnePoveezave),Toast.LENGTH_LONG).show();
                            return;
                        }
                        //preverimo, če je uporabnik v sistemu (zaenkrat statično, brez strežnikov
                        if(email.equals("ak3900@student.uni-lj.si") && geslo.equals("enDvaTri")){

                            Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.nalaganjeNastavitev),Toast.LENGTH_SHORT).show();

                            //Naložimo statičen JSON, v realni aplikaciji bi to potegnili dol s kakega strežnika

                            //zgeneriram kar sebe z ze potrebe, drugače dodamo še en konstruktor
                            Student s = new Student();

                           String student_string_res = new Gson().toJson(s);

                           App.nastaviPodatke(student_string_res,"student");

                            Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.prijavaVsistemUspesna),Toast.LENGTH_SHORT).show();
                            Log.d("JSON","Okej, zgeneriraj in naloži podatke");
                             //preusmeri uporabnika na glavni panel
                            startActivity(new Intent(v.getContext(),glavniPanelActivity.class));

                        }
                        else{
                            Toast.makeText(prijavaVSistemActivity.this,getResources().getString(R.string.kombinacijaNeObstaja),Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                }

        );




    }
}
