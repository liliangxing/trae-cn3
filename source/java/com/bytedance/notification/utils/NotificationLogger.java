package com.bytedance.notification.utils;

import com.bytedance.push.utils.Logger;

/* loaded from: classes4.dex */
public class NotificationLogger {
    private static String TAG = "PushNotification";

    public static void d(String str) {
        d("", str);
    }

    public static void d(String str, String str2) {
        Logger.d(TAG, str + "\t>>>\t" + str2);
    }

    public static void e(String str) {
        e("", str);
    }

    public static void e(String str, String str2) {
        Logger.e(TAG, str + "\t>>> " + str2);
    }

    public static void i(String str) {
        i("", str);
    }

    public static void i(String str, String str2) {
        Logger.i(TAG, str + "\t>>>\t" + str2);
    }

    public static void i(String str, String str2, Throwable th) {
        Logger.i(str, str2, th);
    }

    public static void v(String str) {
        v("", str);
    }

    public static void v(String str, String str2) {
        Logger.v(TAG, str + "\t>>>\t" + str2);
    }
}
