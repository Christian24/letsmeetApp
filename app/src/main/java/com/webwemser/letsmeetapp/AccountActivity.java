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
import com.webwemser.web.KILOnlineIntegrationServiceSoapBinding;

public class AccountActivity extends AppCompatActivity {

    private TextView username;
    private EditText description;
    private String pw, desc = "";
    private KILOnlineIntegrationServiceSoapBinding webservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //Initialize Webservice
        webservice = new KILOnlineIntegrationServiceSoapBinding();

        //Initialize Views
        username = (TextView)findViewById(R.id.accounnt_name);
        description = (EditText)findViewById(R.id.account_description);

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
        final EditText edt = new EditText(getApplicationContext());
        edt.setTextColor(getResources().getColor(R.color.black));
        edt.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        edt.setHint("Enter password");
        new AlertDialog.Builder(AccountActivity.this)
                .setTitle(getString(R.string.enter_password))
                .setView(edt)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(edt.getText().toString().length()>5){
                            pw = edt.getText().toString();
                            desc = description.getText().toString();
                            new UpdateUserAsync().execute();
                        }
                        else {
                            Toast.makeText(AccountActivity.this, getString(R.string.wrong_password), Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    //Deletes account and launches LoginActivty
    public void deleteAccount(View v){
        new AlertDialog.Builder(AccountActivity.this)
                .setTitle(getString(R.string.delete_account))
                .setMessage(getString(R.string.delete_account_long))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AccountActivity.this, getString(R.string.delete_account_successful), Toast.LENGTH_LONG).show();
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

    //Called on save user
    class UpdateUserAsync extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {
                LoginActivity.session = webservice.updateUser(LoginActivity.session.getSessionData().getSessionID(), pw, desc);
                return LoginActivity.session.getSessionData().getSessionID();
            }
            catch (Exception e){
                return "";
            }
        }

        protected void onPostExecute(String response) {
            Log.i("LOG", response);
            if(Integer.parseInt(LoginActivity.session.getProperty(0).toString())==200){
                AccountActivity.this.finish();
            }
        }
    }
}
