package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Note;
import com.zybooks.wguc196jmancil.Entity.Term;
import com.zybooks.wguc196jmancil.R;

import java.util.List;

public class activityNote extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        RecyclerView recyclerView = findViewById(R.id.courseNotes);
        Repository repo = new Repository(getApplication());
        List<Note> notes = repo.getAllNotes();
        final NoteAdapter noteAdapter = new NoteAdapter(this);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter.setNote(notes);
    }

    public void backToCourses(View view){
        Intent intent = new Intent(activityNote.this, activityCourses.class);
        startActivity(intent);
    }

    public void newNote(View view){
        Intent intent = new Intent(activityNote.this, activityAddNote.class);
        startActivity(intent);
    }
}
