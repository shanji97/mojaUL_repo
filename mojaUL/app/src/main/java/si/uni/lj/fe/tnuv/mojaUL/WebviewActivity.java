package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class WebviewActivity extends AppCompatActivity {

    private WebView wW;
    public boolean paused;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Toast.makeText(this,getResources().getString(R.string.nalagamStran),Toast.LENGTH_SHORT).show();
        wW = (WebView) findViewById(R.id.webView_mojaUL);
        Intent intent = getIntent();

        wW.getSettings().setJavaScriptEnabled(true);
        wW.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        wW.getSettings().setBuiltInZoomControls(true);
        //wW.setInitialScale(50);
        //probaj rešiti bug, kjer  samo github nalaga.
        if(!App.getInstance().jeInternetnaPovezavaVzpostavljena()){
            Toast.makeText(this,getResources().getString(R.string.niInternetnePoveezave),Toast.LENGTH_LONG).show();
            return;
        }
        wW.loadUrl(intent.getStringExtra(getResources().getString(R.string.netLink)));

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


            Intent i = new Intent(this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }

    }
}