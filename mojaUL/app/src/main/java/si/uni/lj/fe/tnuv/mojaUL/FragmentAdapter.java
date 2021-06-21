package si.uni.lj.fe.tnuv.mojaUL;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter  extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull  FragmentManager fragmentManager, @NonNull  Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch(position){
           case 1:
               return new OnlineStudis();
           default:
           case 0:

               return new OStudentu();
       }
    }
    @Override
    public int getItemCount() {
        return 2; //v main adapter je bolje rešeno, a
    }
}
