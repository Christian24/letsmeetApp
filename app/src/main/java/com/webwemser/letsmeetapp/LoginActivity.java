package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;
import com.webwemser.web.OnlineIntegrationService;
import com.webwemser.web.SessionData;
import com.webwemser.web.SessionResponse;
import com.webwemser.web.User;

public class LoginActivity extends AppCompatActivity {

    private CheckedTextView check1, check2;
    private boolean savePassword, stayLoggedIn = true;
    private EditText username, password;
    private OnlineIntegrationService webservice;
    public static SessionResponse session;
    public static User user;
    public static SessionData sessionData;
    private final String TAG = "Webwemser Log";
    private String userString, pwString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize Webservice
        webservice = new OnlineIntegrationService();
        user = new User();
        sessionData = new SessionData();
        session = new SessionResponse();

        //Needed to use the same fonts for username and password edittext
        username = (EditText)findViewById(R.id.username_text);
        password = (EditText)findViewById(R.id.password_text);
        password.setTransformationMethod(new PasswordTransformationMethod());

        //Prepare Checked Text Views with Onclicklisteners
        check1 = (CheckedTextView)findViewById(R.id.check1);
        check2 = (CheckedTextView)findViewById(R.id.check2);
        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1.isChecked()){
                    check1.setChecked(false);
                    savePassword = false;}
                else{
                    check1.setChecked(true);
                    savePassword = true;}
            }
        });
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check2.isChecked()){
                    check2.setChecked(false);
                    stayLoggedIn = false;}
                else{
                    check2.setChecked(true);
                    stayLoggedIn = true;}
            }
        });
    }

    //Login method
    public void login(View v){
        userString = username.getText().toString();
        pwString = password.getText().toString();
        if(username.getText().toString().length()>3){
            if(username.getText().toString().length()>5){
                new LoginAsync().execute();
                //Intent intent = new Intent(this, MainActivity.class);
                //startActivity(intent);
                if(session==null)Log.i(TAG, "SessionResponse = null");
                else Log.i(TAG, "SessionResponse not null");
            }
            else{
                Toast.makeText(this, getString(R.string.short_password), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, getString(R.string.short_username), Toast.LENGTH_SHORT).show();
        }
    }

    //Signup method for starting the signup Activty
    public void signupActivty(View v){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    class LoginAsync extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String ... strings) {
            session = webservice.login(userString, pwString);
            return "";
        }

        protected void onPostExecute(String result) {

        }
    }
}
