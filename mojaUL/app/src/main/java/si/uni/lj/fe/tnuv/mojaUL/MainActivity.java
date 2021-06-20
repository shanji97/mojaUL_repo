package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private Button vstop ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student s = null;
        String student="";

         // preveri, če je študent shranjen v sharedPreferences
    try{
        student = App.pridobiPodatke("student");
        s = new Gson().fromJson(student,Student.class);
        }catch(Exception e){
            e.printStackTrace();

        }
        if(student != null && !student.equals("") && s!=null){

            String napis = getResources().getString(R.string.zivjo) + s.ime + "!";

            Toast.makeText(MainActivity.this, napis, Toast.LENGTH_SHORT).show();

            startActivity(new Intent(App.app_getContext(),glavniPanelActivity.class));

        }
        vstop = (Button) findViewById(R.id.gumbZaVstopVAplikacijo);
        vstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.dobrodosli), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(v.getContext(),prijavaVSistemActivity.class));
            }
        });
    }

}