package com.webwemser.letsmeetapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.webwemser.web.KILOnlineIntegrationServiceSoapBinding;

import java.text.SimpleDateFormat;


public class MeetActivity extends AppCompatActivity {

    private TextView title, author, descripton, date, max_guests, category;
    private static final int KEY_POSITION = 1;
    private int meetPosition;
    private FloatingActionButton fab_join, fab_leave, fab_delete;
    private KILOnlineIntegrationServiceSoapBinding webservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);

        //Initialize webservice
        webservice = new KILOnlineIntegrationServiceSoapBinding();

        //Get Meet ID
        meetPosition = getIntent().getIntExtra(MainActivity.KEY_POSITION, KEY_POSITION);

        //Initialize Views;
        title = (TextView)findViewById(R.id.display_title);
        author = (TextView)findViewById(R.id.display_author);
        descripton = (TextView)findViewById(R.id.display_description);
        date = (TextView)findViewById(R.id.display_datetime);
        max_guests = (TextView)findViewById(R.id.display_max_guests);
        category = (TextView)findViewById(R.id.display_category);
        setButtons();

        //Set values to Textviews
        long x = Long.parseLong(MainActivity.meets.getMeets().get(meetPosition).getDateTime().toString());
        date.setText(new SimpleDateFormat("dd.MM.yyyy hh:mm").format(new java.util.Date(x)));
        category.setText(MainActivity.meets.getMeets().get(meetPosition).getCategory());
        title.setText(MainActivity.meets.getMeets().get(meetPosition).getTitle());
        descripton.setText(MainActivity.meets.getMeets().get(meetPosition).getDescription());
        author.setText(MainActivity.meets.getMeets().get(meetPosition).getAdminUserName());
        max_guests.setText(MainActivity.meets.getMeets().get(meetPosition).getFreeSpace()+" / "+MainActivity.meets.getMeets().get(meetPosition).getMaxGuests().toString());
    }

    public void getBack(View v){
        this.finish();
    }

    //Sets the right FAB
    private void setButtons(){
        fab_delete = (FloatingActionButton)findViewById(R.id.fab_delete);
        fab_join = (FloatingActionButton)findViewById(R.id.fab_join);
        fab_leave = (FloatingActionButton)findViewById(R.id.fab_leave);
        if(MainActivity.meets.getMeets().get(meetPosition).getAdminUserName().equals(LoginActivity.session.getSessionData().getUserData().getUserName())){
            fab_delete.setVisibility(View.VISIBLE);
        }
        else if (MainActivity.meets.getMeets().get(meetPosition).hasJoined(LoginActivity.session.getSessionData().getUserData().getUserName())){
            fab_leave.setVisibility(View.VISIBLE);
        }
        else {
            if(MainActivity.meets.getMeets().get(meetPosition).getFreeSpace() == MainActivity.meets.getMeets().get(meetPosition).getMaxGuests()){
                //do nothing because maxGuests is reached
            }
            else {
                fab_join.setVisibility(View.VISIBLE);
            }
        }
    }

    public void showParticipants(View v){
        new AlertDialog.Builder(MeetActivity.this)
                .setTitle(getString(R.string.participants))
                
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_menu_delete)
                .show();
    }

    //Called by fab_join to join a meet
    public void join(View v){

    }

    //Called by fab_leave to leave meet
    public void leave(View v){

    }

    //Called by fab_delete to delete meet by admin
    public void delete(View v){

    }

    public void comment(View v){

    }

    class JoinAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {
                //webservice.joinMeet(LoginActivity.session.getSessionData().getSessionID(), MainActivity.meets.getMeets(meetPosition).g)
            }
            catch (Exception e){

            }
            return "";
        }

        protected void onPostExecute(String result) {

        }
    }

    class DeleteAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {

            }
            catch (Exception e){

            }
            return "";
        }

        protected void onPostExecute(String result) {

        }
    }

    class LeaveAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {

            }
            catch (Exception e){

            }
            return "";
        }

        protected void onPostExecute(String result) {

        }
    }


}