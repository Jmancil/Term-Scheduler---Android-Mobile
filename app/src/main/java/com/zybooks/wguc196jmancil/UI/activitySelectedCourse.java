package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.R;

import java.util.List;

/*
Initializes data from selected course
 */
public class activitySelectedCourse extends AppCompatActivity{
    //EditText creation for linking to activitySelectedCourse
    EditText editTitle;
    EditText editStart;
    EditText editEnd;
    EditText editStatus;
    EditText editName;
    EditText editPhone;
    EditText editEmail;
    EditText editTermID;
    EditText editCourseID;

    //Variable decs for assigning .set Values
    String title;
    String start;
    String end;
    String status;
    String name;
    String phone;
    String email;
    int termid;
    int courseid;

    //Method for assigning clicked Course values of item clicked
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Setting view to activity_add_course screen
        setContentView(R.layout.activity_selected_course);
        //Connecting EditText objects to selected Course view handlers
        editTitle = findViewById(R.id.editCourseTitle);
        editStart = findViewById(R.id.editStartDate);
        editEnd  = findViewById(R.id.editEndDate);
        editStatus = findViewById(R.id.editStatus);
        editName = findViewById(R.id.editCIName);
        editPhone = findViewById(R.id.editCIPhone);
        editEmail = findViewById(R.id.editCIEmail);
        editTermID = findViewById(R.id.editTermID);
        editCourseID = findViewById(R.id.editCourseId);

        //Variables declared above used here for assignment to values
        title = getIntent().getStringExtra("title");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        status = getIntent().getStringExtra("status");
        name = getIntent().getStringExtra("name");
        phone = getIntent().getStringExtra("phone");
        email = getIntent().getStringExtra("email");
        termid = getIntent().getIntExtra("termId", -1);
        courseid = getIntent().getIntExtra("courseId", -1);
        //.settext linking previous assigned values from DB to add course activity interface
        editTitle.setText(title);
        editStart.setText(start);
        editEnd.setText(end);
        editStatus.setText(status);
        editName.setText(name);
        editPhone.setText(phone);
        editEmail.setText(email);
        editTermID.setText(Integer.toString(termid));
        editCourseID.setText(Integer.toString(courseid));

        //RecyclerView to populate assessments for selected course
        RecyclerView recyclerView = findViewById(R.id.assessmentRecycler);
        Repository repo = new Repository(getApplication());
        List<Assessment> assessments = repo.getmAllAssessments();
        final AssessmentAdapter aAdapter = new AssessmentAdapter(this);
        recyclerView.setAdapter(aAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        aAdapter.setmAssessment(assessments);
    }

    public void backToCourses(View view){
        Intent intent = new Intent(activitySelectedCourse.this, activityCourses.class);
        startActivity(intent);
    }
//saves course
    public void saveCourse(View view){
        //Creates new repo to start getApp
        Repository repo = new Repository(getApplication());
        //Parses data from Interface to course object
        Course course = new Course(Integer.parseInt(editCourseID.getText().toString()),
                editStart.getText().toString(), editEnd.getText().toString(), editStatus.getText().toString(),
                editName.getText().toString(), editPhone.getText().toString(), editEmail.getText().toString(),
                editTitle.getText().toString(),Integer.parseInt(editTermID.getText().toString()));
        //Inserts course into repo
        repo.updateCourse(course);
        //Intent creation to moves screens
        Intent intent = new Intent(activitySelectedCourse.this, activityCourses.class);
        startActivity(intent);
    }

    public void deleteCourse(View view){
        Repository repository = new Repository(getApplication());
        Course course = new Course(Integer.parseInt(editCourseID.getText().toString()),
                editStart.getText().toString(), editEnd.getText().toString(), editStatus.getText().toString(),
                editName.getText().toString(), editPhone.getText().toString(), editEmail.getText().toString(),
                editTitle.getText().toString(),Integer.parseInt(editTermID.getText().toString()));
        repository.deleteCourse(course);
        Intent intent = new Intent(activitySelectedCourse.this, activityCourses.class);
        startActivity(intent);
    }

    public void noteButton(View view){
        Intent intent = new Intent(activitySelectedCourse.this, activityNote.class);
        startActivity(intent);
    }

    public void assessment(View V){
        Intent intent = new Intent(activitySelectedCourse.this, activityAssessments.class);
        startActivity(intent);
    }
}
