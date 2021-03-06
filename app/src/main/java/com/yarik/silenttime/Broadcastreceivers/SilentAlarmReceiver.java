package com.yarik.silenttime.Broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yarik.silenttime.Services.SilentTimeService;


public class SilentAlarmReceiver extends BroadcastReceiver
{
    public static final String ACTION_START_SILENCER_SERVICE_ALARM = "com.yarik.silenttime.ACTION_START_SILENCER_SERVICE_ALARM";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String notifTime = intent.getStringExtra("notif_time");

        Intent service = new Intent(context, SilentTimeService.class);
        service.putExtra("notif_time", notifTime);
        service.putExtra("alarm_id", intent.getIntExtra("alarm_id", 0));

        context.startService(service);
    }
}