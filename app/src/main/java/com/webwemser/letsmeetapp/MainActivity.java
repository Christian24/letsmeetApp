package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_DATE = "date";
    private ListView list;
    public static ArrayList<Meet> meets = new ArrayList<>();
    private MyListAdapter adapter;
    private static final String TAG = "LOGGING: ";
    public static final String KEY_POSITION = "position";
    private FABToolbarLayout fab_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize FAB_Toolbar
        fab_toolbar = (FABToolbarLayout)findViewById(R.id.fabtoolbar);

        //Temporary for testing
        Dummy dummy = new Dummy();
        meets = dummy.getAllMeets();
        showDummyMeets();
    }

    //Updates screen after switching back to MainActivty
    @Override
    protected void onResume() {
        super.onResume();
        showDummyMeets();
        fab_toolbar.hide();
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
        //Starts AccountActivity
        if (id == R.id.action_account) {
            Intent intent = new Intent(this, AccountActivity.class);
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

    public void showFABToolbar(View v){
        fab_toolbar.show();
    }

    public void hideFABToolbar(View v){
        fab_toolbar.hide();
    }

    //Starts CreateActivty to create a new Meet
    public void showCreateActivtiy(View v){
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    //Called by CreateActivity for adding a new Meet
    public static void addMeetfromCreate(Meet m){
        meets.add(m);
        for(int i = 0; i<meets.size(); i++){
            Log.i(TAG, meets.get(i).getTitle());
        }
    }


    //Displays Dummy Meets
    private void showDummyMeets(){
        ArrayList<HashMap<String, String>> meetsList = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < meets.size(); i++){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(KEY_TITLE, meets.get(i).getTitle());
            map.put(KEY_DESCRIPTION, meets.get(i).getDescription());
            map.put(KEY_DATE, meets.get(i).getDatetime());
            meetsList.add(map);
            Log.i(TAG, meets.get(i).getTitle());
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
                Intent intent = new Intent(MainActivity.this, MeetActivity.class);
                intent.putExtra(KEY_POSITION, position);
                startActivity(intent);
            }
        });
    }
}
