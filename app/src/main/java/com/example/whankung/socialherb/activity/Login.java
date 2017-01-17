package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by Whankung on 17/1/2560.
 */

public class Login extends AppCompatActivity {



    private Typeface font;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setView();


    }


    private void setView() {

        TextView skip = (TextView) findViewById(R.id.skip);
        TextView head = (TextView) findViewById(R.id.textView4);
        TextView login = (TextView) findViewById(R.id.textView);
        TextView regis = (TextView) findViewById(R.id.textView2);
        TextView user = (TextView) findViewById(R.id.user);
        TextView psword = (TextView) findViewById(R.id.password);

//        เปลี่ยนfont
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        skip.setTypeface(font);
        head.setTypeface(font);
        user.setTypeface(font);
        psword.setTypeface(font);
        login.setTypeface(font);
        regis.setTypeface(font);

//หน้าแรก
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
//                getActivity().finish();
            }
        });
//เข้าสู่ระบบ
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });
//ลงทะเบียน
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });

    }
}
