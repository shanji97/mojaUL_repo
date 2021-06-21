package si.uni.lj.fe.tnuv.mojaUL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.BiometricManager;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class prijavaActivity extends AppCompatActivity {

    private Button prstniOdtis;

    private Executor ex;
    private BiometricPrompt bP;
    private BiometricPrompt.PromptInfo pI;

    private boolean paused=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava);

        prstniOdtis = (Button) findViewById(R.id.prstniOdtisGumb);

        ex = ContextCompat.getMainExecutor(prijavaActivity.this);
        bP = new BiometricPrompt(prijavaActivity.this, ex, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(prijavaActivity.this,App.getRes().getString(R.string.avtentikacijaNapaka),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull  BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
            //obvesti uporabnika
                Toast.makeText(prijavaActivity.this,App.getRes().getString(R.string.avtentikacijaUspesna),Toast.LENGTH_LONG).show();          //zaštartaj novo okno
                startActivity(new Intent(App.app_getContext(),studisActivity.class));
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(prijavaActivity.this,App.getRes().getString(R.string.avtetikacijaNiUspela),Toast.LENGTH_LONG).show();
            }
        });
        pI = new BiometricPrompt.PromptInfo.Builder()
                .setTitle(App.getRes().getString(R.string.prijavaStudisMojaUL))
               .setSubtitle(App.getRes().getString(R.string.prijaviteSeSPristnimOdtisom))
                .setNegativeButtonText(getResources().getString(R.string.tezavePriDelovanju))
               .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG).build();

        prstniOdtis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bP.authenticate(pI);
            }
        });

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



