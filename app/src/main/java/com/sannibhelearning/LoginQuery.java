package com.sannibhelearning;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginQuery extends AsyncTask<String , Void, String>

{

    Connection con;
    Context mContext;
    TaskCompleted mCallback;


    public LoginQuery(Context context){
        mContext=context;
        mCallback=(TaskCompleted) context;
    }


    @Override
    protected String doInBackground(String ...params) {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionString = "jdbc:mysql://192.168.43.121:3306/" + "elearn" + "?user=" + "elearn" + "&password=" + "batman" + "&useUnicode=true&characterEncoding=UTF-8&";
            Connection con = DriverManager.getConnection(connectionString);

            // Toast.makeText(,"You Clicked Register",Toast.LENGTH_SHORT).show();
           // debug log Log.d("query","here");
            String email=params[0];
            String password=params[1];

            String query = "SELECT email,password FROM user WHERE email=\""+email+"\" AND password=\""+password+"\";";

            Log.d("query",""+query);

            Statement stmt = con.createStatement();
            ResultSet result=  stmt.executeQuery(query);



            if(result.next()) {
                String resultemail= result.getString("email");
                String resultpassword= result.getString("password");

                    Log.d("query", "" + resultemail);
                    Log.d("query", "" + resultpassword);
                    return "success";

            }
            else{
                Log.d("query","Invalid email or password");
                return "fail";
            }


            // tv.setText(result);
        } catch (Exception e) {
            Log.d("query",e.getMessage());

            // tv.setText(e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mCallback.onTaskComplete(s);

    }
}