package com.sannibhelearning;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class CommonActivity extends AppCompatActivity {
    private TabHost tabHost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        TabHost.TabSpec mycoursespec=tabHost.newTabSpec("mycourse");
        Intent mycourseintent=new Intent(this,MyCourses.class);
        mycoursespec.setContent(mycourseintent);
        TabHost.TabSpec allcoursespec=tabHost.newTabSpec("allcourse");
        Intent allcourseintent=new Intent(this,AllCourses.class);
        allcoursespec.setContent(mycourseintent);
        tabHost.addTab(mycoursespec);
        tabHost.addTab(allcoursespec);
    }
}
