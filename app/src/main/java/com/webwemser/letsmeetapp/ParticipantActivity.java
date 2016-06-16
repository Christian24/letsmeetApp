package com.webwemser.letsmeetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ParticipantActivity extends AppCompatActivity {

    public static final String USERNAME = "USERNAME", DESCRIPTION = "DESCRIPTION";
    private static final int KEY_POSITION = 1;
    private int meetPosition = 0;
    private ListView list;
    private MyParticipantsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        meetPosition = getIntent().getIntExtra(MainActivity.KEY_POSITION, KEY_POSITION);
        setParticipants();
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }

    private void setParticipants(){
        ArrayList<HashMap<String, String>> participantList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(USERNAME, MainActivity.meets.getMeets().get(meetPosition).getAdminUserName());
        map.put(DESCRIPTION, MainActivity.meets.getMeets().get(meetPosition).admin.getDescription());
        participantList.add(map);
        for(int i = 0; i < MainActivity.meets.getMeets().get(meetPosition).getVisitors().size(); i++){
            map = new HashMap<String, String>();
            map.put(USERNAME, MainActivity.meets.getMeets().get(meetPosition).getVisitors().get(i).getUserName());
            map.put(DESCRIPTION, MainActivity.meets.getMeets().get(meetPosition).getVisitors().get(i).getDescription());
            participantList.add(map);
        }
        list = (ListView)findViewById(R.id.participant_list);
        adapter = new MyParticipantsAdapter(this, participantList);
        list.setAdapter(adapter);
    }
}
