package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.R;

import java.util.List;


public class activityAssessments extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
        //Creating and setting new recyclerview to assessmentRecycler
        RecyclerView recyclerView = findViewById(R.id.assessmentRecycler);
        //Creating repo
        Repository repo = new Repository(getApplication());
        //Creating assessmentList assigned using getAllAssessments
        List<Assessment> assessmentList = repo.getmAllAssessments();
        //Creating adapter
        final AssessmentAdapter assessmentAdapter = new AssessmentAdapter(this);
        //setting recyclerview with data populated into assessmentAdapter created above
        recyclerView.setAdapter(assessmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        assessmentAdapter.setmAssessment(assessmentList);
    }


    public void addAssessment(View V){
        Intent intent = new Intent(activityAssessments.this, activityAddAssessment.class);
        startActivity(intent);
    }

    public void back(View V){
        Intent intent = new Intent(activityAssessments.this, activityCourses.class);
        startActivity(intent);
    }
}
