package com.sannibhelearning;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    SharedPreferences preferences;
    String semail, spassword, sfname, slname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fName = (EditText) findViewById(R.id.Fname);
        final EditText email = (EditText) findViewById(R.id.Register_email);
        final EditText lName = (EditText) findViewById(R.id.Lname);
        final EditText password = (EditText) findViewById(R.id.Register_Password);
        final EditText occupation = (EditText) findViewById(R.id.Occupation);
        final EditText confirmpass = (EditText) findViewById(R.id.Register_Confirmpass);

        Button RegisterToDatabase = (Button) findViewById(R.id.Register);


        RegisterToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input validation code
                if (fName == null) {
                    Toast.makeText(getApplicationContext(), "First Name Cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (email == null) {
                    Toast.makeText(getApplicationContext(), "Email Cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (lName == null) {
                    Toast.makeText(getApplicationContext(), "Last Name Cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (occupation == null) {
                    Toast.makeText(getApplicationContext(), "Occupation Cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (password == null) {
                    Toast.makeText(getApplicationContext(), "Password Cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (confirmpass == null) {
                    Toast.makeText(getApplicationContext(), "Enter Confirm Password", Toast.LENGTH_SHORT).show();

                } else {
                    semail = email.getText().toString();
                    spassword = password.getText().toString();
                    sfname = fName.getText().toString();
                    slname = lName.getText().toString();
                    RegisterQuery q = new RegisterQuery();
                    preferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor data = preferences.edit();
                    data.putString("email", semail);
                    data.putString("password", spassword);
                    data.putString("fname", sfname);
                    data.putString("lname", slname);
                    data.commit();
                    q.execute(email.getText().toString(), password.getText().toString(), fName.getText().toString(), lName.getText().toString(), occupation.getText().toString());
                    Toast.makeText(getApplicationContext(), "You Clicked Register", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}
