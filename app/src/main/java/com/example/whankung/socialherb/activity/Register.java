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
 * Created by Whankung on 18/1/2560.
 */

public class Register extends AppCompatActivity {
    private Typeface font;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        setView();


    }

    private void setView() {
        TextView regis = (TextView) findViewById(R.id.textView);

        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        regis.setTypeface(font);


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
    }


}
