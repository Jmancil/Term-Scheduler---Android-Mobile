package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.UI.activityAddTerm;
import com.zybooks.wguc196jmancil.UI.activityCourses;
import com.zybooks.wguc196jmancil.R;


public class activityTerms extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
    }

    public void toAddTerm(View V){
        Intent intent = new Intent(activityTerms.this, activityAddTerm.class);
        startActivity(intent);
    }

    public void toCourseList(View V){
        Intent intent = new Intent(activityTerms.this, activityCourses.class);
        startActivity(intent);
    }
}
