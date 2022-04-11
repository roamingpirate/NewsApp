package com.example.stock;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Fragment_adapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments_list=new ArrayList<Fragment>();
    ArrayList<String>  title_list = new ArrayList<String>();

    public Fragment_adapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return fragments_list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments_list.get(position);
    }


    public void Add_fragment(Fragment frag,String title){
        fragments_list.add(frag);
        title_list.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return title_list.get(position);
    }
}
