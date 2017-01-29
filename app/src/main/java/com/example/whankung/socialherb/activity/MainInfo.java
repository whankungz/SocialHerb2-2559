package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;

/**
 * Created by Whankung on 19/1/2560.
 */

public class MainInfo extends AppCompatActivity {

    private Typeface font;
    TextView tv;
    ImageView img,i,i2,i3,i4,i5,i6;

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
        setInfo();


    }


    private void setView() {
        tv = (TextView) findViewById(R.id.textView);
        img = (ImageView) findViewById(R.id.action_login);
        i = (ImageView) findViewById(R.id.img);
        i2 = (ImageView) findViewById(R.id.img2);
        i3 = (ImageView) findViewById(R.id.img3);
        i4 = (ImageView) findViewById(R.id.img4);
        i5 = (ImageView) findViewById(R.id.img5);
        i6 = (ImageView) findViewById(R.id.img6);

//        เปลี่ยนfont
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tv.setTypeface(font);


        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });


        i.setClickable(true);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DataInfo.class);
                startActivity(intent);
            }
        });
    }


    private void setInfo() {
        i.setImageResource(R.drawable.img_in);
        i2.setImageResource(R.drawable.img_in2);
        i3.setImageResource(R.drawable.img_in3);
        i4.setImageResource(R.drawable.img_in4);
        i5.setImageResource(R.drawable.img_in5);
        i6.setImageResource(R.drawable.img_in6);
    }
}
