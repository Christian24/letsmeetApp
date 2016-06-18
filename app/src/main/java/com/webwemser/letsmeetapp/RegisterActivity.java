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
import com.webwemser.web.OnlineIntegrationServiceSoapBinding;

/**
 * For signing up to letsmeet
 * @author Jannik
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText username, password, passwordRetype, description;
    private String userString, pwString, descriptionString;
    private OnlineIntegrationServiceSoapBinding webservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize Webservice
        webservice = new OnlineIntegrationServiceSoapBinding();

        //Needed to use the same fonts for username and password edittext
        username = (EditText)findViewById(R.id.username_reg);
        description = (EditText)findViewById(R.id.description_reg);
        password = (EditText) findViewById(R.id.password_reg);
        passwordRetype = (EditText) findViewById(R.id.password_reg_retype);
        password.setTransformationMethod(new PasswordTransformationMethod());
        passwordRetype.setTransformationMethod(new PasswordTransformationMethod());
    }

    //Signup method
    public void signup(View v){
        if(isOnline()){
            userString = username.getText().toString();
            pwString = password.getText().toString();
            descriptionString = description.getText().toString();
            if(username.getText().toString().length()>3){
                if(password.getText().toString().length()>5){
                    if(password.getText().toString().equals(passwordRetype.getText().toString())){
                        new RegisterAsync().execute();
                    }
                    else {
                        Toast.makeText(this, getString(R.string.password_retype_error), Toast.LENGTH_SHORT).show();
                    }
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

    //Check for internet connection
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    //Called by register method
    class RegisterAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String ... strings) {
            try {
                LoginActivity.session = webservice.register(userString, pwString, descriptionString);
            }
            catch (Exception e){

            }
            return "";
        }

        protected void onPostExecute(String result) {
            if(LoginActivity.session!=null){
                if(LoginActivity.session.getReturnCode()==200){
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(RegisterActivity.this, getString(R.string.taken_username), Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(RegisterActivity.this, getString(R.string.server_not_accessible), Toast.LENGTH_LONG).show();
            }
        }
    }
}
