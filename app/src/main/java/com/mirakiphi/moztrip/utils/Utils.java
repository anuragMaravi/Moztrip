package com.mirakiphi.moztrip.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mirakiphi.moztrip.R;

/**
 * Created by GIGAMOLE on 8/18/16.
 */
public class Utils {

    public static void setupItem(final View view, final LibraryObject libraryObject) {
        final TextView txt = (TextView) view.findViewById(R.id.txt_item);
        txt.setText(libraryObject.getTitle());

        final TextView rank = (TextView) view.findViewById(R.id.txt_rank);
        rank.setText(libraryObject.getRank());

        final ImageView img = (ImageView) view.findViewById(R.id.img_item);
        img.setImageResource(libraryObject.getRes());
    }

    public static class LibraryObject {

        private String mTitle;
        private String mRank;
        private int mRes;


        public LibraryObject(final int res, final String title, final String rank) {
            mRes = res;
            mTitle = title;
            mRank = rank;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(final String title) {
            mTitle = title;
        }

        public String getRank() {
            return mRank;
        }

        public void setRank(final String rank) {
            mRank = rank;
        }

        public int getRes() {
            return mRes;
        }

        public void setRes(final int res) {
            mRes = res;
        }
    }
}
