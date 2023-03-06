package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.R;


public class activityAssessments extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
    }


    public void addAssessment(View V){
        Intent intent = new Intent(activityAssessments.this, activityAddAssessment.class);
        startActivity(intent);
    }

    public void back(View V){
        Intent intent = new Intent(activityAssessments.this, activityAddCourse.class);
        startActivity(intent);
    }
}
