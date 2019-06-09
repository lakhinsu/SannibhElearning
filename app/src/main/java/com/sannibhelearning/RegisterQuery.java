package com.sannibhelearning;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RegisterQuery extends AsyncTask<String , Void, String>

{
    Connection con;
    @Override
    protected String doInBackground(String ...params) {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionString = "jdbc:mysql://192.168.0.7:3306/" + "elearn" + "?user=" + "elearn" + "&password=" + "batman" + "&useUnicode=true&characterEncoding=UTF-8&";
            Connection con = DriverManager.getConnection(connectionString);

           // Toast.makeText(,"You Clicked Register",Toast.LENGTH_SHORT).show();
            Log.d("query","here");
            String email=params[0];
            String password=params[1];
            String fname=params[2];
            String lname=params[3];
            String occupation=params[4];

            String query = "{CALL register(?,?,?,?,?)}";
            CallableStatement stmt = con.prepareCall(query);

            stmt.setString(1,email);
            stmt.setString(2,password);
            stmt.setString(3,fname);
            stmt.setString(4,lname);
            stmt.setString(5,occupation);

            stmt.execute();
            // tv.setText(result);
        } catch (Exception e) {
            Log.d("query",e.getMessage());
            // tv.setText(e.toString());
        }
        return null;
    }
}