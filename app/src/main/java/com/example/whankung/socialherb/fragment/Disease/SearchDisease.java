package com.example.whankung.socialherb.fragment.Disease;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.fragment.Herb.GeneralHerbFragment;
import com.example.whankung.socialherb.fragment.Herb.HowtoHerbFragment;
import com.example.whankung.socialherb.fragment.Herb.ResearchHerbFragment;
import com.example.whankung.socialherb.fragment.Herb.SampleFragmentPagerAdapterHerb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Whankung on 22/1/2560.
 */

public class SearchDisease extends Fragment{
    private View rootView;
    private TabLayout tabLayout;
    private Typeface font;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.search_disease, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        TextView t = (TextView) rootView.findViewById(R.id.nameD);
        TextView t2= (TextView) rootView.findViewById(R.id.nameDdata);
        TextView t3 = (TextView) rootView.findViewById(R.id.nameOther);
        TextView t4 = (TextView) rootView.findViewById(R.id.nameOtherda);
        TextView t5 = (TextView) rootView.findViewById(R.id.namewhy);
        TextView t6 = (TextView) rootView.findViewById(R.id.namewhyda);
        TextView t7= (TextView) rootView.findViewById(R.id.namehow);
        TextView t8 = (TextView) rootView.findViewById(R.id.namehowda);
        TextView t9 = (TextView) rootView.findViewById(R.id.submit);
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        t.setTypeface(font);
        t2.setTypeface(font);
        t3.setTypeface(font);
        t4.setTypeface(font);
        t5.setTypeface(font);
        t6.setTypeface(font);
        t7.setTypeface(font);
        t8.setTypeface(font);
        t9.setTypeface(font);




    }
}
