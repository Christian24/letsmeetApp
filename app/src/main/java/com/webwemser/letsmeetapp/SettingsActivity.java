package com.webwemser.letsmeetapp;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private TextView verinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Initialize views
        verinfo = (TextView)findViewById(R.id.verinfo_num);

        //Sets current appversion
        try{
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            verinfo.setText(pInfo.versionName);
        }
        catch (PackageManager.NameNotFoundException e){
            verinfo.setText("n/a");
        }

    }
}
