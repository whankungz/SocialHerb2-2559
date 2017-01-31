//package com.example.whankung.socialherb.activity;
//
//import android.content.Intent;
//import android.content.res.Configuration;
//import android.content.res.TypedArray;
//import android.graphics.Color;
//import android.graphics.Typeface;
//import android.os.Bundle;
//import android.support.annotation.IdRes;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.OnScrollListener;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.AbsListView;
//import android.widget.AdapterView;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.example.whankung.socialherb.R;
//
//import com.example.whankung.socialherb.fragment.Article.MainArticle;
//import com.example.whankung.socialherb.fragment.Disease.MainDisease;
//import com.example.whankung.socialherb.fragment.Favorite.MainFavorite;
//import com.example.whankung.socialherb.fragment.Herb.MainHerb;
//import com.example.whankung.socialherb.view.Singleton;
//import com.mikepenz.materialdrawer.Drawer;
//import com.roughike.bottombar.BottomBar;
//import com.roughike.bottombar.OnTabSelectListener;
//
//import java.util.ArrayList;
//
///**
// * Created by Whankung on 16/1/2560.
// */
//
//public class Menu extends AppCompatActivity {
//    private Typeface font;
//    private TextView tv;
//
//    private Drawer result = null;
//    SessionManagement session;
//
//
//    // Alert Dialog Manager
//    AlertDialogManager alert = new AlertDialogManager();
//
//    private DrawerLayout mDrawerLayout;
//    private ListView mDrawerList;
//    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
//    // nav drawer title
//    private CharSequence mDrawerTitle;
//    // used to store app title
//    private CharSequence mTitle;
//    // slide menu items
//    private String[] navMenuTitles;
//    private TypedArray navMenuIcons;
//    private ArrayList<NavDrawerItem> navDrawerItems;
//    private NavDrawerListAdapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.menu);
//
//        setView();
//        setBottomBar();
//     setMenu();
//
//
//    }
//
//
//    private void setMenu() {
//        // setContentView(R.layout.menu2);
//        mTitle = mDrawerTitle = getTitle();
//
//        // load slide menu items
//        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
//
//        // nav drawer icons from resources
//        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);
//
//
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.drawer);
//
//        navDrawerItems = new ArrayList<NavDrawerItem>();
//
//        // adding nav drawer items to array
//        // Home
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0]));
//        navMenuIcons.getResourceId(0,0);
//
//        // Find People
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1]));
//        // Photos
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2]));
//        // Communities, Will add a counter here
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3]));
//        // Pages
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4]));
//        // What's hot, We  will add a counter here
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5]));
//
//
//        // Recycle the typed array
//        navMenuIcons.recycle();
//
//        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
//
//        // setting the nav drawer list adapter
//        adapter = new NavDrawerListAdapter(getApplicationContext(),
//                navDrawerItems);
//        mDrawerList.setAdapter(adapter);
//
//        // enabling action bar app icon and behaving it as toggle button
//        assert getSupportActionBar()!=null;
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//
//
//
//
//
//
//
//
//
//
//        mDrawerToggle = new ActionBarDrawerToggle (this, mDrawerLayout,
//                // R.drawable.ic_drawer, //nav menu toggle icon
//                R.string.app_name, // nav drawer open - description for accessibility
//                R.string.app_name // nav drawer close - description for accessibility
//        ) {
//
//            public void onDrawerClosed(View view) {
//                getSupportActionBar().setTitle(mTitle);
//                // calling onPrepareOptionsMenu() to show action bar icons
//
//                invalidateOptionsMenu();
//                getSupportActionBar().show();
//            }
//
//            public void onDrawerOpened(View drawerView) {
//                getSupportActionBar().setTitle(mDrawerTitle);
//                // calling onPrepareOptionsMenu() to hide action bar icons
//                invalidateOptionsMenu();
//                getSupportActionBar().hide();
//
//
//            }
//        };
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//
////
////        if (savedInstanceState == null) {
////            // on first time display view for first nav item
////            displayView(0);
////        }
//    }
//
//    /**
//     * Slide menu item click listener
//     */
//    private class SlideMenuClickListener implements
//            ListView.OnItemClickListener {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position,
//                                long id) {
//            // display view for selected nav drawer item
//
//            displayView(position);
//
//        }
//    }
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        getMenuInflater().inflate(R.menu.menu_main, menu);
////        return true;
////    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // toggle nav drawer on selecting action bar app icon/title
//        if (mDrawerToggle.onOptionsItemSelected(item)) {
//
//            return true;
//        }
//        // Handle action bar actions click
//        switch (item.getItemId()) {
//            case R.id.action_login:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        // Sync the toggle state after onRestoreInstanceState has occurred.
//        mDrawerToggle.syncState();
//
//
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        mDrawerToggle.onConfigurationChanged(newConfig);
//
//    }
//
//    /***
//     * Called when invalidateOptionsMenu() is triggered
//     */
//
////    public boolean onPrepareOptionsMenu(Menu menu) {
////        // if nav drawer is opened, hide the action items
////        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
////       menu.findItem(R.id.action_login).setVisible(!drawerOpen);
////        return super.onPrepareOptionsMenu((android.view.Menu) menu);
////    }
//
//    /**
//     * Diplaying fragment view for selected nav drawer list item
//     */
//    private void displayView(int position) {
//        // update the main content by replacing fragments
//        Fragment fragment = null;
//
//        switch (position) {
//            case 0:
//
//                fragment = new LoginFragment();
//
//                break;
//            case 1:
//                fragment = new StartApp();
//
//                break;
//            case 2:
//                fragment = new InfoFragment();
//
//                break;
//            case 3:
//                fragment = new FoodFragment();
//
//                break;
//            case 4:
//                fragment = new ShareFragment();
//
//                break;
//            case 5:
//                fragment = new ContectFragment();
//
//                break;
//
//            default:
//                break;
//        }
////        myFragment.setOnEventListener(new MyFragment.OnEventListener() {
////            @Override
////            public void hideToolbar() {
////
////                getSupportActionBar().hide();
////            }
////        });
//
//        if (fragment != null) {
//            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction()
//                    .replace(R.id.container, fragment).commit();
//
//
//            // update selected item and title, then close the drawer
//            mDrawerList.setItemChecked(position, true);
//            mDrawerList.setSelection(position);
//            setTitle(navMenuTitles[position]);
//            mDrawerLayout.closeDrawer(mDrawerList);
//        } else {
//            // error in creating fragment
//            Log.e("MainActivity", "Error in creating fragment");
//        }
//    }
//
//
//
//    private void setView() {
//
//
//        session = new SessionManagement(getApplicationContext());
//        tv = (TextView) findViewById(R.id.toolbar_title);
//
//        Singleton.getInstance().setFirstOpenApp(true);
//
////                เปลี่ยน font
//        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
//        //ประกาศตัวปุ่มย้อนกลับของเรา ผูกตัวแปรไว้
////        ImageView img = (ImageView) findViewById(R.id.action);
////        img.setVisibility(View.VISIBLE);
////        img.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                //กลับไปยังหน้าเลือก ถาคของเรา
////                Intent intent = new Intent(getApplicationContext(), Login.class);
////                startActivity(intent);
////
////            }
////        });
//
//
//        // Handle Toolbar
//        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle(R.string.drawer_item_menu_drawer);
//
//
//
////        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////        getActionBar().setHomeButtonEnabled(true);
////        getActionBar().setHomeAsUpIndicator(R.d);
//
//
////....................    profile
////        ProfileDrawerItem profileMain = new ProfileDrawerItem();
////        AccountHeader accountHeader = new AccountHeaderBuilder()
////                .withActivity(this)
////                .addProfiles(
////                        profileMain.withName("login")
////                )
////
////
////        .withTextColor(getResources().getColor(R.color.md_dark_appbar))
////
////                .withNameTypeface(Typeface.createFromAsset(getAssets(), "tmedium.ttf"))
////                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
////                    @Override
////                    public boolean onProfileChanged(View view, IProfile iProfile, boolean b) {
////                        if (b == true) {
////                            Intent intent = new Intent(getApplicationContext(), Login.class);
////                            startActivity(intent);
////                        } else {
////
////                        }
////                        return false;
////                    }
////                })
////                .withProfileImagesClickable(true)
////                .withSelectionListEnabled(false)
////                .build();
////
////        session.checkLogin();
////
////        // get user data from session
////        HashMap<String, String> user = session.getUserDetails();
////
////        // name
////        String name = user.get(SessionManagement.KEY_NAME);
////
////        // email
////        String email = user.get(SessionManagement.KEY_EMAIL);
////        // displaying user data
////        accountHeader.equals(Html.fromHtml("Name: <b>" + name + "</b>"));
////
////        accountHeader.equals(Html.fromHtml("Email: <b>" + email + "</b>"));
//
//
////        final Drawer drawer = new DrawerBuilder()
////                .withActivity(this)
////                .withToolbar(toolbar)
////                .withActionBarDrawerToggle(true)
//////                .withAccountHeader(accountHeader)
////                .withCloseOnClick(true)
////                .addDrawerItems(
////                        new PrimaryDrawerItem()
////                                .withIcon(FontAwesome.Icon.faw_sign_in)
////                                .withName(String.valueOf(Html.fromHtml("ล็อกอิน")))
////                                .withIconColor(getResources().getColor(R.color.md_dark_appbar))
////                                .withIdentifier(0)
////                                .withSelectable(false),
////                        new PrimaryDrawerItem()
////                                .withIcon(FontAwesome.Icon.faw_home)
////                                .withName(String.valueOf(Html.fromHtml("หน้าแรก")))
////                                .withIconColor(getResources().getColor(R.color.md_dark_appbar))
////                                .withIdentifier(0)
////                                .withSelectable(false),
////
////                        new PrimaryDrawerItem()
////                                .withIcon(FontAwesome.Icon.faw_list_alt)
////                                .withName("Infographic")
////                                .withIconColor(getResources().getColor(R.color.md_dark_appbar))
////                                .withIdentifier(0)
////                                .withSelectable(false),
////                        new PrimaryDrawerItem()
////                                .withIcon(FontAwesome.Icon.faw_spoon)
////                                .withName("อาหารเพื่อสุขภาพ")
////                                .withIconColor(getResources().getColor(R.color.md_dark_appbar))
////                                .withIdentifier(0)
////                                .withSelectable(false),
////                        new PrimaryDrawerItem()
////                                .withIcon(FontAwesome.Icon.faw_university)
////                                .withName("หน่วยงานที่เกี่ยวข้อง")
////                                .withIconColor(getResources().getColor(R.color.md_dark_appbar))
////                                .withIdentifier(0)
////                                .withSelectable(false),
////
////                        new PrimaryDrawerItem()
////                                .withIcon(FontAwesome.Icon.faw_share_alt)
////                                .withName("แชร์")
////                                .withIconColor(getResources().getColor(R.color.md_dark_appbar))
////                                .withIdentifier(0)
////                                .withSelectable(false),
////
////
////                        new PrimaryDrawerItem()
////                                .withSelectable(false)
////                                .withIconColor(getResources().getColor(R.color.md_white_1000))
////                                .withIdentifier(3),
////                        new PrimaryDrawerItem()
////                                .withSelectable(false)
////                                .withIconColor(getResources().getColor(R.color.md_white_1000))
////                                .withIdentifier(3),
////
////
////                        new DividerDrawerItem(),
////
////
////
////
////
////                        new PrimaryDrawerItem()
////                                .withIcon(FontAwesome.Icon.faw_share)
////                                .withName("Invite")
////                                .withSelectable(false)
////                                .withIconColor(getResources().getColor(R.color.md_dark_appbar))
////                                .withIdentifier(3),
////                        new PrimaryDrawerItem()
////                                .withIcon(FontAwesome.Icon.faw_sign_out)
////                                .withName("ออกจากระบบ")
////                                .withSelectable(false)
////                                .withIconColor(getResources().getColor(R.color.md_dark_appbar))
////                                .withIdentifier(4)
////                )
////                .withSelectedItem(-1)
////                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
////                                                   @Override
////                                                   public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
////                                                       if (drawerItem instanceof Nameable) {
////                                                           Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
////                                                       }
////                                                       FragmentManager manager = getSupportFragmentManager();
////                                                       FragmentTransaction transaction = manager.beginTransaction();
////                                                       switch (position) {
////                                                           case 0:
////                                                               Intent intent = new Intent(getApplicationContext(), Login.class);
////                                                               startActivity(intent);
////
////                                                               break;
////                                                           case 1:
////
////                                                               intent = new Intent(getApplicationContext(), StartApp2.class);
////                                                               startActivity(intent);
////                                                               break;
////                                                           case 2:
////                                                               tv.setText("Infoghaphic");
////                                                               intent = new Intent(getApplicationContext(), MainInfo.class);
////                                                               startActivity(intent);
////
////                                                               break;
////
////                                                           case 3:
////                                                               tv.setText("logout");
////                                                               session = new SessionManagement(getApplicationContext());
////                                                               intent = new Intent(getApplicationContext(), MainInfo.class);
////                                                               startActivity(intent);
////
////                                                               break;
////                                                       }
////
////                                                       return false;
////                                                   }
////                                               }
////                ).build();
////
////
//    }
//
////        //Create the drawer
////        result = new DrawerBuilder()
////                .withActivity(this)
////                .withToolbar(toolbar)
////                .withAccountHeader(accountHeader)
////                .withHeaderDivider(false)
////                // .inflateMenu(R.menu.main)
////                .addDrawerItems(
////                        new PrimaryDrawerItem().withName("ล็อคอิน").withIcon(R.drawable.ic_login),
////                        new PrimaryDrawerItem().withName(R.string.drawer_item_free_play).withIcon(FontAwesome.Icon.faw_gamepad),
////                        new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withIcon(FontAwesome.Icon.faw_eye),
////                        new SectionDrawerItem().withName(R.string.drawer_item_section_header),
////                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog),
////                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_question).withEnabled(false),
////                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_github),
////                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_bullhorn)
////                )
//////                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//////                    @Override
//////                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
////////                        if (drawerItem instanceof Nameable) {
////////                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
////////                        }
//////                        FragmentManager manager = getSupportFragmentManager();
//////                        FragmentTransaction transaction = manager.beginTransaction();
//////                        switch (position) {
//////                            case 0:
//////                                Intent intent = new Intent(getApplicationContext(), Login.class);
//////                                startActivity(intent);
//////
//////
////////                                setContentView(R.layout.login);
//////                                break;
//////                            case 1:
////////                                setContentView(R.layout.activity_start2);
//////                                intent = new Intent(getApplicationContext(), StartApp2.class);
//////                                startActivity(intent);
//////                                break;
//////                            case 2:
//////                                tv.setText("Infoghaphic");
//////                                intent = new Intent(getApplicationContext(), MainInfo.class);
//////                                startActivity(intent);
//////
//////                                break;
//////
//////                            case 3:
//////                                tv.setText("logout");
//////                                session = new SessionManagement(getApplicationContext());
//////                                intent = new Intent(getApplicationContext(), MainInfo.class);
//////                                startActivity(intent);
//////
//////
//////                                break;
//////                        }
//////
//////                        return false;
////
////                .build();
////
////
////    }
////
//////                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//////                    @Override
//////                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
////////                        if (drawerItem instanceof Nameable) {
////////                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
////////                        }
//////                        FragmentManager manager = getSupportFragmentManager();
//////                        FragmentTransaction transaction = manager.beginTransaction();
//////                        switch (position) {
//////                            case 0:
//////                                Intent intent = new Intent(getApplicationContext(), Login.class);
//////                                startActivity(intent);
//////
//////
//////
////////                                setContentView(R.layout.login);
//////                                break;
//////                            case 1:
////////                                setContentView(R.layout.activity_start2);
//////                                intent = new Intent(getApplicationContext(), StartApp2.class);
//////                                startActivity(intent);
//////                                break;
//////                            case 2:
//////                                tv.setText("Infoghaphic");
//////                                intent = new Intent(getApplicationContext(), MainInfo.class);
//////                                startActivity(intent);
//////
//////                                break;
//////
//////                            case 3:
//////                                tv.setText("logout");
//////                                session = new SessionManagement(getApplicationContext());
//////                                intent = new Intent(getApplicationContext(), MainInfo.class);
//////                                startActivity(intent);
//////
//////
//////                                break;
////////                            case 2:
////////                                tv.setText("อาการ/โรค");
////////                                transaction.replace(R.id.frgMain, new MainDisease());
////////                                transaction.commit();
////////                                break;
////////                            case 3:
////////                                tv.setText("บทความ");
////////                                transaction.replace(R.id.frgMain, new MainArticle());
////////                                transaction.commit();
////////                                break;
////////                            case 4:
////////                                tv.setText("รายการโปรด");
////////                                transaction.replace(R.id.frgMain, new MainFavorite());
////////                                transaction.commit();
////////                                break;
////////                            case 5:
////////                                tv.setText("Infoghaphic");
////////                                transaction.replace(R.id.frgMain, new MainInfo());
////////                                transaction.commit();
////////                                break;
//////
//////                        }
////////                        if (drawerItem instanceof Nameable) {
////////
////////                            Intent intent = new Intent(getApplicationContext(), Login.class);
////////                            startActivity(intent);
////////
////////                        }else if (drawerItem instanceof Nameable){
////////
////////                                Intent intent2 = new Intent(getApplicationContext(), MainHerb.class);
////////                                startActivity(intent2);
////////
////////                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
////////
////////
////////
////////
////////                        }
//////
//////                        return false;
//////                    }
//////                }).build();
//////    }
//
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        switch (item.getItemId()) {
////            case android.R.id.home:
////                onBackPressed();
////                return true;
////
////            default:
////                return super.onOptionsItemSelected(item);
////        }
////    }
////
////    @Override
////    public void onBackPressed() {
////        //handle the back press :D close the drawer first and if the drawer is closed close the activity
////        if (result != null && result.isDrawerOpen()) {
////
////            result.closeDrawer();
////        } else {
////            super.onBackPressed();
////        }
////    }
//
//
////    public void setFragment(Fragment fragment) {
////        getSupportFragmentManager().beginTransaction()
////                .replace(R.id.frgMain, fragment)
////                .addToBackStack(null)
////                .commit();
////    }
//
//    private void setBottomBar() {
//
//        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
//
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//
////            ImageView img = (ImageView) findViewById(R.id.action);
//
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//
//                if (tabId == R.id.tab_herb) {
//
//                    // Toast.makeText(MainActivity.this,"tttt",Toast.LENGTH_LONG).show();
//                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.container, new MainHerb());
//                    transaction.commit();
//                  //  getSupportActionBar().setTitle("Hello");
//
//                    tv.setText("สมุนไพร");
////                    tv.setTextColor(Color.parseColor("#228B22"));
//                   tv.setTypeface(font);
//                    //   img.setVisibility(View.INVISIBLE);
//
//                } else if (tabId == R.id.tab_disease) {
//                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.container, new MainDisease());
//                    transaction.commit();
//                  tv.setText("อาการ/โรค");
////                    tv.setTextColor(Color.parseColor("#B22222"));
//                    // img.setVisibility(View.INVISIBLE);
//                } else if (tabId == R.id.tab_aritcle) {
//                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.container, new MainArticle());
//                    transaction.commit();
//                    tv.setText("บทความ");
////                    tv.setTextColor(Color.parseColor("#20B2AA"));
//                    //  img.setVisibility(View.INVISIBLE);
//                } else if (tabId == R.id.tab_favorite) {
//                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.container, new MainFavorite());
//                    transaction.commit();
//                    tv.setText("รายการโปรด");
////                    tv.setTextColor(Color.parseColor("#20B2AA"));
//                    // img.setVisibility(View.INVISIBLE);
//                }
//            }
//
//
//        });
//
//    }
//
//
//}