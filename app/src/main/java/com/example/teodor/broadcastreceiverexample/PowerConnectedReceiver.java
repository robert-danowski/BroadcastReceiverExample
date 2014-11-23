package com.example.teodor.broadcastreceiverexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by teodor on 2014-11-23.
 */
public class PowerConnectedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("PowerConnectedReceiver", "onReceive");
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("Power connection changed");
        builder.setContentText("Detected power connection change");

        Intent activityIntent = new Intent(context, MainActivity.class);
        PendingIntent activity = PendingIntent.getActivity(context, 1, activityIntent, 0);
        builder.setContentIntent(activity);

        NotificationManager notificationService = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationService.notify((int) System.currentTimeMillis(), builder.build());

    }
}
