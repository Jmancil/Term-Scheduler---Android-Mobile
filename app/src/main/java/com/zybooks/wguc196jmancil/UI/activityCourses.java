package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.UI.activityAddCourse;
import com.zybooks.wguc196jmancil.R;
import com.zybooks.wguc196jmancil.UI.activityTerms;

public class activityCourses extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
    }


    public void backToTerm(View V){
        Intent intent = new Intent(activityCourses.this, activityTerms.class);
        startActivity(intent);
    }

    public void addCourse(View V){
        Intent intent = new Intent(activityCourses.this, activityAddCourse.class);
        startActivity(intent);
    }
}