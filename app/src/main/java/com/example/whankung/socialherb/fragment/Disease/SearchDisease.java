package com.example.whankung.socialherb.fragment.Disease;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.search_disease, container, false);
        setView();

        return rootView;
    }

    private void setView() {

    }
}
