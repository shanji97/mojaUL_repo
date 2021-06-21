package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;

public class nastavitveActivity extends AppCompatActivity {

    private  boolean paused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_nastavitve);
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