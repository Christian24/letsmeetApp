package com.webwemser.letsmeetapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.webwemser.web.OnlineIntegrationServiceSoapBinding;

public class AccountActivity extends AppCompatActivity {

    private TextView username, label;
    private EditText description, password;
    private String pw, desc = "";
    private OnlineIntegrationServiceSoapBinding webservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //Initialize Webservice
        webservice = new OnlineIntegrationServiceSoapBinding();

        //Initialize Views
        username = (TextView)findViewById(R.id.accounnt_name);
        description = (EditText)findViewById(R.id.account_description);
        label = (TextView)findViewById(R.id.account_password_label);
        password = (EditText)findViewById(R.id.account_password);

        //Insert user info
        try{
            username.setText(LoginActivity.session.getSessionData().getUserData().getUserName());
            description.setText(LoginActivity.session.getSessionData().getUserData().getDescription());
        }
        catch (NullPointerException e){
            username.setText(getString(R.string.error));
            description.setText(getString(R.string.error));
        }
    }

    //Just closes the Activity at the moment, should later save account details
    public void saveAccount(View v){
        desc = description.getText().toString();
        new UpdateDescriptionAsync().execute();
    }

    //Deletes account and launches LoginActivty
    public void deleteAccount(View v){
        new AlertDialog.Builder(AccountActivity.this)
                .setTitle(getString(R.string.delete_account))
                .setMessage(getString(R.string.delete_account_long))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        new DeleteUserAsync().execute();
                        Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_menu_delete)
                .show();
    }

    //Makes password views visible for user
    public void changePassword(View v){
        if(password.getVisibility() == View.INVISIBLE){
            label.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);
        }
        else {
            label.setVisibility(View.INVISIBLE);
            password.setVisibility(View.INVISIBLE);
        }
    }

    //Called on save user
    class UpdateDescriptionAsync extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {
                Log.i("Session ID ", LoginActivity.session.getSessionData().getSessionID());
                LoginActivity.session = webservice.updateUserDescription(LoginActivity.session.getSessionData().getSessionID(), desc);
                return LoginActivity.session.getSessionData().getSessionID();
            }
            catch (Exception e){
                return "";
            }
        }

        protected void onPostExecute(String response) {
            Log.i("LOG", response);
            if(Integer.parseInt(LoginActivity.session.getProperty(0).toString())==200){
                if(password.length()>5){
                    pw = password.getText().toString();
                    new UpdatePasswordAsync().execute();
                    AccountActivity.this.finish();
                }
                else{
                    if(password.getVisibility() == View.VISIBLE){
                        Toast.makeText(AccountActivity.this, getString(R.string.password_wasnt_changed), Toast.LENGTH_LONG).show();
                    }
                    AccountActivity.this.finish();
                }
            }
            else Toast.makeText(AccountActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }

    //Called on change password
    class UpdatePasswordAsync extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {
                Log.i("Session ID ", LoginActivity.session.getSessionData().getSessionID());
                LoginActivity.session = webservice.updateUserPassword(LoginActivity.session.getSessionData().getSessionID(), pw);
                return LoginActivity.session.getSessionData().getSessionID();
            }
            catch (Exception e){
                return "";
            }
        }

        protected void onPostExecute(String response) {
            Log.i("LOG", response);
            if(Integer.parseInt(LoginActivity.session.getProperty(0).toString())==200){
                Toast.makeText(AccountActivity.this, getString(R.string.password_success), Toast.LENGTH_LONG).show();
                AccountActivity.this.finish();
            }
            else Toast.makeText(AccountActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }

    //Called on deleteUser
    class DeleteUserAsync extends AsyncTask<String, String, Integer> {

        @Override
        protected Integer doInBackground(String ... strings) {
            try {
                return webservice.deleteUser(LoginActivity.session.getSessionData().getSessionID()).getReturnCode();
            }
            catch (Exception e){
                return 0;
            }
        }

        protected void onPostExecute(Integer response) {
            Log.i("LOG", "Delete Response: " +response);
            if(response==200){
                Toast.makeText(AccountActivity.this, getString(R.string.delete_account_successful), Toast.LENGTH_LONG).show();
                AccountActivity.this.finish();
            }
            else Toast.makeText(AccountActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }
}
