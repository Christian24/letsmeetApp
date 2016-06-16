package com.webwemser.letsmeetapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.webwemser.web.ConversationData;
import com.webwemser.web.MeetData;
import com.webwemser.web.MeetResponse;
import com.webwemser.web.OnlineIntegrationServiceSoapBinding;
import com.webwemser.web.UserContentData;

import java.util.ArrayList;
import java.util.HashMap;

public class ConversationActivity extends AppCompatActivity {

    private static final int KEY_POSITION = 0;
    private MeetData meet;
    private int meetPosition = 0, conversationPosition = 0;
    private ListView list;
    private String commentToPost;
    private ConversationData conversation;
    private MyCommentAdapter adapter;
    private EditText comment;
    private OnlineIntegrationServiceSoapBinding webservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        comment = (EditText)findViewById(R.id.comment);
        //Get meet position
        meetPosition = getIntent().getIntExtra(MeetActivity.POSITION, KEY_POSITION);
        conversationPosition = getIntent().getIntExtra(MeetActivity.CONVERSATION,conversationPosition);
        webservice = new OnlineIntegrationServiceSoapBinding();
        new GetMeetAsync().execute();
    }

    private void setComments(){
        ArrayList<HashMap<String, String>> commentList = new ArrayList<HashMap<String, String>>();
        Log.i("Conversation Size: ", meet.getConversations().size()+"");
        if(meet.getConversations().size()>0){

            for(ConversationData conversation : meet.getConversations()) {
                if(conversation.getId() == conversationPosition) {

                    for(UserContentData data : conversation.getConversation()) {

                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put(MeetActivity.USERNAME, data.getPoster());
                        map.put(MeetActivity.COMMENT, data.getText());
                        commentList.add(map);
                    }

                }
            }
            /*
            for(int i = 0; i<meet.getConversations().get(conversationPosition).getConversation().size() ; i++){
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(MeetActivity.USERNAME, MainActivity.meets.getMeets().get(meetPosition).getConversations().get(conversationPosition).getConversation().get(i).getPoster());
                map.put(MeetActivity.COMMENT, MainActivity.meets.getMeets().get(meetPosition).getConversations().get(conversationPosition).getConversation().get(i).getText());
                commentList.add(map);
            }
            */
            list = (ListView)findViewById(R.id.conversation_list);
            adapter = new MyCommentAdapter(this, commentList);
            list.setAdapter(adapter);
        }
    }
    public void putComment(View view) {
        if(comment.getText().toString().length()>2){
            commentToPost = comment.getText().toString();
            new CommentAsync().execute();
        }
        else {
            Toast.makeText(ConversationActivity.this, getString(R.string.question_to_short), Toast.LENGTH_SHORT).show();
        }
    }
    class CommentAsync extends AsyncTask<String, Integer, MeetResponse> {

        @Override
        protected MeetResponse doInBackground(String ... strings) {
            try {
                return webservice.replyToConversation(LoginActivity.session.getSessionData().getSessionID(),conversation.getId(), commentToPost);
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
           comment.setText("");
        }
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
            if(meet != null) {
            for(ConversationData data : meet.getConversations())
if(data.getId() == conversationPosition) {

this.conversation = data;
    setComments();
}
            }
        }
        else {
            Toast.makeText(ConversationActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }
}
