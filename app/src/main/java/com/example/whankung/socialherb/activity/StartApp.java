package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.activity.Menu;

/**
 * Created by Whankung on 16/1/2560.
 */

public class StartApp extends Fragment {
    private View rootView;
    private Typeface font;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_start, container, false);
        setView();

        return rootView;
    }

    private void setView() {

//        ImageView image = (ImageView) rootView.findViewById(R.id.imageView2);
//        image.setImageResource(R.drawable.ic_tri);


        TextView tv = (TextView) rootView.findViewById(R.id.textView);
        TextView tv2 = (TextView) rootView.findViewById(R.id.textView2);
        TextView social = (TextView) rootView.findViewById(R.id.social);
        TextView th = (TextView) rootView.findViewById(R.id.TH);


//        เปลี่ยนfont
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        tv.setTypeface(font);
        tv2.setTypeface(font);
        social.setTypeface(font);
        th.setTypeface(font);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Intent i = new Intent(getActivity(), Menu.class);
//                startActivity(i);
//                getActivity().finish();
//                Intent intent = new Intent(getActivity(), Menu.class);
//                startActivity(intent);

                Intent intent = new Intent(getActivity(), Menu.class);
                startActivity(intent);
                getActivity().finish();


            }
        });


        tv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                getActivity().finish();



            }
        });
        }


}
