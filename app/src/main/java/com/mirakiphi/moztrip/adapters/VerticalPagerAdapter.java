package com.mirakiphi.moztrip.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mirakiphi.moztrip.utils.Utils;

/**
 * Created by GIGAMOLE on 7/27/16.
 */
public class VerticalPagerAdapter extends PagerAdapter {

    private final Utils.LibraryObject[] TWO_WAY_LIBRARIES = new Utils.LibraryObject[]{
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_fintech,
                    "Fintech"
            ),
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_delivery,
                    "Delivery"
            ),
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_social,
                    "Social network"
            ),
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_ecommerce,
                    "E-commerce"
            ),
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_wearable,
                    "Wearable"
            ),
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_internet,
                    "Internet of things"
            )
    };

    private LayoutInflater mLayoutInflater;

    public VerticalPagerAdapter(final Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return TWO_WAY_LIBRARIES.length;
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view = mLayoutInflater.inflate(com.mirakiphi.moztrip.R.layout.item, container, false);

        Utils.setupItem(view, TWO_WAY_LIBRARIES[position]);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}
