package com.example.teodor.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by teodor on 2014-11-23.
 */
public class NetworkChangeReceiver extends BroadcastReceiver {

    public static List<String> changes = new ArrayList<String>();

    static Boolean connected;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("NetworkChangeReceiver", "onReceive");

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isWifiConnected = activeNetwork != null
                && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI
                && activeNetwork.isConnected();

        if (connected == null || connected != isWifiConnected) {
            connected = isWifiConnected;
            changes.add(new Date().toString());
        }
    }
}
