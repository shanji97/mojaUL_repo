package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class nastavitveActivity extends AppCompatActivity {

    private  boolean paused;
    private Button lightVsDark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nastavitve);
        lightVsDark = (Button)findViewById(R.id.darkMode_lightMode);
        lightVsDark.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivityForResult(new Intent(Settings.ACTION_DISPLAY_SETTINGS), 0);
                    }
                }
        );
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