package com.example.whankung.socialherb.Start;

/**
 * Created by Acer on 31/8/2559.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.whankung.socialherb.activity.StartApp;

public  class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public int getCount() {
        return 2;
    }

    public Fragment getItem(int position) {
        if (position == 0)
            return new FirstNext();
        else if (position == 1)
            return new StartApp();

        return null;
    }
}


