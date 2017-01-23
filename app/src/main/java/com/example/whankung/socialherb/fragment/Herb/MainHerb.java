package com.example.whankung.socialherb.fragment.Herb;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.activity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainHerb extends android.support.v4.app.Fragment {
    private View rootView;
    private TabLayout tabLayout;
    private Typeface font;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_herb, container, false);
        setView();

        return rootView;
    }


    private void setView() {
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        EditText search = (EditText)rootView.findViewById(R.id.search);
       search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    FragmentManager m =getFragmentManager();
                    FragmentTransaction t =m.beginTransaction();
                    t.replace(R.id.frgMain, new SearchHerb());
                    t.commit();

//                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.frgMain, new SearchHerb());
//                    transaction.commit();
//                    SearchHerb();
//                    return; true;
                }
                return false;
            }
        });
//        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
//        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
//        tabLayout.addTab(tabLayout.newTab().setText("ตรวจรางวัล"));
//        tabLayout.addTab(tabLayout.newTab().setText("เลขเด็ด"));
//        viewPager.setAdapter(new SampleFragmentPagerAdapterHerb(getChildFragmentManager(),
//                getFragments()));
//        tabLayout.setupWithViewPager(viewPager);
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
////        เปลี่ยน font tab
//        SampleFragmentPagerAdapterHerb.applyFontedTab(getActivity().getApplicationContext(),viewPager,tabLayout);
//
//    }
//
//
//
//    private List<Fragment> getFragments() {
//
//        List<Fragment> fList = new ArrayList<Fragment>();
//        fList.add(new GeneralHerbFragment());
//        fList.add(new HowtoHerbFragment());
//        fList.add(new ResearchHerbFragment());
//        return fList;
    }



}

