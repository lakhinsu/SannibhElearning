package com.sannibhelearning;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
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

public class Tab1 extends ListFragment implements AdapterView.OnItemClickListener,OnCoursesload {

    SharedPreferences preferences;
    ArrayList<String> mycourses;
    FloatingGroupExpandableListView myList;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);
        myList = (FloatingGroupExpandableListView) view.findViewById(android.R.id.list);

        preferences = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String email = preferences.getString("email", "0");

        MyCoursesQuery myCoursesQuery=new MyCoursesQuery(getActivity());
        myCoursesQuery.execute(email);


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

    @Override
    public void onCoursesLoad(ResultSet result) {
        try {
            while (result.next()) {
                mycourses.add(result.getString("coursename"));
            }
            BaseExpandableListAdapter myAdapter = new MyAdapter(getContext(),mycourses);
            WrapperExpandableListAdapter wrapperAdapter = new WrapperExpandableListAdapter(myAdapter);
            myList.setAdapter(wrapperAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}