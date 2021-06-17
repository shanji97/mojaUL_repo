package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class WebviewActivity extends AppCompatActivity {

    private WebView wW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        wW = (WebView) findViewById(R.id.webView_mojaUL);
        Intent intent = getIntent();


        if(!App.getInstance().jeInternetnaPovezavaVzpostavljena()){
            Toast.makeText(this,getResources().getString(R.string.niInternetnePoveezave),Toast.LENGTH_LONG).show();
            return;
        }
        wW.loadUrl(intent.getStringExtra(getResources().getString(R.string.linkZaPomoc)));

    }
}