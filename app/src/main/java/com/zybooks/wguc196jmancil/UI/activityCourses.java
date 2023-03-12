package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.Entity.Term;
import com.zybooks.wguc196jmancil.UI.activityAddCourse;
import com.zybooks.wguc196jmancil.R;
import com.zybooks.wguc196jmancil.UI.activityTerms;

import java.util.List;

public class activityCourses extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        //Connecting recyclerview object with id from UI
        RecyclerView recyclerView = findViewById(R.id.courseRecycler);
        //Creating repository
        Repository repo = new Repository(getApplication());
        //Creating courseList assigned using getAllCourse method
        List<Course> courseList = repo.getmAllCourses();
        //Creating new CourseAdapter
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        //Setting recyclerview with data populated into courseAdapter created above
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setCourse(courseList);

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