package com.sannibhelearning;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;


    public static final String MyPREFERENCES = "UserPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.TestView);

        preferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String email = preferences.getString("email", "0");
        String password = preferences.getString("password", "0");
        if (email == "0" && password == "0") {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            text.setText("" + email + password);
            Toast.makeText(this, "" + email + "" + password, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),GeneralActivity.class);
            startActivity(i);
        }


    }
}

