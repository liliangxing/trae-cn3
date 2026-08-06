package com.bytedance.lynx.scc.cloudservice.utils;

import android.util.Log;

/* loaded from: classes4.dex */
public class Logger {
    private Logger() {
    }

    public static void v(String msg) {
        Log.v(SccUtils.LOG_TAG, msg);
    }

    public static void d(String msg) {
        Log.d(SccUtils.LOG_TAG, msg);
    }

    public static void i(String msg) {
        Log.i(SccUtils.LOG_TAG, msg);
    }

    public static void w(String msg) {
        Log.w(SccUtils.LOG_TAG, msg);
    }

    public static void e(String msg) {
        Log.e(SccUtils.LOG_TAG, msg);
    }
}
