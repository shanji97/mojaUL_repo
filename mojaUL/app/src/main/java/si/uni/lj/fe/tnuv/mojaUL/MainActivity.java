package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button vstop ;

    @Override
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
        });
    }

}