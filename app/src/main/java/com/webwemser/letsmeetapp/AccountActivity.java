package com.webwemser.letsmeetapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.webwemser.web.KILOnlineIntegrationServiceSoapBinding;

public class AccountActivity extends AppCompatActivity {

    private TextView username;
    private EditText description;
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
        this.finish();
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
}
