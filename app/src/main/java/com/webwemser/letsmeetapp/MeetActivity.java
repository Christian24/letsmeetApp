package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.webwemser.web.ConversationData;
import com.webwemser.web.MeetData;
import com.webwemser.web.MeetResponse;
import com.webwemser.web.OnlineIntegrationServiceSoapBinding;
import java.util.ArrayList;
import java.util.HashMap;


public class MeetActivity extends AppCompatActivity {

    private TextView title, author, descripton, date, max_guests, category;
    private EditText question;
    private ListView list;
    private String questionToAsk;
    private MyCommentAdapter adapter;
    private static final int KEY_POSITION = 1;
    public static final String USERNAME = "USERNAME", COMMENT = "COMMENT", POSITION = "POSITION",CONVERSATION = "CONVERSATION";

    private static int meetPosition;
    private FloatingActionButton fab_join, fab_leave, fab_delete;
    private OnlineIntegrationServiceSoapBinding webservice;
    private MeetData meet;

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
        question = (EditText)findViewById(R.id.ask);

        //long x = Long.parseLong(meet.getDateTime().toString());
        //Set values to Textviews
        new GetMeetAsync().execute();




    }

    private void setup() {
        try {

            date.setText(meet.getDateTime());
            category.setText(meet.getCategory());
            title.setText(meet.getTitle());
            descripton.setText(meet.getDescription());
            author.setText(meet.getAdminUserName());
            max_guests.setText(meet.getFreeSpace()+" / "+meet.getMaxGuests());
            //Set right button and add commentViews
            setButtons();
            setComments();
        }
        catch (IndexOutOfBoundsException e){
            Toast.makeText(MeetActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    //Sets the right FAB
    private void setButtons() throws IndexOutOfBoundsException {
        try {
            fab_delete = (FloatingActionButton)findViewById(R.id.fab_delete);
            fab_join = (FloatingActionButton)findViewById(R.id.fab_join);
            fab_leave = (FloatingActionButton)findViewById(R.id.fab_leave);
            if(meet.getAdminUserName().equals(LoginActivity.session.getSessionData().getUserData().getUserName())){
                fab_delete.setVisibility(View.VISIBLE);
            }
            else if (meet.hasJoined(LoginActivity.session.getSessionData().getUserData())){
                fab_leave.setVisibility(View.VISIBLE);
            }
            else {
                if(meet.getFreeSpace() == meet.getMaxGuests()){
                    //do nothing because maxGuests is reached
                }
                else {
                    fab_join.setVisibility(View.VISIBLE);
                }
            }
        }
        catch (IndexOutOfBoundsException e){

        }
    }

    //Displays comments
    private void setComments() throws IndexOutOfBoundsException {
        try {
            ArrayList<HashMap<String, String>> commentList = new ArrayList<HashMap<String, String>>();
            Log.i("Conversation Size: ", meet.getConversations().size()+"");
            if(meet.getConversations().size()>0){
                for(int i = 0; i<meet.getConversations().size() ; i++){
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put(USERNAME, meet.getConversations().get(i).getConversation().get(0).getPoster());
                    map.put(COMMENT, meet.getConversations().get(i).getConversation().get(0).getText());
                    commentList.add(map);
                }
                list = (ListView)findViewById(R.id.comment_list);
                adapter = new MyCommentAdapter(this, commentList);
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent intent = new Intent(MeetActivity.this, ConversationActivity.class);
                        intent.putExtra(POSITION, position);
                        intent.putExtra(CONVERSATION,id);
                        startActivity(intent);
                    }
                });
            }
        }
        catch (IndexOutOfBoundsException e){

        }
    }

    //Starts ParticipantActivty
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
        if(question.getText().toString().length()>2){
            questionToAsk = question.getText().toString();
            new AskAsync().execute();
        }
        else {
            Toast.makeText(MeetActivity.this, getString(R.string.question_to_short), Toast.LENGTH_SHORT).show();
        }
    }
    class GetMeetAsync extends AsyncTask<String, Integer, MeetResponse>{
        @Override
        protected MeetResponse doInBackground(String ... strings){
            try {
                return webservice.getMeet(LoginActivity.session.getSessionData().getSessionID(), 1);
            }
            catch (Exception e){
                return new MeetResponse();
            }
        }
        @Override
        protected void onPostExecute(MeetResponse response) {
            process(response);
        }
    }

    private void process(MeetResponse response) {
        if(response != null ) {
            meet = response.getMeet();
            if(meet != null)
            setup();
        }
        else {
            Toast.makeText(MeetActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }

    //Called to join Meet
    class JoinAsync extends AsyncTask<String, String, MeetResponse> {

        @Override
        protected MeetResponse doInBackground(String ... strings) {
            try {
                return webservice.joinMeet(LoginActivity.session.getSessionData().getSessionID(), meet.id);
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

    //Called to leave Meet
    class LeaveAsync extends AsyncTask<String, Integer, MeetResponse> {

        @Override
        protected MeetResponse doInBackground(String ... strings) {
            try {
                return webservice.leaveMeet(LoginActivity.session.getSessionData().getSessionID(), meet.id);
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

    class AskAsync extends AsyncTask<String, Integer, MeetResponse> {

        @Override
        protected MeetResponse doInBackground(String ... strings) {
            try {
                return webservice.createNewConversation(LoginActivity.session.getSessionData().getSessionID(), meet.id, questionToAsk);
            }
            catch (Exception e){
                return new MeetResponse();
            }
        }

        protected void onPostExecute(MeetResponse response) {
            /*
            if(response!=null){
                MeetActivity.this.finish();
            }
            else {

                Toast.makeText(MeetActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
            */
            process(response);
        }
    }
}