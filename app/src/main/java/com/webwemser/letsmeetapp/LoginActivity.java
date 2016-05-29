package com.webwemser.letsmeetapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;
import com.webwemser.web.KILOnlineIntegrationServiceSoapBinding;
import com.webwemser.web.KILsessionResponse;

public class LoginActivity extends AppCompatActivity {

    private CheckedTextView check1, check2;
    private boolean savePassword, stayLoggedIn = true;
    private EditText username, password;
    private KILOnlineIntegrationServiceSoapBinding webservice;
    public static KILsessionResponse session;
    private final String TAG = "Webwemser Log";
    private String userString, pwString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize Webservice
        webservice = new KILOnlineIntegrationServiceSoapBinding();

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

    //Check for internet connection
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    //Login method
    public void login(View v){
        if(isOnline()){
            userString = username.getText().toString();
            pwString = password.getText().toString();
            if(username.getText().toString().length()>3){
                if(password.getText().toString().length()>5){
                    new LoginAsync().execute();
                }
                else{
                    Toast.makeText(this, getString(R.string.short_password), Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, getString(R.string.short_username), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, getString(R.string.check_connection), Toast.LENGTH_SHORT).show();
        }
    }

    //Signup method for starting the signup Activty
    public void signupActivty(View v){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    //Called by login method
    class LoginAsync extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String ... strings) {
            try{
                session = webservice.login(userString, pwString);
            }
            catch (Exception e){

            }
            return "";
        }

        protected void onPostExecute(String result) {
            Log.i(TAG, session.getProperty(0)+"");
            if(Integer.parseInt(session.getProperty(0).toString())==200){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(LoginActivity.this, getString(R.string.wrong_credentials), Toast.LENGTH_LONG).show();
            }
        }
    }
}
