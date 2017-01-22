package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.activity.Login;
import com.example.whankung.socialherb.activity.Menu;

/**
 * Created by Whankung on 19/1/2560.
 */

public class MainInfo extends AppCompatActivity {

    private Typeface font;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stucture_info);
        ImageView img = (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือกเภสัช
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });
        setView();


    }


    private void setView() {
        TextView tv = (TextView) findViewById(R.id.textView);


//        เปลี่ยนfont
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tv.setTypeface(font);

        ImageView img = (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });

    }
}
