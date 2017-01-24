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
public class ResearchHerbFragment extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.research_herb, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        TextView re = (TextView) rootView.findViewById(R.id.research);
        TextView fromre = (TextView) rootView.findViewById(R.id.fromre);
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        re.setTypeface(font);
        fromre.setTypeface(font);




    }
}
