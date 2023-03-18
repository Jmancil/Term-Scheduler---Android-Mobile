package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.R;


public class activityAddAssessment extends AppCompatActivity {
    //EditText creating for lin to activityAddAssessment
    EditText editName;
    EditText editPa;
    EditText start;
    EditText end;
    EditText id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_add_assessment);

        //Connecting EditText items to view handlers
        editName = findViewById(R.id.editName);
        start = findViewById(R.id.editStart);
        end = findViewById(R.id.editEnd);
        id = findViewById(R.id.editId);
    }

    public void saveAssessment(View view){
        //Creates repo
        Repository repo = new Repository(getApplication());
        //creates new assessment object
        Assessment assessment = new Assessment(start.getText().toString(),
                end.getText().toString(), editName.getText().toString(), Integer.parseInt(id.getText().toString()));
        //Inserts assessment
        repo.insertAssessment(assessment);
        //Intent creation for moving screens
        Intent intent = new Intent(activityAddAssessment.this, activityAssessments.class);
        //Starts intent
        startActivity(intent);

    }


    public void backToAssessments(View V){
        Intent intent = new Intent(activityAddAssessment.this, activityAssessments.class);
        startActivity(intent);
    }
}
