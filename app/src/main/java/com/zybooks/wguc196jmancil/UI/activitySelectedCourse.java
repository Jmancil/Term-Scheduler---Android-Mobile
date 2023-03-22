package com.zybooks.wguc196jmancil.UI;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    EditText editDate;

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

    //for start date calendar
    DatePickerDialog.OnDateSetListener startDate;
    final Calendar myStartCalendar = Calendar.getInstance();
    String startFormat;
    SimpleDateFormat sdf;

    //for end date calendar
    DatePickerDialog.OnDateSetListener endDate;
    final Calendar myCalendarEnd = Calendar.getInstance();
    String endFormat;

    //Method for assigning clicked Course values of item clicked
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Setting view to activity_add_course screen
        setContentView(R.layout.activity_selected_course);

        //Info for date selector
        editDate = findViewById(R.id.editStartDate);
        String startFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(startFormat, Locale.US);
        //Click listener for date picker
        editDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Date date;
                String info = editDate.getText().toString();
                if(info.equals(""))info="02/10/22";
                try {
                    myStartCalendar.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(activitySelectedCourse.this, startDate, myStartCalendar.get(Calendar.YEAR),
                        myStartCalendar.get(Calendar.MONTH),
                        myStartCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        startDate = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth){
                myStartCalendar.set(Calendar.YEAR, year);
                myStartCalendar.set(Calendar.MONTH, monthOfYear);
                myStartCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();
            }
        };

        //Info for date selector
        editEnd = findViewById(R.id.editEndDate);
        String endFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(endFormat, Locale.US);
        //Click listener for date picker
        editEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Date date;
                String info = editEnd.getText().toString();
                if(info.equals(""))info="02/10/22";
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(activitySelectedCourse.this, endDate, myCalendarEnd.get(Calendar.YEAR),
                        myCalendarEnd.get(Calendar.MONTH),
                        myCalendarEnd.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        endDate = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth){
                myCalendarEnd.set(Calendar.YEAR, year);
                myCalendarEnd.set(Calendar.MONTH, monthOfYear);
                myCalendarEnd.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelEnd();
            }
        };

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
        List<Assessment> assessments = repo.getAssessmentsInTerm(courseid);
        final AssessmentAdapter aAdapter = new AssessmentAdapter(this);
        recyclerView.setAdapter(aAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        aAdapter.setmAssessment(assessments);
    }

    private void updateLabelStart(){
        editDate.setText(sdf.format(myStartCalendar.getTime()));
    }

    private void updateLabelEnd(){
        editEnd.setText(sdf.format(myCalendarEnd.getTime()));
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

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.coursemenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.notifyStart:
                String dateFromScreen = editDate.getText().toString();
                Date thisDate = null;
                try{
                    thisDate = sdf.parse(dateFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long startTrigger = thisDate.getTime();
                Intent intentStartTrigger = new Intent(activitySelectedCourse.this, MyReceiver.class);
                intentStartTrigger.putExtra("key", "Starts today");
                PendingIntent senderStart = PendingIntent.getBroadcast(activitySelectedCourse.this, MainActivity.numAlert++, intentStartTrigger, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, startTrigger, senderStart);
                return true;
            case R.id.notifyEnd:
                String endFromScreen = editEnd.getText().toString();
                Date myEndDate = null;
                try{
                    myEndDate = sdf.parse(endFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long triggerEnd = myEndDate.getTime();
                Intent intentEndTrigger = new Intent(activitySelectedCourse.this, MyReceiver.class);
                intentEndTrigger.putExtra("key", "Starts Today!");
                PendingIntent senderEnd = PendingIntent.getBroadcast(activitySelectedCourse.this, MainActivity.numAlert++, intentEndTrigger, 0);
                AlarmManager alarmManagerEnd = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManagerEnd.set(AlarmManager.RTC_WAKEUP, triggerEnd, senderEnd);
                return true;
        }
        return super.onOptionsItemSelected(item);
        }
    }
