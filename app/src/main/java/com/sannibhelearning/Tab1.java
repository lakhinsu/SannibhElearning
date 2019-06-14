package com.sannibhelearning;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.diegocarloslima.fgelv.lib.FloatingGroupExpandableListView;
import com.diegocarloslima.fgelv.lib.WrapperExpandableListAdapter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.sannibhelearning.MainActivity.MyPREFERENCES;

public class Tab1 extends ListFragment implements AdapterView.OnItemClickListener{

    SharedPreferences preferences;
   static  ArrayList<String> mycourses;
    static FloatingGroupExpandableListView myList;
    static WrapperExpandableListAdapter wrapperAdapter;
    //public static boolean flag=false;
    static CommonActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);
        myList = (FloatingGroupExpandableListView) view.findViewById(android.R.id.list);
      //  myList.setAdapter(wrapperAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();

    }

    public static void setAdatper(WrapperExpandableListAdapter wrapperAdapter){

        //wrapperAdapter=activity.getCourses();
        myList.setAdapter(wrapperAdapter);
        Log.d("sqllak","length:"+wrapperAdapter.getChildrenCount(0));

       // myList.refreshDrawableState();

    }


}