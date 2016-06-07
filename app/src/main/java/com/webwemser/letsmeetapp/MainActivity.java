package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;
import com.webwemser.web.KILOnlineIntegrationServiceSoapBinding;
import com.webwemser.web.KILmeet;
import com.webwemser.web.KILreturnCodeResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_DATE = "date";
    private ListView list;
    private MyListAdapter adapter;
    private static final String TAG = "LOGGING: ";
    public static final String KEY_POSITION = "position";
    private FABToolbarLayout fab_toolbar;
    private Spinner searchSpinner;
    private SwipeRefreshLayout swipeContainer;
    private KILOnlineIntegrationServiceSoapBinding webservice;
    private KILmeetsResponse meets;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize Webservice components
        webservice = new KILOnlineIntegrationServiceSoapBinding();
        meets = new KILmeetsResponse();
        new LoadMeetsAsync().execute();

        //Initialize FAB_Toolbar
        fab_toolbar = (FABToolbarLayout)findViewById(R.id.fabtoolbar);

        //Prepares search spinner
        new CategoryAsync().execute();

        //Initialize swipe down to refresh feature
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        createSwipeLayout();
    }

    @Override
    public void onBackPressed(){
        new LogoutAsync().execute();
    }

    //Updates screen after switching back to MainActivty
    @Override
    protected void onResume() {
        super.onResume();
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
            new LogoutAsync().execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Shows FAB Toolbar
    public void showFABToolbar(View v){
        fab_toolbar.show();
    }

    //Hides FAB Toolbar
    public void hideFABToolbar(View v){
        fab_toolbar.hide();
    }

    //Starts CreateActivty to create a new Meet
    public void showCreateActivtiy(View v){
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    //Called by search button to search for meets by category
    public void searchByCategory(View v){
        category = searchSpinner.getSelectedItem().toString();
        if(category!=null){
            new SearchByCategoryAsync().execute();
        }
    }

    //Called by search button to search for meets by category
    public void searchByUser(View v){
        new SearchByUserAsync().execute();
        hideFABToolbar(new View(getApplicationContext()));
    }

    //Displays Meets
    private void showMeets(ArrayList<KILmeet> meets){
        ArrayList<HashMap<String, String>> meetsList = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < meets.size(); i++){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(KEY_TITLE, meets.get(i).getTitle());
            map.put(KEY_DESCRIPTION, meets.get(i).getDescription());
            String strLong = Long.toString(meets.get(i).getDatetime());
            map.put(KEY_DATE, strLong);
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
        swipeContainer.setRefreshing(false);
    }

    private void createSwipeLayout(){
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.;
                new LoadMeetsAsync().execute();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    //Called by onCreate method
    class LoadMeetsAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {
                meets = webservice.getMeets(LoginActivity.session.getSessionData().getSessionID(), System.currentTimeMillis()/1000, System.currentTimeMillis()/1000 + 100000000000L);
            }
            catch (Exception e){

            }
            return "";
        }

        protected void onPostExecute(String result) {
            if(meets.getMeets().size()>0){
                showMeets(meets.getMeets());
            }
            else {
                Toast.makeText(MainActivity.this, getString(R.string.no_meets), Toast.LENGTH_SHORT).show();
            }
            swipeContainer.setRefreshing(false);
        }
    }

    //Called on logout
    class LogoutAsync extends AsyncTask<String, Integer, KILreturnCodeResponse> {

        @Override
        protected KILreturnCodeResponse doInBackground(String ... strings) {
            try {
                return webservice.logout(LoginActivity.session.getSessionData().getSessionID());
            }
            catch (Exception e){
                return new KILreturnCodeResponse();
            }
        }

        protected void onPostExecute(KILreturnCodeResponse response) {
            Log.i(TAG, ""+response.getReturnCode());
            if(response.getReturnCode()==200){
                Log.i(TAG, "Logout successful");
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
            else {
                Log.i(TAG, LoginActivity.session.getSessionData().getSessionID());
                Toast.makeText(MainActivity.this, getString(R.string.failed_logout), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }
    }

    //Fetch Categories
    class CategoryAsync extends AsyncTask<String, Integer, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String ... strings) {
            try {
                return webservice.getCategories(LoginActivity.session.getSessionData().getSessionID()).getCategories();
            }
            catch (Exception e){
                return new ArrayList<>();
            }
        }

        protected void onPostExecute(ArrayList<String> response) {
            if(response.size()==0){
                response.add(getString(R.string.load_categories));
            }
            searchSpinner = (Spinner) findViewById(R.id.search_spinner);
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, response);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            searchSpinner.setAdapter(dataAdapter);
        }
    }

    //Called by searchByCategory()
    class SearchByCategoryAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {
                meets = webservice.getMeetsByCategory(LoginActivity.session.getSessionData().getSessionID(), category);
            }
            catch (Exception e){

            }
            return "";
        }

        protected void onPostExecute(String result) {
            if(meets.getMeets().size()>0){
                showMeets(meets.getMeets());
            }
            else {
                Toast.makeText(MainActivity.this, getString(R.string.no_meets), Toast.LENGTH_SHORT).show();
            }
            swipeContainer.setRefreshing(false);
        }
    }

    //Called to load user meets
    class SearchByUserAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {
                meets = webservice.getMeetsByUser(LoginActivity.session.getSessionData().getSessionID());
            }
            catch (Exception e){

            }
            return "";
        }

        protected void onPostExecute(String result) {
            if(meets.getMeets().size()>0){
                showMeets(meets.getMeets());
            }
            else {
                Toast.makeText(MainActivity.this, getString(R.string.no_meets), Toast.LENGTH_SHORT).show();
            }
            swipeContainer.setRefreshing(false);
        }
    }
}
