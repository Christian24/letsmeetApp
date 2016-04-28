package com.webwemser.letsmeetapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MeetActivity extends AppCompatActivity {

    private TextView title, author, descripton, date;
    private static final int KEY_POSITION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int position = getIntent().getIntExtra(MainActivity.KEY_POSITION, KEY_POSITION);

        //Initialize Textviews;
        title = (TextView)findViewById(R.id.display_title);
        author = (TextView)findViewById(R.id.display_author);
        descripton = (TextView)findViewById(R.id.display_description);
        date = (TextView)findViewById(R.id.display_datetime);

        //Set values
        title.setText(MainActivity.meets.get(position).getTitle());
        author.setText(MainActivity.meets.get(position).getAuthor());
        descripton.setText(MainActivity.meets.get(position).getDescription());
        date.setText(MainActivity.meets.get(position).getDatetime());

    }

    public void getBack(View v){
        this.finish();
    }

}
