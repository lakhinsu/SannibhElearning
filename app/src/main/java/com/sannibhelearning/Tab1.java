package com.sannibhelearning;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Tab1 extends Fragment {
    String[] values = new String[]{"India", "java", "c++", "Ad.Java", "Linux", "Unix"};
    ListView lv;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes


        return inflater.inflate(R.layout.tab1, container, false);
    }
}