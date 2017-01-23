package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whankung.socialherb.R;

import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * Created by Whankung on 18/1/2560.
 */

public class Register extends AppCompatActivity {
    private Typeface font;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        setView();


    }

    private void setView() {
        TextView regis2 = (TextView) findViewById(R.id.regis);
        TextView regis_bar = (TextView) findViewById(R.id.textView);
        TextView user2 = (TextView) findViewById(R.id.username);
        TextView pass = (TextView) findViewById(R.id.pass);
        TextView mail = (TextView) findViewById(R.id.mail);
        TextView sex = (TextView) findViewById(R.id.sex);


        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        regis2.setTypeface(font);
        regis_bar.setTypeface(font);
        user2.setTypeface(font);
        pass.setTypeface(font);
        mail.setTypeface(font);
        sex.setTypeface(font);

        regis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
//                getActivity().finish();
            }
        });


        ImageView img = (ImageView) findViewById(R.id.action);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือก ถาคของเรา
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });

        SegmentedGroup segmented2 = (SegmentedGroup)findViewById(R.id.segmented2);
        segmented2.setTintColor(Color.DKGRAY);

        RadioButton man =(RadioButton)findViewById(R.id.man);
        RadioButton wman =(RadioButton)findViewById(R.id.woman);

        man.setTypeface(font);
        wman.setTypeface(font);

    }

}
