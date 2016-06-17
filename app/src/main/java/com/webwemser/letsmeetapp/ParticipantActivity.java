package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.webwemser.web.MeetData;
import com.webwemser.web.MeetResponse;
import com.webwemser.web.OnlineIntegrationServiceSoapBinding;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Displays a meets participants
 * @author Jannik
 */
public class ParticipantActivity extends AppCompatActivity {

    public static final String USERNAME = "USERNAME", DESCRIPTION = "DESCRIPTION";
    private OnlineIntegrationServiceSoapBinding webservice;
    private static final int KEY_POSITION = 1;
    private int meetPosition = 0;
    private ListView list;
    private MyParticipantsAdapter adapter;
    private MeetData meet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        webservice = new OnlineIntegrationServiceSoapBinding();
        //Get meet position
        meetPosition = getIntent().getIntExtra(MainActivity.KEY_POSITION, KEY_POSITION);
       new GetMeetAsync().execute();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MeetActivity.class);
        intent.putExtra(MainActivity.KEY_POSITION, meet.id);
        startActivity(intent);
    }

    private void setParticipants(){
        ArrayList<HashMap<String, String>> participantList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(USERNAME, meet.getAdminUserName());
        map.put(DESCRIPTION, meet.admin.getDescription());
        participantList.add(map);
        for(int i = 0; i < meet.getVisitors().size(); i++){
            map = new HashMap<String, String>();
            map.put(USERNAME, meet.getVisitors().get(i).getUserName());
            map.put(DESCRIPTION, meet.getVisitors().get(i).getDescription());
            participantList.add(map);
        }
        list = (ListView)findViewById(R.id.participant_list);
        adapter = new MyParticipantsAdapter(this, participantList);
        list.setAdapter(adapter);
    }
    class GetMeetAsync extends AsyncTask<String, Integer, MeetResponse> {
        @Override
        protected MeetResponse doInBackground(String ... strings){
            try {
                return webservice.getMeet(LoginActivity.session.getSessionData().getSessionID(), meetPosition);
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
                setParticipants();
        }
        else {
            Toast.makeText(ParticipantActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }
}
