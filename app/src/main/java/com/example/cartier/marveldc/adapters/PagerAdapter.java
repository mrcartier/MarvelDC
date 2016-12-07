package com.example.cartier.marveldc.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.cartier.marveldc.fragments.DCFragment;
import com.example.cartier.marveldc.fragments.MarvelFragment;


/**
 * Created by Cartier on 12/6/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MarvelFragment tab1 = new MarvelFragment();
                return tab1;
            case 1:
                DCFragment tab2 = new DCFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
