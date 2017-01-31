package com.example.whankung.socialherb.fragment.Herb;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
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
import android.widget.ImageView;
import android.widget.RatingBar;
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
    private TextView t_H, t_H2, t_H3, t_H4, p, p2, p3, p4,s,s2,s3,s4,tb;
    private ImageView i_H, i_H2, i_H3, i_H4, star, star2, star3, star4;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_herb, container, false);
        setView();
        setShowHerb();

        return rootView;
    }



    private void setView() {
      //  tb = (TextView) rootView.findViewById(R.id.toolbar_title);
      //  tb.setText("สมุนไพร");
        s= (TextView) rootView.findViewById(R.id.s);
        s2= (TextView) rootView.findViewById(R.id.s2);
        s3= (TextView) rootView.findViewById(R.id.s3);
        s4= (TextView) rootView.findViewById(R.id.s4);
        p = (TextView) rootView.findViewById(R.id.p);
        p2 = (TextView) rootView.findViewById(R.id.p2);
        p3 = (TextView) rootView.findViewById(R.id.p3);
        p4 = (TextView) rootView.findViewById(R.id.p4);
        t_H = (TextView) rootView.findViewById(R.id.t_H);
        t_H2 = (TextView) rootView.findViewById(R.id.t_H2);
        t_H3 = (TextView) rootView.findViewById(R.id.t_H3);
        t_H4 = (TextView) rootView.findViewById(R.id.t_H4);
        i_H = (ImageView) rootView.findViewById(R.id.i_H);
        i_H2 = (ImageView) rootView.findViewById(R.id.i_H2);
        i_H3 = (ImageView) rootView.findViewById(R.id.i_H3);
        i_H4 = (ImageView) rootView.findViewById(R.id.i_H4);
        star = (ImageView) rootView.findViewById(R.id.star);
        star2 = (ImageView) rootView.findViewById(R.id.star2);
        star3 = (ImageView) rootView.findViewById(R.id.star3);
        star4 = (ImageView) rootView.findViewById(R.id.star4);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        t_H.setTypeface(font);
        t_H2.setTypeface(font);
        t_H3.setTypeface(font);
        t_H4.setTypeface(font);
        p.setTypeface(font);
        p2.setTypeface(font);
        p3.setTypeface(font);
        p4.setTypeface(font);
        s.setTypeface(font);
        s2.setTypeface(font);
        s3.setTypeface(font);
        s4.setTypeface(font);
       // tb.setTypeface(font);

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
                String strMsg = "ทับทิม";
                if (s.toString().equals(strMsg)) {
                    search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                            if (actionId == EditorInfo.IME_ACTION_DONE) {

                                FragmentManager m = getFragmentManager();
                                FragmentTransaction t = m.beginTransaction();
                                t.replace(R.id.container, new SearchHerb());
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


    private void setShowHerb() {
        i_H.setImageResource(R.drawable.img_grass);
        t_H.setText("ตะไคร้");
        i_H2.setImageResource(R.drawable.img_ruby4);
        t_H2.setText("ทับทิม");
        i_H3.setImageResource(R.drawable.img_lemon2);
        t_H3.setText("มะนาว");
        i_H4.setImageResource(R.drawable.img_fa);
        t_H4.setText("ฟ้าทะลายโจร");
        star.setImageResource(R.drawable.ic_star2);
        star2.setImageResource(R.drawable.ic_star2);
        star3.setImageResource(R.drawable.ic_star2);
        star4.setImageResource(R.drawable.ic_star2);

    }

}

