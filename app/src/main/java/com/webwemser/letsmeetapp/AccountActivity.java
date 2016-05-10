package com.webwemser.letsmeetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    private TextView username;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //Initialize Views
        username = (TextView)findViewById(R.id.accounnt_name);
        description = (EditText)findViewById(R.id.account_description);
    }

    //Just closes the Activity at the moment, should later save account details
    public void saveAccount(View v){
        this.finish();
    }
}
