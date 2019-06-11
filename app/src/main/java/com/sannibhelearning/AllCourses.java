package com.sannibhelearning;

import android.app.ListActivity;
import android.os.Bundle;

public class AllCourses extends ListActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allcourseslistview);
    }
}
