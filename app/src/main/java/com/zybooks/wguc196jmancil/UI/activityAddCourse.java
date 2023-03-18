package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.R;
import com.zybooks.wguc196jmancil.UI.activityCourses;


public class activityAddCourse extends AppCompatActivity {

    //EditText creation for linking to activityAddCourse
      EditText courseTitle;
      EditText courseStart;
      EditText courseEnd;
      EditText courseStatus;
      EditText courseName;
      EditText coursePhone;
      EditText courseEmail;
      EditText courseTermID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        //Connecting EditText objects to selected Course view handlers
        courseTitle = findViewById(R.id.editCourseTitle);
        courseStart = findViewById(R.id.editStartDate);
        courseEnd  = findViewById(R.id.editEndDate);
        courseStatus = findViewById(R.id.editStatus);
        courseName = findViewById(R.id.editCIName);
        coursePhone = findViewById(R.id.editCIPhone);
        courseEmail = findViewById(R.id.editCIEmail);
        courseTermID = findViewById(R.id.editTermID);
    }


    public void saveCourse(View view){
        //Creates repo
        Repository repo = new Repository(getApplication());
        //Creates new course object and parses data from interface
        Course course = new Course(Integer.parseInt(courseTermID.getText().toString()), courseTitle.getText().toString(),
                courseStart.getText().toString(), courseEnd.getText().toString(),courseStatus.getText().toString(),
                courseName.getText().toString(), coursePhone.getText().toString(), courseEmail.getText().toString());
        //Inserting course into repo created above
        repo.insertCourse(course);
        //Intent creation for moving screens
        Intent intent = new Intent(activityAddCourse.this, activityCourses.class);
        //Starting intent
        startActivity(intent);
    }

    public void backToCourses(View V){
        Intent intent = new Intent(activityAddCourse.this, activityCourses.class);
        startActivity(intent);
    }

    public void assessment(View V){
        Intent intent = new Intent(activityAddCourse.this, activityAssessments.class);
        startActivity(intent);
    }

    public void noteButton(View view){
        Intent intent = new Intent(activityAddCourse.this, activityNote.class);
        startActivity(intent);
    }
}
