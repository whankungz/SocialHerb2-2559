package com.example.whankung.socialherb.fragment.Article;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.whankung.socialherb.R;

/**
 * Created by Whankung on 24/1/2560.
 */

public class DataArticle extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.data_article, container, false);
        setView();

        return rootView;
    }

    private void setView() {

        TextView t = (TextView) rootView.findViewById(R.id.nameA);
        TextView t2= (TextView) rootView.findViewById(R.id.nameDdataA);
        TextView t3 = (TextView) rootView.findViewById(R.id.namef);
        TextView t4 = (TextView) rootView.findViewById(R.id.namefda);
        TextView t5 = (TextView) rootView.findViewById(R.id.namefdat);
        TextView t6 = (TextView) rootView.findViewById(R.id.submit);
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        t.setTypeface(font);
        t2.setTypeface(font);
        t3.setTypeface(font);
        t4.setTypeface(font);
        t5.setTypeface(font);
        t6.setTypeface(font);

    }

}
