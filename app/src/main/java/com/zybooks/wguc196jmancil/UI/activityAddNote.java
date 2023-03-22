package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Note;
import com.zybooks.wguc196jmancil.R;

public class activityAddNote extends AppCompatActivity {
    //EdiText creation for linking to activityAddNote view
    EditText editId;
    EditText editTitle;
    EditText editCourseId;
    EditText editNote;
    EditText editDate;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        //Connect edittext objects to view handlers
        editId = findViewById(R.id.editNoteID);
        editTitle = findViewById(R.id.editTitle);
        editCourseId = findViewById(R.id.courseIdEdit);
        editNote = findViewById(R.id.editNote);
        editDate = findViewById(R.id.editAddDate);
    }

    public void saveNote(View view){
        Repository repo = new Repository(getApplication());
        Note note = new Note(editTitle.getText().toString(), editNote.getText().toString(), editDate.getText().toString(), Integer.parseInt(editCourseId.getText().toString()));
        repo.insertNote(note);
        Intent intent = new Intent(activityAddNote.this, activityNote.class);
        startActivity(intent);
    }
}
