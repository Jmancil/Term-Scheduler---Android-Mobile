package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.R;


public class activityAddAssessment extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_add_assessment);
    }


    public void backToAssessments(View V){
        Intent intent = new Intent(activityAddAssessment.this, activityAssessments.class);
        startActivity(intent);
    }
}
