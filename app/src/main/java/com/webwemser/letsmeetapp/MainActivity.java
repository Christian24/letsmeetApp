package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_DATE = "date";
    ListView list;
    MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Temporary for testing
        showDummyMeets();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //Starts SettingsActivty
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        //Logout button
        if (id == R.id.action_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Starts CreateActivty to create a new Meet
    public void addMeet(View v){
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    private void showDummyMeets(){
        Dummy dummy = new Dummy();
        ArrayList<HashMap<String, String>> meetsList = new ArrayList<HashMap<String, String>>();
        Meet[] meets = dummy.getAllMeets();
        for(int i = 0; i < meets.length; i++){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(KEY_TITLE, meets[i].getTitle());
            map.put(KEY_DESCRIPTION, meets[i].getDescription());
            map.put(KEY_DATE, meets[i].getDatetime());
            meetsList.add(map);
        }
        list = (ListView)findViewById(R.id.list);
        // Getting adapter by passing xml data ArrayList
        adapter = new MyListAdapter(this, meetsList);
        list.setAdapter(adapter);

        // Click event for single list row
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });
    }
}
