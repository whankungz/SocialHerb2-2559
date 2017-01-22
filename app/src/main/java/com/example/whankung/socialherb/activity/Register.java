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
    }


}
