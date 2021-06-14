package si.uni.lj.fe.tnuv.mojaUL;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SeznamZaposlenihAdapter extends ArrayAdapter<Zaposlen> {

    private Context mContext;
    private int resource;

    public SeznamZaposlenihAdapter(Context c, int vir, ArrayList<Zaposlen> zaposleni){
        super(c,vir,zaposleni);
        mContext = c;
        resource =vir;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String naziv  = getItem(position).getNaziv();
        String  ime  = getItem(position).getIme();
        String imeInPriimek = getItem(position).getIme()+" "+getItem(position).getPriimek();

        Zaposlen z = new Zaposlen("TAleksander","TKovač","študent","ak3900@student.uni-lj.si","P10","+38640724968");

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(resource,parent,false);

        TextView tvImeZaposlenega = (TextView) convertView.findViewById(R.id.ime_zaposlenega);
        TextView tvNazivZaposlenega = (TextView) convertView.findViewById(R.id.naziv_zaposlenega);

        tvImeZaposlenega.setText(getItem(position).getIme()+" "+getItem(position).getPriimek());
        tvNazivZaposlenega.setText(naziv);
        return convertView;
    }


}
