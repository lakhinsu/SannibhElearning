package com.sannibhelearning;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VideosQuery extends AsyncTask<String , Void, String> {



    Connection con;
    Context mContext;
    OnVideosListLoad mCallback;
    ResultSet resultSet;

    String videos[][];


    public VideosQuery(Context context){
        mContext=context;
        mCallback=(OnVideosListLoad) context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionString = "jdbc:mysql://192.168.0.4:3306/" + "elearn" + "?user=" + "elearn" + "&password=" + "batman" + "&useUnicode=true&characterEncoding=UTF-8&";
            Connection con = DriverManager.getConnection(connectionString);


            String query1="select courseid from course where coursename='"+strings[0]+"';";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(query1);
            resultSet.first();
            String courseid=resultSet.getString("courseid");

            Log.d("videosquery","course id"+courseid);

            String query2="select moduleid from module where name='"+strings[1]+"';";
            resultSet=stmt.executeQuery(query2);
            resultSet.first();
            String moduleid=resultSet.getString("moduleid");

            Log.d("videosquery","module id"+moduleid);

            String query3="select name,path,duration from video where courseid="+courseid+" and moduleid="+moduleid+";";
            resultSet=stmt.executeQuery(query3);

            int size=0;
            while(resultSet.next()){
                size++;
            }
            resultSet.beforeFirst();

            videos=new String[size][3];
            int i=0;
            while(resultSet.next()){
                videos[i][0]=resultSet.getString("name");
                videos[i][1]=resultSet.getString("path");
                videos[i][2]=resultSet.getString("duration");

                i++;
            }



        }catch (Exception e){
            e.printStackTrace();
        }




        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mCallback.getVideosList(videos);
    }
}
