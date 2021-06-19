package si.uni.lj.fe.tnuv.mojaUL;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fA) {
        super(fA);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position){
        switch (position){
            case 0:
                return new OStudentu();
            case 2:
                return new SeznamIzpitov();
            case 3:
            default:
                return new OnlineStudis();


        }
    }
    @Override
    public  int getItemCount() {
        return 3; //zaenkrat statično
    }
}
