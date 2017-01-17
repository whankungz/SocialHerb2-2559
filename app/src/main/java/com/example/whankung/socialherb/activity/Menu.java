package com.example.whankung.socialherb.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.fragment.Article.MainAritcle;
import com.example.whankung.socialherb.fragment.Disease.MainDisease;
import com.example.whankung.socialherb.fragment.Favorite.MainFavorite;
import com.example.whankung.socialherb.fragment.Herb.MainHerb;
import com.example.whankung.socialherb.view.Singleton;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by Whankung on 16/1/2560.
 */

public class Menu extends AppCompatActivity {
    private Typeface font;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setView();
        setBottomBar();

    }


    private void setView() {
        Singleton.getInstance().setFirstOpenApp(true);

//                เปลี่ยน font
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");

    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frgMain, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void setBottomBar() {
        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
           TextView tv = (TextView) findViewById(R.id.toolbar_title);

//            ImageView img = (ImageView) findViewById(R.id.action);

            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_herb) {

                    // Toast.makeText(MainActivity.this,"tttt",Toast.LENGTH_LONG).show();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainHerb());
                    transaction.commit();
                    tv.setText("สมุนไพร");
//                    tv.setTextColor(Color.parseColor("#228B22"));
                    tv.setTypeface(font);
                 //   img.setVisibility(View.INVISIBLE);

                } else if (tabId == R.id.tab_disease) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainDisease());
                    transaction.commit();
                    tv.setText("อาการ/โรค");
//                    tv.setTextColor(Color.parseColor("#B22222"));
                   // img.setVisibility(View.INVISIBLE);
                } else if (tabId == R.id.tab_aritcle) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainAritcle());
                    transaction.commit();
                    tv.setText("บทความ");
//                    tv.setTextColor(Color.parseColor("#20B2AA"));
                  //  img.setVisibility(View.INVISIBLE);
                } else if (tabId == R.id.tab_favorite) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainFavorite());
                    transaction.commit();
                    tv.setText("รายการโปรด");
//                    tv.setTextColor(Color.parseColor("#20B2AA"));
                   // img.setVisibility(View.INVISIBLE);
                }
            }


        });

    }


}