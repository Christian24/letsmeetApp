package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private CheckedTextView check1, check2;
    private boolean savePassword, stayLoggedIn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Needed to use the same fonts for username and password edittext
        EditText password = (EditText) findViewById(R.id.password_text);
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Signup method
    public void signup(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
