package si.uni.lj.fe.tnuv.mojaUL;

import androidx.appcompat.app.AppCompatActivity;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class seznamZaposlenih extends AppCompatActivity {

    private  boolean paused =false;
    private boolean listViewItemClicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //ok
        setContentView(R.layout.activity_seznam_zaposlenih); //ok

        ListView lV = (ListView)findViewById(R.id.seznamZaposlenih);//ok
        ArrayList<Zaposlen> seznamVsehZaposlenih = new ArrayList<Zaposlen>(); //ok

        //TU JE POTREBNO IMETI POVEZAVO, KI SE KONČA S fotka.jpg
        //ostalo gre na "fallback"

        seznamVsehZaposlenih.add( new Zaposlen("Janez", "Bešter", "prof. dr.",
                "BN511-KAB","+38614768431", "https://i.imgur.com/p454aZz.jpg","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. "));

        seznamVsehZaposlenih.add( new Zaposlen("Jaka", "Sodnik", "prof. dr.",
                "BN509-KAB","014768494", "https://i.imgur.com/nFLAPZ7.jpg","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Grega", "Jakus", "izr. prof. dr.",
                "BN514/1-LKN","+38614768938", "https://i.imgur.com/QjJx0LC.jpg","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Anton", "Kos", "izr. prof. dr.",
                "BN514/1-LKN","+38614768493", "https://i.imgur.com/hHtyhQE.jpg","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));
        //PODVOJIMO kar te vnose
        seznamVsehZaposlenih.add( new Zaposlen("Janez-2", "Bešter-2", "prof. dr.",
                "BN511-KAB","+38614768431", "https://www.fe.uni-lj.si/mma_bin.php?id=2+38617061411062592&src=min","Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Jaka-2", "Sodnik-2", "prof. dr.",
                "BN509-KAB","+38614768494", "https://www.fe.uni-lj.si/mma_bin.php?id=2+386140731161035+3861&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Grega-2", "Jakus-2", "izr. prof. dr.",
                "BN514/1-LKN","+38614768938", "https://www.fe.uni-lj.si/mma_bin.php?id=2+38614073115544462&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Anton-2", "Kos-2", "izr. prof. dr.",
                "BN514/1-LKN","+3861768493", "https://www.fe.uni-lj.si/mma_bin.php?id=2+3861603221+386172+38619&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Janez-3", "Bešter-3", "prof. dr.",
                "BN511-KAB","+38614768431", "https://www.fe.uni-lj.si/mma_bin.php?id=2+38617061411062592&src=min","Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Jaka-3", "Sodnik-3", "prof. dr.",
                "BN509-KAB","+38614768494", "https://www.fe.uni-lj.si/mma_bin.php?id=2+386140731161035+3861&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Grega-3", "Jakus-3", "izr. prof. dr.",
                "BN514/1-LKN","+38614768938", "https://www.fe.uni-lj.si/mma_bin.php?id=2+38614073115544462&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        seznamVsehZaposlenih.add( new Zaposlen("Anton-3", "Kos-3", "izr. prof. dr.",
                "BN514/1-LKN","+38614768493", "https://www.fe.uni-lj.si/mma_bin.php?id=2016032210172019&src=min","2Na govorilnih urah ste dobrodošli po predhodnem dogovoru, na elektronsko pošto ali telefonsko številko"));

        Toast.makeText(this,getResources().getString(R.string.nalagamZaposlene), Toast.LENGTH_LONG).show();
        SeznamZaposlenihAdapter seznamZaposlenihAdapter = new SeznamZaposlenihAdapter(this,R.layout.razporeditev_informacij_zaposlenega,seznamVsehZaposlenih);
        lV.setAdapter(seznamZaposlenihAdapter);

        //na klik
        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    listViewItemClicked = true;
                    Intent myIntent = new Intent(view.getContext(),zaposleniActivity.class);

                    myIntent.putExtra("Zaposlen",new Gson().toJson(seznamVsehZaposlenih.get(position)));
                    startActivity(myIntent);
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