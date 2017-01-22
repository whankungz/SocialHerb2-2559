package com.example.whankung.socialherb.fragment.Disease;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.fragment.Herb.SearchHerb;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainDisease extends android.support.v4.app.Fragment{
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_disease, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        EditText searchD = (EditText)rootView.findViewById(R.id.searchD);
        searchD.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    FragmentManager m =getFragmentManager();
                    FragmentTransaction t =m.beginTransaction();
                    t.replace(R.id.frgMain, new SearchDisease());
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
    }
}
