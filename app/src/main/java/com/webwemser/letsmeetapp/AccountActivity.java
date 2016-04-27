package com.webwemser.letsmeetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    //Just closes the Activity at the moment, should later save account details
    public void saveAccount(View v){
        this.finish();
    }
}
