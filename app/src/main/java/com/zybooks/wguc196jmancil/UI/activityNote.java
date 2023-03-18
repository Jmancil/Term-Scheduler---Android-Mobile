package com.zybooks.wguc196jmancil.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.wguc196jmancil.R;

public class activityNote extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_note);
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
                intent.putExtra(Intent.EXTRA_TEXT, "text from note field");
                intent.putExtra(Intent.EXTRA_TITLE, "Message Title");
                intent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(intent, null);
                startActivity(shareIntent);
                return true;
            case R.id.notify:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
