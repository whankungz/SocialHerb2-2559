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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.activity.Menu;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainHerb extends android.support.v4.app.Fragment {
    private View rootView;
    private TabLayout tabLayout;
    private Typeface font;
    private EditText search;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_herb, container, false);
        setView();
        return rootView;
    }


    private void setView() {
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        search = (EditText) rootView.findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                search.setImeOptions(EditorInfo.IME_ACTION_DONE);
                String strMsg = "whan";
                if (s.toString().equals(strMsg)) {
                    search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                            if (actionId == EditorInfo.IME_ACTION_DONE) {

                                FragmentManager m = getFragmentManager();
                                FragmentTransaction t = m.beginTransaction();
                                t.replace(R.id.frgMain, new SearchHerb());
                                t.commit();

                            }
                            return false;
                        }
                    });
                }
            }
        });
    }

//                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.frgMain, new SearchHerb());
//                    transaction.commit();
//                    SearchHerb();
//                    return; true;

}

