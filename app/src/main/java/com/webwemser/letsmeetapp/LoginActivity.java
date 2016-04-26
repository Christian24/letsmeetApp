package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Notwendig damit der Hint den gleichen Font hat wie der Username
        EditText password = (EditText) findViewById(R.id.password_text);
        password.setTransformationMethod(new PasswordTransformationMethod());
    }

    public void login(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void signup(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
