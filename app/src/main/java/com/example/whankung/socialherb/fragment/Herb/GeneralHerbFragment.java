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
public class GeneralHerbFragment extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.general_herb, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        TextView herb = (TextView) rootView.findViewById(R.id.nameH);
        TextView other = (TextView) rootView.findViewById(R.id.nameOther);
        TextView see = (TextView) rootView.findViewById(R.id.nameSee);
        TextView t = (TextView) rootView.findViewById(R.id.tree);
        TextView t2 = (TextView) rootView.findViewById(R.id.tree2);
        TextView t3 = (TextView) rootView.findViewById(R.id.tree3);
        TextView t4 = (TextView) rootView.findViewById(R.id.tree4);
        TextView t5 = (TextView) rootView.findViewById(R.id.tree5);
        TextView t6 = (TextView) rootView.findViewById(R.id.tree6);
        TextView data = (TextView) rootView.findViewById(R.id.tree_t);
        TextView data2 = (TextView) rootView.findViewById(R.id.tree_t2);
        TextView data3 = (TextView) rootView.findViewById(R.id.tree_t3);
        TextView data4 = (TextView) rootView.findViewById(R.id.tree_t4);
        TextView data5 = (TextView) rootView.findViewById(R.id.tree_t5);
        TextView data6 = (TextView) rootView.findViewById(R.id.tree_t6);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        herb.setTypeface(font);
        other.setTypeface(font);
        see.setTypeface(font);
        t.setTypeface(font);
        t2.setTypeface(font);
        t3.setTypeface(font);
        t4.setTypeface(font);
        t5.setTypeface(font);
        t6.setTypeface(font);
        data.setTypeface(font);
        data2.setTypeface(font);
        data3.setTypeface(font);
        data4.setTypeface(font);
        data5.setTypeface(font);
        data6.setTypeface(font);
    }

}

