package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.R;
import com.zybooks.wguc196jmancil.UI.activityCourses;


public class activityAddCourse extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
    }


    public void backToCourses(View V){
        Intent intent = new Intent(activityAddCourse.this, activityCourses.class);
        startActivity(intent);
    }

    public void assessment(View V){
        Intent intent = new Intent(activityAddCourse.this, activityAssessments.class);
        startActivity(intent);
    }
}
