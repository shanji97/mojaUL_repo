package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class glavniPanelActivity extends AppCompatActivity {

    private Button gumbVStudis;
    private Button zaposleniGumb;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavni_panel);

        gumbVStudis = (Button)findViewById(R.id.studisGumb);
       gumbVStudis.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //prijava v STUDIS
                        i = new Intent(v.getContext(),prijavaActivity.class);
                        startActivity(i);
                    }
                }

        );
        zaposleniGumb = (Button)findViewById(R.id.zaposleniGumb);
        zaposleniGumb.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //prijava v STUDIS
                        i = new Intent(v.getContext(),seznamZaposlenih.class);
                        startActivity(i);
                    }
                }

        );
    }
}