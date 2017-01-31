package com.example.whankung.socialherb.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;

/**
 * Created by Whankung on 31/1/2560.
 */

public class ShareF extends AppCompatActivity {

    private Typeface font;
    private TextView tvI, shareW,ts,Sapp;
    private ImageView imgF, i4, i5, i6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stucture_share);
        imgF = (ImageView) findViewById(R.id.action_face);
        imgF.setVisibility(View.VISIBLE);
        imgF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือกเภสัช
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

                InputMethodManager imm = (InputMethodManager) getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

            }
        });
        setView();

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }


    private void setView() {
        tvI = (TextView) findViewById(R.id.textI);
        shareW = (TextView) findViewById(R.id.shareW);
        ts = (TextView) findViewById(R.id.tshare);
        Sapp= (TextView) findViewById(R.id.soapp);
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tvI.setTypeface(font);
        shareW.setTypeface(font);
        ts.setTypeface(font);
        Sapp.setTypeface(font);
    }
}
