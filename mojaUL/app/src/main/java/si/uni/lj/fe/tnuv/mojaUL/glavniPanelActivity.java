package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class glavniPanelActivity extends AppCompatActivity {

    private ImageView FE_STRAN; //@+id/FE_STRAN
    private ImageView STUDIS; //STUDIS
    private ImageView ZAPOSLENI; //@+id/ZAPOSLENI

    private ImageView FE; //@+id/FE_STRAN
    private Button zaposleniGumb;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavni_panel);

        STUDIS = (ImageView) findViewById(R.id.STUDIS);
       STUDIS.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //prijava v STUDIS
                        i = new Intent(v.getContext(),prijavaActivity.class);
                        startActivity(i);
                    }
                }
        );
       ZAPOSLENI = (ImageView)findViewById(R.id.ZAPOSLENI);
        /*zaposleniGumb = (Button)findViewById(R.id.zaposleniGumb);*/
       ZAPOSLENI.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        i = new Intent(v.getContext(),seznamZaposlenih.class);
                        startActivity(i);
                    }
                }
        );
       FE = (ImageView) findViewById(R.id.FE_STRAN);
        FE.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        i = new Intent(v.getContext(),WebviewActivity.class);
                        i.putExtra(getResources().getString(R.string.linkFaksa),getResources().getString(R.string.linkFaksa));
                        startActivity(i);
                    }
                }
        );
    }
}