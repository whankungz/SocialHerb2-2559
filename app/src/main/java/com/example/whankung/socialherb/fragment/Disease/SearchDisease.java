package com.example.whankung.socialherb.fragment.Disease;

import android.graphics.Typeface;
import android.media.Rating;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.fragment.Herb.GeneralHerbFragment;
import com.example.whankung.socialherb.fragment.Herb.HowtoHerbFragment;
import com.example.whankung.socialherb.fragment.Herb.ResearchHerbFragment;
import com.example.whankung.socialherb.fragment.Herb.SampleFragmentPagerAdapterHerb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Whankung on 22/1/2560.
 */

public class SearchDisease extends Fragment {
    private View rootView;
    private TabLayout tabLayout;
    private Typeface font;
    private TextView t, t2, t3, t4, t5, t6, t7, t8, t9;
    private RatingBar r;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.search_disease, container, false);
        setView();
        setSearch();

        return rootView;
    }


    private void setView() {
        t = (TextView) rootView.findViewById(R.id.nameD);
        t2 = (TextView) rootView.findViewById(R.id.nameDdata);
        t3 = (TextView) rootView.findViewById(R.id.nameOther);
        t4 = (TextView) rootView.findViewById(R.id.nameOtherda);
        t5 = (TextView) rootView.findViewById(R.id.namewhy);
        t6 = (TextView) rootView.findViewById(R.id.namewhyda);
        t7 = (TextView) rootView.findViewById(R.id.namehow);
        t8 = (TextView) rootView.findViewById(R.id.namehowda);
        t9 = (TextView) rootView.findViewById(R.id.submit);
        r = (RatingBar) rootView.findViewById(R.id.rat);
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        t.setTypeface(font);
        t2.setTypeface(font);
        t3.setTypeface(font);
        t4.setTypeface(font);
        t5.setTypeface(font);
        t6.setTypeface(font);
        t7.setTypeface(font);
        t8.setTypeface(font);
        t9.setTypeface(font);
    }

    private void setSearch() {
        t2.setText("ปวดฟัน");
        t4.setText("กานพลู ดาวเรือง เมล็ดผักชี ผักบุ้งนา มะระ ว่านหางจระเข้ น้ำมันกระเทียม ใบชา เมล็ดกุยช่าย");
        t6.setText("เวลากินของเย็น ของหวาน หรือเมื่อตอนเคี้ยวอาหารและอาการเหล่านี้จะหายไปเมื่อหยุดกินอาหารดังกล่าวภายในไม่กี่นาึ่งลักษณะของอาการปวดเช่นนี้มักเกิดจากฟันผุหรือฟันบิ่นจนถึงเนื้อฟันชั้นในจึงทำให้ความเย็นหรือแรงจากการเคี้ยวอาหารมีโอกาสกระตุ้นเส้นประสาทที่อยู่ในโพรงประสาทใต้เนื้อฟันได้มากกว่าปกติ จึงทำให้เกิดความรู้สึกเสียวฟันทุกครั้งเมื่อกินอาหาร ส่วนอาการปวดฟันอีกประเภทหนึ่ง ซึ่งจะมีความรุนแรงกว่า คือ การปวดเป็นจังหวะ ตุ้บ ๆ ซึ่งอาจปวดโดยอยู่เฉย ๆ ก็ปวด หรืออาจปวดมากขึ้นเวลากินของเย็นหรือของร้อน หรือเวลาเคี้ยวอาหาร และอาการปวดนี้จะไม่หายไปแม้จะเลิกกินอาหารเหล่านี้แล้วก็ตาม");
        t8.setText("หลีกเลี่ยงอาหารประเภทดังกล่าวพร้อมกับการรับประทานยาแก้ปวด");

    }
}
