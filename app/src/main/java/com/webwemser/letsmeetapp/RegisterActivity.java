package com.webwemser.letsmeetapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;
import com.webwemser.web.OnlineIntegrationService;
import com.webwemser.web.SessionData;


public class RegisterActivity extends AppCompatActivity {

    private CheckedTextView check1, check2;
    private boolean savePassword, stayLoggedIn = true;
    private EditText username, password;
    private String userString, pwString;
    private final String TAG = "Webwemser Log";
    private OnlineIntegrationService webservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize Webservice
        webservice = new OnlineIntegrationService();

        //Needed to use the same fonts for username and password edittext
        username = (EditText)findViewById(R.id.username_reg);
        password = (EditText) findViewById(R.id.password_reg);
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

    //Signup method
    public void signup(View v){
        userString = username.getText().toString();
        pwString = password.getText().toString();
        if(username.getText().toString().length()>3){
            if(username.getText().toString().length()>5){
                new RegisterAsync().execute();
                //Intent intent = new Intent(this, MainActivity.class);
                //startActivity(intent);
                LoginActivity.sessionData = (SessionData)LoginActivity.session.getProperty(0);
                //LoginActivity.user = (user)LoginActivity.sessionData.getProperty(2);
                Toast.makeText(this, ""+LoginActivity.session.getProperty(1), Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, getString(R.string.short_password), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, getString(R.string.short_username), Toast.LENGTH_SHORT).show();
        }
    }

    class RegisterAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String ... strings) {
            LoginActivity.session = webservice.register(userString, pwString, "Ich bin Klaus");
            return "";
        }

        protected void onPostExecute(String result) {

        }
    }
}
