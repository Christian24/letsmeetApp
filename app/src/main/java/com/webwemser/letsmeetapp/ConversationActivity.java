package com.webwemser.letsmeetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ConversationActivity extends AppCompatActivity {

    private static final int KEY_POSITION = 1;
    private int meetPosition = 0;
    private ListView list;
    private MyCommentAdapter adapter;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        //Get meet position
        meetPosition = getIntent().getIntExtra(MainActivity.KEY_POSITION, KEY_POSITION);

        //Set comments
        setComments();
    }

    private void setComments(){
        ArrayList<HashMap<String, String>> commentList = new ArrayList<HashMap<String, String>>();
        Log.i("Conversation Size: ", MainActivity.meets.getMeets().get(meetPosition).getConversations().size()+"");
        if(MainActivity.meets.getMeets().get(meetPosition).getConversations().size()>0){
            for(int i = 0; i<MainActivity.meets.getMeets().get(meetPosition).getConversations().size() ; i++){
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(MeetActivity.USERNAME, MainActivity.meets.getMeets().get(meetPosition).getConversations().get(i).getConversation().get(0).getPoster());
                map.put(MeetActivity.COMMENT, MainActivity.meets.getMeets().get(meetPosition).getConversations().get(i).getConversation().get(0).getText());
                commentList.add(map);
            }
            list = (ListView)findViewById(R.id.conversation_list);
            adapter = new MyCommentAdapter(this, commentList);
            list.setAdapter(adapter);
        }
    }
}
