package com.mirakiphi.moztrip.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mirakiphi.moztrip.screens.HorizontalPagerFragment;

/**
 * Created by GIGAMOLE on 8/18/16.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private final static int COUNT = 3;


    public MainPagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {

                return new HorizontalPagerFragment();

    }

    @Override
    public int getCount() {
        return COUNT;
    }
}
