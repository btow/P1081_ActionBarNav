package com.example.samsung.p1081_actionbarnav;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by samsung on 04.05.2017.
 */

class Messager {

    private final static String LOG_TAG = "myLogs";

    public static void sendToAllRecipients(final Context context, final String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Log.d(LOG_TAG, message);
    }

    public static void sendToOnlyLog(final String message) {
        Log.d(LOG_TAG, message);
    }
}
