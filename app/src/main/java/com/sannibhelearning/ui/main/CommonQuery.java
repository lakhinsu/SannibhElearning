package com.sannibhelearning.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class CommonQuery extends AppCompatActivity {

    Intent h=getIntent();
    String email=h.getStringExtra("Email");
    String myCourses="SELECT course.coursename,course.description,course.image FROM usertocourse INNER JOIN course ON course.courseid=usertocourse.courseid where usertocourse.userid=\""+email+"\";";
    
}
