package com.zybooks.wguc196jmancil.UI;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class activitySelectedAssessment extends AppCompatActivity{
    //EditText creation for linking
    EditText editName;
    EditText editStart;
    EditText editEnd;
    EditText editCourseId;
    EditText editAssessmentId;
    EditText editDate;

    //Variables declarations for assigning .set values
    String name;
    String start;
    String end;
    int id;
    int aId;

    //for start date calendar
    DatePickerDialog.OnDateSetListener assessmentStart;
    final Calendar assessmentStartCalendar = Calendar.getInstance();
    String startFormat;
    SimpleDateFormat sdf;

    //for end date calendar
    DatePickerDialog.OnDateSetListener assessmentEnd;
    final Calendar assessmentEndCalendar = Calendar.getInstance();
    String endFormat;

    //Method for assigning clicked assessment values of item clicked
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_assessment);

        //Info for date selector
        editDate = findViewById(R.id.editStart);
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
                    assessmentStartCalendar.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(activitySelectedAssessment.this, assessmentStart, assessmentStartCalendar.get(Calendar.YEAR),
                        assessmentStartCalendar.get(Calendar.MONTH),
                        assessmentStartCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        assessmentStart = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth){
                assessmentStartCalendar.set(Calendar.YEAR, year);
                assessmentStartCalendar.set(Calendar.MONTH, monthOfYear);
                assessmentStartCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();
            }
        };

        //Info for date selector
        editEnd = findViewById(R.id.editEnd);
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
                    assessmentEndCalendar.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(activitySelectedAssessment.this, assessmentEnd, assessmentEndCalendar.get(Calendar.YEAR),
                        assessmentEndCalendar.get(Calendar.MONTH),
                        assessmentEndCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        assessmentEnd = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth){
                assessmentEndCalendar.set(Calendar.YEAR, year);
                assessmentEndCalendar.set(Calendar.MONTH, monthOfYear);
                assessmentEndCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelEnd();
            }
        };

        //linking EditText with xml view handlers
        editName = findViewById(R.id.editName);
        editStart = findViewById(R.id.editStart);
        editEnd = findViewById(R.id.editEnd);
        editCourseId = findViewById(R.id.editId);
        editAssessmentId = findViewById(R.id.assessmentId);

        //Variables declared above used here for assignment to values
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        id = getIntent().getIntExtra("courseID" ,-1);
        name = getIntent().getStringExtra("title");
        aId = getIntent().getIntExtra("ID",-1);

        //.setText linking assigned values from interface
        editStart.setText(start);
        editEnd.setText(end);
        editCourseId.setText(Integer.toString(id));
        editName.setText(name);
        editAssessmentId.setText(Integer.toString(aId));
    }

    public void backToCourses(View view){
        //Creates intent to move screen
        Intent intent = new Intent(activitySelectedAssessment.this, activityAssessments.class);
        startActivity(intent);
    }

    public void deleteAssessment(View view){
        Repository repo = new Repository(getApplication());
        Assessment assessment = new Assessment(Integer.parseInt(editAssessmentId.getText().toString()
        ), editStart.getText().toString(), editEnd.getText().toString(), editName.getText().toString(), Integer.parseInt(editCourseId.getText().toString()));
        repo.deleteAssessment(assessment);
        Intent intent = new Intent(activitySelectedAssessment.this, activityAssessments.class);
        startActivity(intent);
    }

    public void saveAssessment(View view){
        Repository repo = new Repository(getApplication());
        //parse data from interface to assesment object
        Assessment assessment = new Assessment(Integer.parseInt(editAssessmentId.getText().toString()
        ), editStart.getText().toString(), editEnd.getText().toString(), editName.getText().toString(), Integer.parseInt(editCourseId.getText().toString()));
        //Inserts assessment
        repo.updateAssessment(assessment);
        //intent moves screens
        Intent intent = new Intent(activitySelectedAssessment.this, activityAssessments.class);
        startActivity(intent);
    }

    private void updateLabelStart(){
        editDate.setText(sdf.format(assessmentStartCalendar.getTime()));
    }

    private void updateLabelEnd(){
        editEnd.setText(sdf.format(assessmentEndCalendar.getTime()));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.assessmentmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.notifyAssessmentStart:
                String dateFromScreen = editDate.getText().toString();
                Date thatDate = null;
                try{
                    thatDate = sdf.parse(dateFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long startTrigger = thatDate.getTime();
                Intent intentStartTrigger = new Intent(activitySelectedAssessment.this, MyReceiver.class);
                intentStartTrigger.putExtra("key", "Starts today");
                PendingIntent senderStart = PendingIntent.getBroadcast(activitySelectedAssessment.this, MainActivity.numAlert++, intentStartTrigger, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, startTrigger, senderStart);
                return true;
            case R.id.notifyAssessmentEnd:
                String endFromScreen = editEnd.getText().toString();
                Date enDate = null;
                try{
                    enDate = sdf.parse(endFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long triggerEnd = enDate.getTime();
                Intent intentEndTrigger = new Intent(activitySelectedAssessment.this, MyReceiver.class);
                intentEndTrigger.putExtra("key", "Starts Today!");
                PendingIntent senderEnd = PendingIntent.getBroadcast(activitySelectedAssessment.this, MainActivity.numAlert++, intentEndTrigger, 0);
                AlarmManager alarmManagerEnd = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManagerEnd.set(AlarmManager.RTC_WAKEUP, triggerEnd, senderEnd);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
