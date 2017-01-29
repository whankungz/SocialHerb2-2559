package com.example.whankung.socialherb.Start;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.activity.MainActivity;


/**
 * Created by Acer on 31/8/2559.
 */

public class FirstNext extends Fragment {
    private Typeface font;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.first_screen, container, false);

        setView();

        return rootView;
    }

    private void setView() {

        ImageView image = (ImageView) rootView.findViewById(R.id.imageView);
        image.setImageResource(R.drawable.ic_logo2);

//        TextView tv = (TextView) rootView.findViewById(R.id.tv);
//        TextView btnClick = (TextView) rootView.findViewById(R.id.tv_guide);
//        เปลี่ยนfont
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
//        tv.setTypeface(font);

//
//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((MainActivity) getActivity()).setSelect(1);
//            }
//        });


//        Button btnClickSKIP = (Button) rootView.findViewById(R.id.skip);
//        btnClickSKIP.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//                ((MainActivity) getActivity()).setSelect(1);
//            }
//        });


    }

}

