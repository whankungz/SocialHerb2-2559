package com.example.whankung.socialherb.fragment.Article;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.activity.Login;
import com.example.whankung.socialherb.fragment.Disease.SearchDisease;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainArticle extends android.support.v4.app.Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_article, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        ImageView i = (ImageView) rootView.findViewById(R.id.imageView2);
        i.setClickable(true);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager m =getFragmentManager();
                FragmentTransaction t =m.beginTransaction();
                t.replace(R.id.frgMain, new DataArticle());
                t.commit();
            }
        });

    }
}
