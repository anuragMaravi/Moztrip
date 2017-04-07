package com.mirakiphi.moztrip.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mirakiphi.infinitecycleviewpager.VerticalInfiniteCycleViewPager;
import com.mirakiphi.moztrip.R;
import com.mirakiphi.moztrip.utils.Utils;

/**
 * Created by GIGAMOLE on 7/27/16.
 */
public class HorizontalPagerAdapter extends PagerAdapter {
    //Changes

    private final Utils.LibraryObject[] LIBRARIES = new Utils.LibraryObject[]{
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_strategy,
                    "Strategy"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_design,
                    "Design"
            ),
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_development,
                    "Development 3"
            ),
            new Utils.LibraryObject(
                    com.mirakiphi.moztrip.R.drawable.ic_qa,
                    "Place 4"
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
        if (mIsTwoWay) {
            view = mLayoutInflater.inflate(com.mirakiphi.moztrip.R.layout.two_way_item, container, false);

            final VerticalInfiniteCycleViewPager verticalInfiniteCycleViewPager =
                    (VerticalInfiniteCycleViewPager) view.findViewById(com.mirakiphi.moztrip.R.id.vicvp);
            verticalInfiniteCycleViewPager.setAdapter(
                    new VerticalPagerAdapter(mContext)
            );
            verticalInfiniteCycleViewPager.setCurrentItem(position);
        } else {
            view = mLayoutInflater.inflate(com.mirakiphi.moztrip.R.layout.item, container, false);
            Utils.setupItem(view, LIBRARIES[position]);
            container.addView(view);

        }
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

