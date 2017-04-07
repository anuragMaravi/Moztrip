package com.mirakiphi.moztrip.screens;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.mirakiphi.moztrip.adapters.MainPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mirakiphi.moztrip.R.layout.activity_main);

        final ViewPager viewPager = (ViewPager) findViewById(com.mirakiphi.moztrip.R.id.vp_main);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(2);

        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) findViewById(com.mirakiphi.moztrip.R.id.nts);
        navigationTabStrip.setTitles("HOW WE WORK", "WE WORK WITH");
        navigationTabStrip.setViewPager(viewPager);
    }
}
