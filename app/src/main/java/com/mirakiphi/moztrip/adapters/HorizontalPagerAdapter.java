package com.mirakiphi.moztrip.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mirakiphi.moztrip.PlaceActivity;
import com.mirakiphi.moztrip.R;
import com.mirakiphi.moztrip.utils.Utils;

/**
 * Created by GIGAMOLE on 7/27/16.
 */
public class HorizontalPagerAdapter extends PagerAdapter {
    //Changes

    private final Utils.LibraryObject[] LIBRARIES = new Utils.LibraryObject[]{
            new Utils.LibraryObject(
                    R.drawable.place2sample,
                    "Place 1","#1 on Popular Places"
            ),
            new Utils.LibraryObject(
                    R.drawable.place1sample,
                    "Place 2","#2 on Popular Places"
            ),
            new Utils.LibraryObject(
                    R.drawable.place2sample,
                    "Place 3","#3 on Popular Places"
            ),
            new Utils.LibraryObject(
                    R.drawable.place1sample,
                    "Place 4","#4 on Popular Places"
            )
    };

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private boolean mIsTwoWay;

    public HorizontalPagerAdapter(final Context context, final boolean isTwoWay) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mIsTwoWay = isTwoWay;
    }


    @Override
    public int getCount() {
        return mIsTwoWay ? 6 : LIBRARIES.length;
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;
            view = mLayoutInflater.inflate(com.mirakiphi.moztrip.R.layout.item, container, false);
            Utils.setupItem(view, LIBRARIES[position]);
            container.addView(view);
            view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newi=new Intent(mContext, PlaceActivity.class);
                mContext.startActivity(newi);
            }
        });
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

