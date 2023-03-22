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
import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.Entity.Note;
import com.zybooks.wguc196jmancil.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class activitySelectedNote extends AppCompatActivity {
    EditText editId;
    EditText editTitle;
    EditText editCourseId;
    EditText editNote;
    EditText editDate;

    int id;
    String title;
    int courseId;
    String note;
    String date;

    DatePickerDialog.OnDateSetListener startDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    String myFormat;
    SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_note);
        //Info for date selector
        editDate = findViewById(R.id.editDate);
        String myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        //Click listener for date picker
        editDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Date date;
                String info = editDate.getText().toString();
                if(info.equals(""))info="02/10/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(activitySelectedNote.this, startDate, myCalendarStart.get(Calendar.YEAR),
                        myCalendarStart.get(Calendar.MONTH),
                        myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        startDate = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth){
                    myCalendarStart.set(Calendar.YEAR, year);
                    myCalendarStart.set(Calendar.MONTH, monthOfYear);
                    myCalendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabelStart();
            }
        };

        editId = findViewById(R.id.editNoteID);
        editTitle = findViewById(R.id.editTitle);
        editCourseId = findViewById(R.id.courseIdEdit);
        editNote = findViewById(R.id.editNote);
        editDate = findViewById(R.id.editDate);

        id = getIntent().getIntExtra("id", -1);
        title = getIntent().getStringExtra("title");
        courseId = getIntent().getIntExtra("courseId", -1);
        note = getIntent().getStringExtra("note");
        date = getIntent().getStringExtra("date");

        editId.setText(Integer.toString(id));
        editTitle.setText(title);
        editCourseId.setText(Integer.toString(courseId));
        editNote.setText(note);
        editDate.setText(date);

    }

    private void updateLabelStart(){
        editDate.setText(sdf.format(myCalendarStart.getTime()));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.notemenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.shareNote:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, editNote.getText().toString());
                intent.putExtra(Intent.EXTRA_TITLE, editTitle.getText().toString());
                intent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(intent, null);
                startActivity(shareIntent);
                return true;
            case R.id.notify:
                String dateFromScreen = editDate.getText().toString();
                Date myDate = null;
                try{
                    myDate = sdf.parse(dateFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long trigger = myDate.getTime();
                Intent intentTrigger = new Intent(activitySelectedNote.this, MyReceiver.class);
                intentTrigger.putExtra("key", "Testing");
                PendingIntent sender = PendingIntent.getBroadcast(activitySelectedNote.this, MainActivity.numAlert++, intentTrigger, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, trigger, sender);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void backToNotes(View view){
        Intent intent = new Intent(activitySelectedNote.this, activityNote.class);
        startActivity(intent);
    }

    public void deleteNote(View view){
        Repository repo = new Repository(getApplication());
        Note note = new Note(Integer.parseInt(editId.getText().toString()), editTitle.getText().toString(),
                editNote.getText().toString(), editDate.getText().toString(), Integer.parseInt(editCourseId.getText().toString()));
        repo.deleteNote(note);
        Intent intent = new Intent(activitySelectedNote.this, activityNote.class);
        startActivity(intent);
    }

    public void saveNote(View view){
        Repository repo = new Repository(getApplication());
        Note note = new Note(Integer.parseInt(editId.getText().toString()), editTitle.getText().toString(),
                editNote.getText().toString(), editDate.getText().toString(), Integer.parseInt(editCourseId.getText().toString()));
        repo.updateNote(note);
        Intent intent = new Intent(this, activityNote.class);
        startActivity(intent);
    }
}
