package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.R;
import com.zybooks.wguc196jmancil.UI.activityTerms;


public class activityAddTerm extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);
    }


    public void backToTerm(View V){
        Intent intent = new Intent(activityAddTerm.this, activityTerms.class);
        startActivity(intent);
    }
}
