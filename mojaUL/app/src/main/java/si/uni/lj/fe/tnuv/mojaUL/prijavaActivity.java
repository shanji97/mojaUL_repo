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
                //Toast.makeText(prijavaActivity.this,getResources().getString(R.string.))
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull  BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
            //obvesti uporabnika
                Toast.makeText(prijavaActivity.this,"Yipikayyey",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                //obvesti uporabnika
            }
        });
        pI = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("nastavi naslov")
               .setSubtitle("nastavi")
                .setNegativeButtonText("Lol")
               .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG).build();





        prstniOdtis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bP.authenticate(pI);



                //        startActivity(new Intent(v.getContext(),studisActivity.class));
            }
        });



        //če fingerprint passa, lahko gremo naprej

    }
}