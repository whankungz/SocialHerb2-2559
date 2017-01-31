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
 * Created by Whankung on 31/1/2560.
 */
public class DataOffice extends AppCompatActivity {
    private View rootView;
    private Typeface font;
    private TextView tvI, nameI, namefI, frI, submitI;
    private ImageView i_Info,imW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_food);
        setView();
        setData();

    }

    private void setView() {
        tvI = (TextView) findViewById(R.id.textI);
        nameI = (TextView) findViewById(R.id.nameI);
        namefI = (TextView)findViewById(R.id.namefI);
        frI = (TextView) findViewById(R.id.frI);
        submitI = (TextView) findViewById(R.id.submitI);
        i_Info = (ImageView) findViewById(R.id.i_Info);

        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tvI.setTypeface(font);
        nameI.setTypeface(font);
        namefI.setTypeface(font);
        frI.setTypeface(font);
        submitI.setTypeface(font);

        imW = (ImageView) findViewById(R.id.action);
        imW.setVisibility(View.VISIBLE);
        imW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainFood.class);
                startActivity(intent);

            }
        });
    }

    private void setData() {
        i_Info.setImageResource(R.drawable.img_in_big);
        nameI.setText("7 ข้อที่ชาวไร่ยาสูบ ยังได้รับ-ทำได้");
        frI.setText("http://www.thaihealth.or.th/Infographic/detail/");
    }
}
