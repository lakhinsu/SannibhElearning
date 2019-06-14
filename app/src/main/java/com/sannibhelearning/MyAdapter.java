package com.sannibhelearning;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseExpandableListAdapter {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

   // ArrayList<String> mGroups;

    private String[] mGroups ;/*= {
            "Course 1",
            "Course 2",
            "Course 3",
            "Course 4",
            "Course 5",
            "Course 6",
            "Course 7",
            "Course 8",
            "Course 9",
    };*/

    private final int[] mGroupDrawables = {
            R.drawable.ic_profile_icon,
            R.drawable.ic_profile_icon,
            R.drawable.ic_profile_icon,
            R.drawable.ic_profile_icon,
            R.drawable.ic_profile_icon,
            R.drawable.ic_profile_icon,
            R.drawable.ic_profile_icon,
            R.drawable.ic_profile_icon,
            R.drawable.ic_profile_icon
    };

    private final String[][] mChilds = {
            {"Modules",},
            {"Modules",},
            {"Modules",},
            {"Modules",},
            {"Modules",},
            {"Modules",},
            {"Modules",},
            {"Modules",},
            {"Modules",},

    };

    public MyAdapter(Context context, ArrayList<String> courses)  {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      //  mGroups=courses;
        Log.d("sqllak","courses:"+courses.size());
        mGroups=new String[courses.size()];
        for(int i=0;i<courses.size();i++){
            mGroups[i]=courses.get(i);
        }
        //mGroups=(String[]) courses.toArray();
        Log.d("sqllak","array:"+mGroups[0]);
    }

    @Override
    public int getGroupCount() {
        return mGroups.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups[groupPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.sample_activity_list_group_item, parent, false);
        }

        final ImageView image = (ImageView) convertView.findViewById(R.id.sample_activity_list_group_item_image);
        image.setImageResource(mGroupDrawables[groupPosition]);

        final TextView text = (TextView) convertView.findViewById(R.id.sample_activity_list_group_item_text);
        text.setText(mGroups[groupPosition]);

        final ImageView expandedImage = (ImageView) convertView.findViewById(R.id.sample_activity_list_group_expanded_image);
        final int resId = isExpanded ? R.drawable.ic_down_arrow : R.drawable.ic_down_arrow;
        expandedImage.setImageResource(resId);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChilds[groupPosition].length;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChilds[groupPosition][childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.sample_activity_list_child_item, parent, false);
        }

        final TextView text = (TextView) convertView.findViewById(R.id.sample_activity_list_child_item_text);
        text.setText(mChilds[groupPosition][childPosition]);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}
