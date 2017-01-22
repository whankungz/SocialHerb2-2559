package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;

import com.example.whankung.socialherb.fragment.Article.MainArticle;
import com.example.whankung.socialherb.fragment.Disease.MainDisease;
import com.example.whankung.socialherb.fragment.Favorite.MainFavorite;
import com.example.whankung.socialherb.fragment.Herb.MainHerb;
import com.example.whankung.socialherb.view.Singleton;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by Whankung on 16/1/2560.
 */

public class Menu extends AppCompatActivity {
    private Typeface font;
    private TextView tv;

    private Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setView();
        setBottomBar();

    }


    private void setView() {
        tv = (TextView) findViewById(R.id.toolbar_title);

        Singleton.getInstance().setFirstOpenApp(true);

//                เปลี่ยน font
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        //ประกาศตัวปุ่มย้อนกลับของเรา ผูกตัวแปรไว้
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


        // Handle Toolbar
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.drawer_item_menu_drawer);


        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .inflateMenu(R.menu.main)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//                        if (drawerItem instanceof Nameable) {
//                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
//                        }
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        switch (position) {
                            case 0:
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);

//                                setContentView(R.layout.login);
                                break;
                            case 1:
//                                setContentView(R.layout.activity_start2);
                                intent = new Intent(getApplicationContext(), StartApp2.class);
                                startActivity(intent);
                                break;
                            case 2:
                                tv.setText("Infoghaphic");
                                intent = new Intent(getApplicationContext(), MainInfo.class);
                                startActivity(intent);

                                break;

//                            case 2:
//                                tv.setText("อาการ/โรค");
//                                transaction.replace(R.id.frgMain, new MainDisease());
//                                transaction.commit();
//                                break;
//                            case 3:
//                                tv.setText("บทความ");
//                                transaction.replace(R.id.frgMain, new MainArticle());
//                                transaction.commit();
//                                break;
//                            case 4:
//                                tv.setText("รายการโปรด");
//                                transaction.replace(R.id.frgMain, new MainFavorite());
//                                transaction.commit();
//                                break;
//                            case 5:
//                                tv.setText("Infoghaphic");
//                                transaction.replace(R.id.frgMain, new MainInfo());
//                                transaction.commit();
//                                break;

                        }
//                        if (drawerItem instanceof Nameable) {
//
//                            Intent intent = new Intent(getApplicationContext(), Login.class);
//                            startActivity(intent);
//
//                        }else if (drawerItem instanceof Nameable){
//
//                                Intent intent2 = new Intent(getApplicationContext(), MainHerb.class);
//                                startActivity(intent2);
//
//                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
//
//
//
//
//                        }

                        return false;
                    }
                }).build();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frgMain, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void setBottomBar() {
        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

//            ImageView img = (ImageView) findViewById(R.id.action);

            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_herb) {

                    // Toast.makeText(MainActivity.this,"tttt",Toast.LENGTH_LONG).show();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainHerb());
                    transaction.commit();
                    tv.setText("สมุนไพร");
                    tv.setTextColor(Color.parseColor("#ffffff"));
                    tv.setTypeface(font);
                    //   img.setVisibility(View.INVISIBLE);

                } else if (tabId == R.id.tab_disease) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainDisease());
                    transaction.commit();
                    tv.setText("อาการ/โรค");
//                    tv.setTextColor(Color.parseColor("#B22222"));
                    // img.setVisibility(View.INVISIBLE);
                } else if (tabId == R.id.tab_aritcle) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainArticle());
                    transaction.commit();
                    tv.setText("บทความ");
//                    tv.setTextColor(Color.parseColor("#20B2AA"));
                    //  img.setVisibility(View.INVISIBLE);
                } else if (tabId == R.id.tab_favorite) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainFavorite());
                    transaction.commit();
                    tv.setText("รายการโปรด");
//                    tv.setTextColor(Color.parseColor("#20B2AA"));
                    // img.setVisibility(View.INVISIBLE);
                }
            }


        });

    }


}