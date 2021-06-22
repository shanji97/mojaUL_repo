package si.uni.lj.fe.tnuv.mojaUL;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OStudentu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OStudentu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OStudentu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OStudentu.
     */
    // TODO: Rename and change types and number of parameters
    public static OStudentu newInstance(String param1, String param2) {
        OStudentu fragment = new OStudentu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Student s  = null;
        String student = App.pridobiPodatke("student");
        s = new Gson().fromJson(student,Student.class);






        View v = inflater.inflate(R.layout.fragment_o_studentu, container, false);



       ImageView iV = v.findViewById(R.id.profilnaOdUserja);
       new ImageDownloader(iV).execute(s.profilnaSlikaStudenta);

        EditText gsm = v.findViewById(R.id.gsm);
        gsm.setHint(s.mobilniTelefon);

        EditText stac = v.findViewById(R.id.stac);
        stac.setHint(s.domaciTelefon);

        EditText drzava = v.findViewById(R.id.drzava);
        drzava.setHint(s.drzava);

        EditText ulica =(EditText) v.findViewById(R.id.ulica);
        ulica.setHint(s.naslov);

        EditText obcina  = (EditText) v.findViewById(R.id.posta_obcina);
        obcina.setHint(s.kraj);

        Button shrani_podatke = (Button) v.findViewById(R.id.shraniPodatke);
        s = null;
        shrani_podatke.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        App.getInstance().spremenjeno = true;
                        Student s  = null;
                        String student = App.pridobiPodatke("student");
                        s = new Gson().fromJson(student,Student.class);
                        Toast.makeText(App.app_getContext(),getResources().getString(R.string.shranjujemPodatkeStudenta),Toast.LENGTH_SHORT).show();



                        EditText []  e = { gsm,stac,drzava,ulica,obcina};
                        String [] s_ = {s.mobilniTelefon,s.domaciTelefon,s.drzava,s.naslov,s.kraj};
                        for(int i =0;i<e.length;i++){
                            if(!e[i].getText().toString().equals("")){
                                s_[i] = e[i].getText().toString();
                            }else{
                                s_[i] = e[i].getHint().toString();
                            }
                        }
                        s.shraniPodatke(s_);
                        student = new Gson().toJson(s);
                        App.nastaviPodatke(student,"student");
                        Toast.makeText(App.app_getContext(),getResources().getString(R.string.podatkiShranjenu),Toast.LENGTH_SHORT).show();


                    }
                }
        );








        return v;
    }
}