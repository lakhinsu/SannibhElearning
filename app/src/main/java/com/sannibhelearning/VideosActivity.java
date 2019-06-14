package com.sannibhelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VideosActivity extends AppCompatActivity {

    TextView modulenameview;
    Toolbar toolbar;
    ListView video_list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        Intent intent = getIntent();

        String coursename = intent.getStringExtra("coursename");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.videostoolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(coursename);

        String modulename = intent.getStringExtra("modulename");

        modulenameview = (TextView) findViewById(R.id.modulename);
        modulenameview.setText(modulename);

        video_list_view = (ListView) findViewById(R.id.videolistid);
        List<String> videos = new ArrayList<String>();
        videos.add("Syntax");
        videos.add("Logic");

        ArrayAdapter<String> VideoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, videos){
            @Override
            public View getView(int position, View convertView,ViewGroup parent) {


                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                tv.setPadding(30,50,0,50);
                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);

                // Return the view
                return view;

            }
        };



        video_list_view.setAdapter(VideoAdapter);




    }
}
