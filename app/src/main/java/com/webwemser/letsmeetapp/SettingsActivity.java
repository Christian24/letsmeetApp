package com.webwemser.letsmeetapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void openURL(View v){
        String url = getString(R.string.github);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
