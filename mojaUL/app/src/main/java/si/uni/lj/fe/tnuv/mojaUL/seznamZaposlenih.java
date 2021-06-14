package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class seznamZaposlenih extends AppCompatActivity {
    public  ArrayList<Zaposlen>  seznamVsehZaposlenih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seznam_zaposlenih);
        ListView lV = (ListView)findViewById(R.id.seznamZaposlenih);
        ArrayList<Zaposlen> seznamVsehZaposlenih = new ArrayList<Zaposlen>();
        //dobimov vse objekte in jih "napolnimo"
        //pridobiOstaleIzNeta
        //


        seznamVsehZaposlenih.add(new Zaposlen("","","","","",""));

        SeznamZaposlenihAdapter seznamZaposlenihAdapter = new SeznamZaposlenihAdapter(this,R.layout.razporeditev_informacij_zaposlenega,seznamVsehZaposlenih);
        lV.setAdapter(seznamZaposlenihAdapter);

        //na klik
        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 
                    Intent myIntent = new Intent(view.getContext(),zaposleniActivity.class);
                    myIntent.putExtra("Zaposlen",new Gson().toJson(seznamVsehZaposlenih.get(position)));
                    startActivity(myIntent);


            }
        });

    }
}