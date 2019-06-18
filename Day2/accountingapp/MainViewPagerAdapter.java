package demo1.wwh.com.accountingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    LinkedList<MainFragment> fragments=new LinkedList<>();
    LinkedList<String> dates =new LinkedList<>();
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }
    private void initFragment(){
        dates.add("2019-06-15");
        dates.add("2019-06-16");
        dates.add("2019-06-17");
        dates.add("2019-06-18");
        for (String date:dates){
            MainFragment fragment=new MainFragment(date);
            fragments.add(fragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    public int getLastIndex(){
        return fragments.size()-1;
    }
}
