package com.example.whankung.socialherb.fragment.Herb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whankung.socialherb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Whankung on 22/1/2560.
 */

public class SearchHerb extends android.support.v4.app.Fragment{
    private View rootView;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.search_herb, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("ตรวจรางวัล"));
        tabLayout.addTab(tabLayout.newTab().setText("เลขเด็ด"));
        viewPager.setAdapter(new SampleFragmentPagerAdapterHerb(getChildFragmentManager(),
                getFragments()));
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        เปลี่ยน font tab
        SampleFragmentPagerAdapterHerb.applyFontedTab(getActivity().getApplicationContext(),viewPager,tabLayout);

    }



    private List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(new GeneralHerbFragment());
        fList.add(new HowtoHerbFragment());
        fList.add(new ResearchHerbFragment());
        return fList;
    }

}