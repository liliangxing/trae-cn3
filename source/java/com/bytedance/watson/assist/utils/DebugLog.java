package com.bytedance.watson.assist.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/* loaded from: classes6.dex */
public class DebugLog {
    private static final String TAG = "watson_assist";
    private static boolean sDebug = Log.isLoggable(TAG, 3);

    public static void v(String str) {
        v(TAG, str);
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static void v(String str, String str2) {
        if (sDebug) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (sDebug) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        Log.i(str, str2);
    }

    public static void w(String str, String str2) {
        Log.w(str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static void toast(Context context, String str) {
        Toast.makeText(context, str, 1).show();
    }
}
