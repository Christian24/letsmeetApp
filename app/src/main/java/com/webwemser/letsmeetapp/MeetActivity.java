package com.webwemser.letsmeetapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.webwemser.web.ConversationData;
import com.webwemser.web.MeetResponse;
import com.webwemser.web.MeetsResponse;
import com.webwemser.web.OnlineIntegrationServiceSoapBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;


public class MeetActivity extends AppCompatActivity {

    private TextView title, author, descripton, date, max_guests, category;
    private ListView list;
    private MyCommentAdapter adapter;
    private static final int KEY_POSITION = 1;
    public static final String USERNAME = "USERNAME", COMMENT = "COMMENT", POSITION = "POSITION";
    private int meetPosition;
    private FloatingActionButton fab_join, fab_leave, fab_delete;
    private OnlineIntegrationServiceSoapBinding webservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);

        //Initialize webservice
        webservice = new OnlineIntegrationServiceSoapBinding();

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
        setComments();

        //Set values to Textviews
        //long x = Long.parseLong(MainActivity.meets.getMeets().get(meetPosition).getDateTime().toString());
        date.setText(MainActivity.meets.getMeets().get(meetPosition).getDateTime());
        category.setText(MainActivity.meets.getMeets().get(meetPosition).getCategory());
        title.setText(MainActivity.meets.getMeets().get(meetPosition).getTitle());
        descripton.setText(MainActivity.meets.getMeets().get(meetPosition).getDescription());
        author.setText(MainActivity.meets.getMeets().get(meetPosition).getAdminUserName());
        max_guests.setText(MainActivity.meets.getMeets().get(meetPosition).getFreeSpace()+" / "+MainActivity.meets.getMeets().get(meetPosition).getMaxGuests());
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
        else if (MainActivity.meets.getMeets().get(meetPosition).hasJoined(LoginActivity.session.getSessionData().getUserData())){
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

    //Displays comments
    private void setComments(){
        ArrayList<HashMap<String, String>> commentList = new ArrayList<HashMap<String, String>>();
        Log.i("Conversation Size: ", MainActivity.meets.getMeets().get(meetPosition).getConversations().size()+"");
        if(MainActivity.meets.getMeets().get(meetPosition).getConversations().size()>0){
            for(int i = 0; i<MainActivity.meets.getMeets().get(meetPosition).getConversations().size() ; i++){
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(USERNAME, MainActivity.meets.getMeets().get(meetPosition).getConversations().get(i).getConversation().get(0).getPoster());
                map.put(COMMENT, MainActivity.meets.getMeets().get(meetPosition).getConversations().get(i).getConversation().get(0).getText());
                commentList.add(map);
            }
            list = (ListView)findViewById(R.id.comment_list);
            adapter = new MyCommentAdapter(this, commentList);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Intent intent = new Intent(MeetActivity.this, ConversationData.class);
                    intent.putExtra(POSITION, position);
                    startActivity(intent);
                }
            });
        }
    }

    public void showParticipants(View v){
        Intent intent = new Intent(this, ParticipantActivity.class);
        intent.putExtra(MainActivity.KEY_POSITION, meetPosition);
        startActivity(intent);
    }

    //Called by fab_join to join a meet
    public void join(View v){
        new JoinAsync().execute();
    }

    //Called by fab_leave to leave meet
    public void leave(View v){
        new LeaveAsync().execute();
    }

    //Called by fab_delete to delete meet by admin
    public void delete(View v){
        new LeaveAsync().execute();
    }

    public void comment(View v){

    }

    class JoinAsync extends AsyncTask<String, String, MeetResponse> {

        @Override
        protected MeetResponse doInBackground(String ... strings) {
            try {
                return webservice.joinMeet(LoginActivity.session.getSessionData().getSessionID(), MainActivity.meets.getMeets().get(meetPosition).id);
            }
            catch (Exception e){
                return new MeetResponse();
            }
        }

        protected void onPostExecute(MeetResponse response) {
            if(response!=null){
                MeetActivity.this.finish();
            }
            else {
                Toast.makeText(MeetActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        }
    }

    class LeaveAsync extends AsyncTask<String, Integer, MeetResponse> {

        @Override
        protected MeetResponse doInBackground(String ... strings) {
            try {
                return webservice.leaveMeet(LoginActivity.session.getSessionData().getSessionID(), MainActivity.meets.getMeets().get(meetPosition).id);
            }
            catch (Exception e){
                return new MeetResponse();
            }
        }

        protected void onPostExecute(MeetResponse response) {
            if(response!=null){
                MeetActivity.this.finish();
            }
            else {
                Toast.makeText(MeetActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        }
    }
}