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

        //če bo čas, pridobi iz neta

        //sicer napolni statično

        seznamVsehZaposlenih.add( new Zaposlen("Janez", "Bešter", "prof. dr.",
                "BN511-KAB","014768431", "https://www.fe.uni-lj.si/mma_bin.php?id=2017061411062592&src=min","Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Jaka", "Sodnik", "prof. dr.",
                "BN509-KAB","014768494", "https://www.fe.uni-lj.si/mma_bin.php?id=2014073116103501&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Grega", "Jakus", "izr. prof. dr.",
                "BN514/1-LKN","014768938", "https://www.fe.uni-lj.si/mma_bin.php?id=2014073115544462&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Anton", "Kos", "izr. prof. dr.",
                "BN514/1-LKN","014768493", "https://www.fe.uni-lj.si/mma_bin.php?id=2016032210172019&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));
        //PODVOJIMO kar te vnose
        seznamVsehZaposlenih.add( new Zaposlen("Janez-2", "Bešter-2", "prof. dr.",
                "BN511-KAB","014768431", "https://www.fe.uni-lj.si/mma_bin.php?id=2017061411062592&src=min","Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Jaka-2", "Sodnik-2", "prof. dr.",
                "BN509-KAB","014768494", "https://www.fe.uni-lj.si/mma_bin.php?id=2014073116103501&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Grega-2", "Jakus-2", "izr. prof. dr.",
                "BN514/1-LKN","014768938", "https://www.fe.uni-lj.si/mma_bin.php?id=2014073115544462&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Anton-2", "Kos-2", "izr. prof. dr.",
                "BN514/1-LKN","01768493", "https://www.fe.uni-lj.si/mma_bin.php?id=2016032210172019&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Janez-3", "Bešter-3", "prof. dr.",
                "BN511-KAB","014768431", "https://www.fe.uni-lj.si/mma_bin.php?id=2017061411062592&src=min","Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Jaka-3", "Sodnik-3", "prof. dr.",
                "BN509-KAB","014768494", "https://www.fe.uni-lj.si/mma_bin.php?id=2014073116103501&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Grega-3", "Jakus-3", "izr. prof. dr.",
                "BN514/1-LKN","014768938", "https://www.fe.uni-lj.si/mma_bin.php?id=2014073115544462&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Anton-3", "Kos-3", "izr. prof. dr.",
                "BN514/1-LKN","014768493", "https://www.fe.uni-lj.si/mma_bin.php?id=2016032210172019&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));


        seznamVsehZaposlenih.add(new Zaposlen("","","","","","", ""));

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