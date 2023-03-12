package com.zybooks.wguc196jmancil.UI;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.zybooks.wguc196jmancil.Database.Repository;
import com.zybooks.wguc196jmancil.Entity.Term;
import com.zybooks.wguc196jmancil.R;

/*Class dec for selectedTerm
initializes data from selected term object from main screen
 */
public class activitySelectedTerm extends AppCompatActivity {
    //EditText creation for findViewById to link to activity_selected_term.xml
    EditText editTermName;
    EditText editStart;
    EditText editEnd;
    EditText editID;
    //Variable decs for assigning .set to values
    String start;
    String name;
    String end;
    Integer id;

    //Method for assigning clicked Term values of item clicked
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_term);
        //Connecting EditText objects to selected term view handlers
        editTermName = findViewById(R.id.editTermName);
        editStart = findViewById(R.id.termStart);
        editEnd = findViewById(R.id.termEnd);
        editID = findViewById(R.id.termID);
        //Variables declared above used here for assignment to values
        start = getIntent().getStringExtra("start");
        name = getIntent().getStringExtra("name");
        end = getIntent().getStringExtra("end");
        id = getIntent().getIntExtra("id", -1);
        //.setText linking previously assigned values from DB to activity_selected_term.xml interface
        editTermName.setText(name);
        editStart.setText(start);
        editEnd.setText(end);
        editID.setText(Integer.toString(id));
    }

//    //Method to save term changes
    public void saveSelectedTerm(View view){
        //Creates repo object
        Repository repository = new Repository(getApplication());
        //Creates term and parses data in from interface with .getText().toSring()
        Term term = new Term(Integer.parseInt(editID.getText().toString()), editStart.getText().toString(), editEnd.getText().toString(), editTermName.getText().toString());
        //updates term with updateTerm function call from repo.
        repository.updateTerm(term);
        //Intent creation for screen navigation
        Intent intent = new Intent(activitySelectedTerm.this, activityTerms.class);
        startActivity(intent);
    }

    public void backFromSelectedTerm(View view){
        Intent intent = new Intent(activitySelectedTerm.this, activityTerms.class);
        startActivity(intent);
    }

    public void deleteTerm(View view){
        Repository repo = new Repository(getApplication());
        Term term = new Term(Integer.parseInt(editID.getText().toString()), editStart.getText().toString(), editEnd.getText().toString(), editTermName.getText().toString());
        repo.termDelete(term);
        Intent intent = new Intent(activitySelectedTerm.this, activityTerms.class);
        startActivity(intent);
    }
}
