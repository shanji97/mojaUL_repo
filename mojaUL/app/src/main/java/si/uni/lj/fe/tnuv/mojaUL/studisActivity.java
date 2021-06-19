package si.uni.lj.fe.tnuv.mojaUL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

import android.os.Bundle;
import android.view.Choreographer;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class studisActivity extends AppCompatActivity {

    private TabLayout tL;
    private ViewPager vP;



/*
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2, tab3;

    public PageAdapter pageAdapter;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studis);

        tL =  (TabLayout) findViewById(R.id.tL);
        vP = (ViewPager) findViewById(R.id.viewPage_no2);

        ArrayList<String> imenaTabov = new ArrayList<String>();
        String []  imenaTabovSeznam  = new String[] {

                getResources().getString(R.string.o_studentu_napis),
                getResources().getString(R.string.seznam_izpitov_napis),
                getResources().getString(R.string.vec_na_online_verziji_studis_napis)
        };

        for(int i = 0; i < imenaTabovSeznam.length;i++){
            imenaTabov.add(imenaTabovSeznam[i]);
        }
        prepareViewPager(vP,imenaTabov);

        tL.setupWithViewPager(vP);

    }
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