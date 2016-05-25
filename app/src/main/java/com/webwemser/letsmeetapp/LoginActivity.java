package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;
import com.webwemser.web.OnlineIntegrationService;
import com.webwemser.web.sessionData;
import com.webwemser.web.sessionResponse;
import com.webwemser.web.user;

public class LoginActivity extends AppCompatActivity {

    private CheckedTextView check1, check2;
    private boolean savePassword, stayLoggedIn = true;
    private EditText username, password;
    public static OnlineIntegrationService webservice;
    public static sessionResponse session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize Webservice
        webservice = new OnlineIntegrationService();

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
        session = new sessionResponse();
        if(username.getText().toString().length()>3){
            if(username.getText().toString().length()>5){
                session = webservice.login(username.getText().toString(), password.getText().toString());
                //Intent intent = new Intent(this, MainActivity.class);
                //startActivity(intent);
                Toast.makeText(this, ""+session.getProperty(1), Toast.LENGTH_SHORT).show();
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
}
