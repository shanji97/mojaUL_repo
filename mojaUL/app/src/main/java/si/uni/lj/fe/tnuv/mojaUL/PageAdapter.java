package si.uni.lj.fe.tnuv.mojaUL;

import android.graphics.pdf.PdfDocument;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private  int steviloTabov;
    public PageAdapter(FragmentManager fm, int steviloTabov){
        super(fm);
        this.steviloTabov = steviloTabov;
    }
    public Fragment getItem(int pozicija){
        switch (pozicija){
            case  0: return  new OStudentu();
            case 1: return new SeznamIzpitov();
            case 2: return  new OnlineStudis();
            default: return  null;
        }

    }
    public int getCount(){
        return steviloTabov;
    }
    public int getItemPosition(@NonNull Object object){
        return POSITION_NONE;
    }
}
