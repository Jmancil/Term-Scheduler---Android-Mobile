package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Term;
import com.zybooks.wguc196jmancil.R;
import com.zybooks.wguc196jmancil.UI.activityTerms;
import java.util.List;


public class activitySelectedTerm extends AppCompatActivity {
    EditText editName;
    String name;
//    EditText editStartDate;
//    EditText editEndDate;
//    EditText editTermID;
//
//    String name;
//    String start;
//    String end;
//    int termID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_term);

        editName = findViewById(R.id.editTermName);
        name = getIntent().getStringExtra("Name");
        editName.setText(name);








//        editName = findViewById(R.id.editTermName);
//        editStartDate = findViewById(R.id.termStart);
//        editEndDate = findViewById(R.id.termEnd);
//        editTermID = findViewById(R.id.termID);
//        name = getIntent().getStringExtra("Name");
//        editName.setText(name);
//        start = getIntent().getStringExtra("Start");
//        editStartDate.setText(start);
//        end = getIntent().getStringExtra("End");
//        editEndDate.setText(end);
//        termID = getIntent().getIntExtra("TermID",1);
//        editTermID.setId(termID);

//        RecyclerView recyclerView = findViewById(R.id.selectedItemRecycler);
//        Repository repo = new Repository(getApplication());
//        List<Term> selectedTerm = repo.getmAllTerms();
//        final TermAdapter termAdapter = new TermAdapter(this);
//        recyclerView.setAdapter(termAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        termAdapter.setTerms(selectedTerm);

    }

}
