package com.example.studio.android.bo.testmoi;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

/**
 *
 * Created by bopheakdey on 12/17/2015.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public Context context;
    private Fragment fragment = null;

    public PagerAdapter(Context context, FragmentManager fm){
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            fragment = new PageFragment();
        }else if (position == 1){
            fragment = new PageFragment();
        }else if(position ==2){
            fragment = new PageFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 :
                return "Home";
            case 1 :
                return "Chat";
            case 2 :
                return "Wish House";
        }
        return super.getPageTitle(position);
    }
}
