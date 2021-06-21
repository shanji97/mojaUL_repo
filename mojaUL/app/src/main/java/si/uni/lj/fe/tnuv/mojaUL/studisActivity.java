package si.uni.lj.fe.tnuv.mojaUL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class studisActivity extends AppCompatActivity {

    private TabLayout tL;
    private TextView tV;
    //private ViewPager vP;
    private ViewPager2 vP;
    private  Student s = null;
    private Boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studis);

        tV = findViewById(R.id.ime_in_priimek_Uporabnika_Studis);
        String podatkiStudenta = App.pridobiPodatke(getResources().getString(R.string.student_podatki));
        if (podatkiStudenta == null || podatkiStudenta.equals("")) {
            Toast.makeText(studisActivity.this, getResources().getString(R.string.podatkovStudentaNi), Toast.LENGTH_SHORT).show();
            // za potrebe aplikacije nalozimo nove podatke
            s = new Student();
        } else {
            s = new Gson().fromJson(podatkiStudenta, Student.class);
            //podatki uspešno naloženi
        }
        tV.setText(s.ime + " " + s.priimek);
        tL =  (TabLayout) findViewById(R.id.tL);
        vP = (ViewPager2) findViewById(R.id.viewPage_no2);
        FragmentAdapter adapter;

        ArrayList<String> imenaTabov = new ArrayList<String>();
        String []  imenaTabovSeznam  = new String[] {

                getResources().getString(R.string.o_studentu_napis),
                getResources().getString(R.string.vec_na_online_verziji_studis_napis)
        };

        for(int i = 0; i < imenaTabovSeznam.length;i++)
            imenaTabov.add(imenaTabovSeznam[i]);



            FragmentManager fm = getSupportFragmentManager();
            adapter = new FragmentAdapter(fm,getLifecycle());
            vP.setAdapter(adapter);

            for(int j=0;j<imenaTabov.size();j++){
                tL.addTab(

                        tL.newTab().setText(imenaTabov.get(j))
                );

            }

            tL.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    vP.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            vP.registerOnPageChangeCallback(

                    new ViewPager2.OnPageChangeCallback() {
                        @Override
                        public void onPageSelected(int position) {
                            tL.selectTab(tL.getTabAt(position));
                        }
                    }
            );





      /*  prepareViewPager(vP,imenaTabov);

        tL.setupWithViewPager(vP);*/

    }

    //DISCONTINUED, ker ni delovalo tak kot trabe
    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList){
        MainAdapter mA = new MainAdapter(getSupportFragmentManager());

        Fragment fragment = new Fragment();
        for(int i =0;i<arrayList.size();i++){
            Bundle bundle = new Bundle();
            bundle.putString("title",arrayList.get(i));
            fragment.setArguments(bundle);

            mA.addFragment(fragment,arrayList.get(i));
            fragment = new Fragment();

        }
        viewPager.setAdapter(mA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        paused = true;
        if(App.getInstance().studisInit){
            App.getInstance().studisInit = false;
            return;

        }
        //shranimo študenta v preferences
        Student s;
        String podatkiStudenta = App.pridobiPodatke(getResources().getString(R.string.student_podatki));
        if (podatkiStudenta == null || podatkiStudenta.equals("")) {
            Toast.makeText(studisActivity.this, getResources().getString(R.string.podatkovStudentaNi), Toast.LENGTH_SHORT).show();
            // za potrebe aplikacije nalozimo nove podatke
            s = new Student();
        } else {
            s = new Gson().fromJson(podatkiStudenta, Student.class);
            //podatki uspešno naloženi
        }

        //podatke pošilji na strežnik oz. v tem primeru, bo to moj študentski mail

        if (!App.getInstance().jeInternetnaPovezavaVzpostavljena()) {
            //obvesti, da ni povezave
            return;
        }
        String[] prejemniki = {
                getResources().getString(R.string.streznikZaPodatke)
        };


        String student = App.pridobiPodatke("student");
        s = new Gson().fromJson(student,Student.class);

        posljiEmail(prejemniki, null, getResources().getString(R.string.posredoVanje_podatkov_strezniku),student);

        Toast.makeText(studisActivity.this, App.getInstance().mailUspesnoPoslan, Toast.LENGTH_SHORT).show();



    }
    @Override
    protected void onResume() {
        super.onResume();
        if(paused &&App.getInstance().studisInit==false){


        Intent i = new Intent(this,glavniPanelActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        }

    }
    public void posljiEmail(
            String[] prejemniki,
            String[] cc,
            String zadeva,
            String sporocilo

    ){
        //zaenkrat samo prikažemo kaj bi se poslalo na REST Api, strežnik, če bi le-te obstajal.

       App.getInstance().mailUspesnoPoslanStatus = false;
        Intent i = new Intent(Intent.ACTION_SEND);

        i.setData(Uri.parse("mailto:"));
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL, prejemniki);
        if (cc != null && cc.length>0){
            i.putExtra(Intent.EXTRA_CC,cc);
        }
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_SUBJECT, zadeva);
        i.putExtra(Intent.EXTRA_TEXT, sporocilo);
        try {
            //trenutna rešitev, bi drugače rešil z REST APIji
            startActivity(Intent.createChooser(i,zadeva));
            App.getInstance().mailUspesnoPoslan = getResources().getString(R.string.mailJeUspesnoPoslan);
            App.getInstance().mailUspesnoPoslanStatus = true;
        }
        catch (Exception e){
           App.getInstance().mailUspesnoPoslan =  getResources().getString(R.string.mailNeuspesnoPoslan);
            Log.e("E",App.getInstance().eToString(e));

        }



    }
/*
    @Override
    protected void onStop() {
        super.onStop();
    }*/


}

class MainAdapter extends FragmentPagerAdapter {
    ArrayList<String> titels = new ArrayList<String>();
    List<Fragment> fList = new ArrayList<Fragment>();

    public void addFragment(Fragment f, String title){
        titels.add(title);
        fList.add(f);
    }
    public MainAdapter(@NonNull FragmentManager fm){
        super(fm);
    }



    @NonNull

    @Override
    public Fragment getItem(int position) {
        return fList.get(position);
    }
    @Override
    public  int getCount(){ return fList.size();}

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return titels.get(position);
    }
}