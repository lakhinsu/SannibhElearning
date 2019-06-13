package com.sannibhelearning;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    SharedPreferences preferences;
    public static final String MyPREFERENCES = "UserPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView username= (TextView)findViewById(R.id.profilename);

        preferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String email = preferences.getString("email", "0");
        String password = preferences.getString("password", "0");
        String firstname = preferences.getString("fname","0");
        String lastname= preferences.getString("lname","0");
        username.setText(firstname+" "+lastname);

    }
}
