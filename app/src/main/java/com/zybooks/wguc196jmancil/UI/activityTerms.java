package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Term;
import com.zybooks.wguc196jmancil.R;

import java.util.List;


public class activityTerms extends AppCompatActivity {

    /*Main method for this screen, kicks off view
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View set to activity_terms
        setContentView(R.layout.activity_terms);
        //Data pulled from Room DB with recyclerview
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        //Creating repo to call getApp function
        Repository repository = new Repository(getApplication());
        //Creating Term array and calling getAllTerms Method to populate
        List<Term> terms = repository.getmAllTerms();
        //Creating new Termadapter
        final TermAdapter termAdapter = new TermAdapter(this);
        //Setting recyclerview with data populated into termAdapter created above
        recyclerView.setAdapter(termAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        termAdapter.setTerms(terms);
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
