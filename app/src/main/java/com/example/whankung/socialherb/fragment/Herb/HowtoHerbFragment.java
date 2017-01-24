package com.example.whankung.socialherb.fragment.Herb;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.whankung.socialherb.R;

/**
 * Created by Whankung on 22/1/2560.
 */
public class HowtoHerbFragment extends android.support.v4.app.Fragment {
    private Typeface font;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.howto_herb, container, false);
        setView();

        return rootView;
    }

    private void setView() {

        TextView p = (TextView) rootView.findViewById(R.id.proper);
        TextView pdata = (TextView) rootView.findViewById(R.id.properdata);
        TextView h = (TextView) rootView.findViewById(R.id.how);
        TextView hdata = (TextView) rootView.findViewById(R.id.howdata);
        TextView t = (TextView) rootView.findViewById(R.id.t);
        TextView tdata = (TextView) rootView.findViewById(R.id.tdata);
        TextView ment = (TextView) rootView.findViewById(R.id.ment);
        TextView sub = (TextView) rootView.findViewById(R.id.submit);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        p.setTypeface(font);
        pdata.setTypeface(font);
        h.setTypeface(font);
        hdata.setTypeface(font);
        t.setTypeface(font);
        tdata.setTypeface(font);
        ment.setTypeface(font);
        sub.setTypeface(font);

    }
}
