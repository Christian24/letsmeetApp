package com.webwemser.letsmeetapp;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Helps for checking network state
 * @author Jannik
 */
public class ConnectionHelper {

    //Check for internet connection
    public boolean isOnline(Activity a) {
        ConnectivityManager cm = (ConnectivityManager) a.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if(!(netInfo != null && netInfo.isConnectedOrConnecting())) {
            Toast.makeText(a, a.getString(R.string.check_connection), Toast.LENGTH_SHORT).show();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
