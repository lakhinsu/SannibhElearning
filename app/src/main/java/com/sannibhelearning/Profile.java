package com.sannibhelearning;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    SharedPreferences preferences;
    public static final String MyPREFERENCES = "UserPrefs";

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView username = (TextView) findViewById(R.id.profilename);

        logout = (Button) findViewById(R.id.Logout);

        preferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String email = preferences.getString("email", "0");
        String password = preferences.getString("password", "0");
        String firstname = preferences.getString("fname", "0");
        String lastname = preferences.getString("lname", "0");
        username.setText(email);

        logout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor data = preferences.edit();

                data.putString("email", "0");
                data.putString("password", "0");
                data.putString("fname", "0");
                data.putString("lname", "0");

                data.commit();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                finishAffinity();

                startActivity(i);
            }
        });

    }
}
