package com.sannibhelearning;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.diegocarloslima.fgelv.lib.WrapperExpandableListAdapter;

import java.sql.ResultSet;
import java.util.ArrayList;

import static com.sannibhelearning.MainActivity.MyPREFERENCES;
import static com.sannibhelearning.Tab1.setAdatper;




public class CommonActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener,OnCoursesload {
    private TabHost tabHost;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;
    private boolean doubleBackToExitPressedOnce;

    private FloatingActionButton fab;


    SharedPreferences preferences;
    ArrayList<String> mycourses=new ArrayList<>();
    ArrayList<String> images=new ArrayList<>();

    WrapperExpandableListAdapter wrapperAdapter;

    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        preferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String email = preferences.getString("email", "0");

        init();

        MyCoursesQuery myCoursesQuery=new MyCoursesQuery(CommonActivity.this);
        myCoursesQuery.execute(email);





    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(), "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void init() {

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("My Courses"));
        tabLayout.addTab(tabLayout.newTab().setText("Courses"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Initializing view pager adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(viewPagerAdapter);

        //Adding onTabSelectedListener to swipe views
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Toast.makeText(this, "You Clicked On Profile button", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,Profile.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCoursesLoad(ResultSet result) {

        Log.d("sqllak","here2");
        try {
            mycourses=new ArrayList<>();
            images=new ArrayList<>();
            while (result.next()) {
                String coursename=result.getString("coursename");
                String image=result.getString("image");
                mycourses.add(coursename);
                images.add(image);
                Log.d("sqllak","Course:"+coursename+" Image:"+image);
            }
            Log.d("sqllak","arraylength"+mycourses.size());
            Log.d("sqllak","arraylist:"+mycourses.get(0));
            BaseExpandableListAdapter myAdapter = new MyAdapter(getApplicationContext(),mycourses,images);
            wrapperAdapter = new WrapperExpandableListAdapter(myAdapter);
            Log.d("sqllak","here4");
            Tab1.setAdatper(wrapperAdapter);

           // myList.setAdapter(wrapperAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public WrapperExpandableListAdapter getCourses(){

        return wrapperAdapter;
    }


}
