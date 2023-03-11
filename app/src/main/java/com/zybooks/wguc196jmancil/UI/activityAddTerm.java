package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Term;
import com.zybooks.wguc196jmancil.R;
import com.zybooks.wguc196jmancil.UI.activityTerms;


public class activityAddTerm extends AppCompatActivity {
    //EditText creation for linking to interface
    EditText termName;
    EditText termStart;
    EditText termEnd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);
        //Linking EditText to interface
        termName = findViewById(R.id.termName);
        termStart = findViewById(R.id.termStart);
        termEnd = findViewById(R.id.termEnd);
    }

    public void backToTerm(View V){
        Intent intent = new Intent(activityAddTerm.this, activityTerms.class);
        startActivity(intent);
    }

    //Saves new term and moves screen back to activityTerms when button is pressed
    public void saveTerm(View view){
        //Creates repo
        Repository repository = new Repository(getApplication());
        //Creates new term object and parses data from user input
        Term term = new Term(termStart.getText().toString(), termEnd.getText().toString(), termName.getText().toString());
        //Inserting term
        repository.insertTerm(term);
        //Creating intent object to move screens
        Intent intent = new Intent(activityAddTerm.this, activityTerms.class);
        startActivity(intent);
    }
}
