package com.zybooks.wguc196jmancil.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.Entity.Term;
import com.zybooks.wguc196jmancil.R;
import com.zybooks.wguc196jmancil.UI.activityTerms;

import java.util.zip.CheckedOutputStream;

import kotlinx.coroutines.channels.ProduceKt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.enterButton);

        //Creating a new Term to populate database
        Term term = new Term(1, "2/27/2023", "2/28/2023", "Testing");
        Repository repository = new Repository(getApplication());
        repository.insertTerm(term);
        Term term2 = new Term(2 ,"3/3/333", "3/3/3333", "Testing2");
//        repository.termDelete(term);
        repository.insertTerm(term2);

        //Creating a new Course to populate database
        Course course = new Course(1, "3/5/2023", "3/6/2023", "complete", "Joe", "570-884-000", "jmanc6@wgu.edu", "WGU C196", 1);
        repository.insertCourse(course);
        Course course2 = new Course(2, "3/3/333", "3/3/333", "In progress", "Joe", "564-123-1234", "jmanci6@wgu.edu", "WGU C196", 2);
        repository.insertCourse(course2);

        //Creating a new assessment to populate database
        Assessment assessment = new Assessment(1, "3/5/2023", "3/6/2023", "Assessment One", 1);
        repository.insertAssessment(assessment);
        Assessment assessment2 = new Assessment(2, "3/5/2023", "3/6/2023", "Assessment Two", 1);
        repository.insertAssessment(assessment2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activityTerms.class);
                startActivity(intent);
            }
        });
    }
}

