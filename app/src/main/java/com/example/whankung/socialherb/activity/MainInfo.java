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
    TextView tv, im, im2, im3, im4, im5,im6,p,p2,p3,p4,p5,p6;
    ImageView img, i, i2, i3, i4, i5, i6;

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
        im = (TextView) findViewById(R.id.im);
        im2 = (TextView) findViewById(R.id.im2);
        im3 = (TextView) findViewById(R.id.im3);
        im4 = (TextView) findViewById(R.id.im4);
        im5 = (TextView) findViewById(R.id.im5);
        im6 = (TextView) findViewById(R.id.im6);
        p = (TextView) findViewById(R.id.p);
        p2 = (TextView) findViewById(R.id.p2);
        p3 = (TextView) findViewById(R.id.p3);
        p4 = (TextView)findViewById(R.id.p4);
        p5 = (TextView) findViewById(R.id.p5);
        p6 = (TextView) findViewById(R.id.p6);

//        เปลี่ยนfont
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tv.setTypeface(font);
        im.setTypeface(font);
        im2.setTypeface(font);
        im3.setTypeface(font);
        im4.setTypeface(font);
        im5.setTypeface(font);
        im6.setTypeface(font);
        p.setTypeface(font);
        p2.setTypeface(font);
        p3.setTypeface(font);
        p4.setTypeface(font);
        p5.setTypeface(font);
        p6.setTypeface(font);


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
        im.setText("7ข้อที่ชาวไร่ยาสูบ ยังได้รับ-ทำได้");
        im2.setText("สงกรานต์ปลอดภัย ดื่มไม่ขับ");
        im3.setText("9 วิธีเอาตัวรอดแบบไม่เสียเพื่อน");
        im4.setText("สาเหตุหลักของการเกิดอุบัติเหตุ");
        im5.setText("ลดความเร็ว ลดความเสี่ยง");
        im6.setText("อาการเส้นเลือดในสมองตีบ");
    }
}
