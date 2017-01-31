package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.fragment.Disease.SearchDisease;
import com.example.whankung.socialherb.fragment.Herb.SampleFragmentPagerAdapterHerb;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import static android.R.attr.name;

/**
 * Created by Whankung on 17/1/2560.
 */

public class Login extends AppCompatActivity {
    private Drawer result = null;
    private Typeface font;
    // Email, password edittext
    EditText user, password;

    // login
    TextView login;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setView();
        setLogin();
    }


    private void setView() {

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
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Menu.class);
//                startActivity(intent);
//
//
//            }
//        });
//ลงทะเบียน
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

            }
        });

    }



    private void setLogin() {


        //login
        // Session Manager
        session = new SessionManagement(getApplicationContext());

        // Email, Password input text
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();



        // Login
        login = (TextView) findViewById(R.id.textView);


        // Login button click event
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                        startActivity(i);
            }
//                // Get username, password from EditText
//                String username = user.getText().toString();
//                String Password = password.getText().toString();
//
//                // Check if username, password is filled
//                if (username.trim().length() > 0 && Password.trim().length() > 0) {
//                    // For testing puspose username, password is checked with sample data
//                    // username = test
//                    // password = test
//                    if (username.equals("whan") && Password.equals("1234")) {
//
//
//
//                      // Creating user login session
//                        // For testing i am stroing name, email as follow
//                        // Use user real data
//
//                        session.createLoginSession("Android Hive","sfd");
//
//
//                        // Staring MainActivity
//
//                        Intent i = new Intent(getApplicationContext(), Menu.class);
//                        startActivity(i);
//
//
//
//                    } else {
//                        // username / password doesn't match
//                        alert.showAlertDialog(Login.this, "Login failed..", "Username/Password is incorrect", false);
//                    }
//                } else {
//                    // user didn't entered username or password
//                    // Show alert asking him to enter the details
//                    alert.showAlertDialog(Login.this, "Login failed..", "Please enter username and password", false);
//                }
//
//            }
        });

        final android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.drawer_item_menu_drawer);

//        result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .inflateMenu(R.menu.main2)
//                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
////                        if (drawerItem instanceof Nameable) {
////                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
////                        }
//                        FragmentManager manager = getSupportFragmentManager();
//                        FragmentTransaction transaction = manager.beginTransaction();
//                        switch (position) {
//                            case 0:
//                                Intent intent = new Intent(getApplicationContext(), Login.class);
//                                startActivity(intent);
//
//
//
//                                break;
//
//                        }
//                        return false;
//                    }
//                }).build();


    }


}
