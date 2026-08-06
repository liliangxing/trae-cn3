package com.bytedance.crash.npth_repair.utils;

import android.util.Log;

/* loaded from: classes3.dex */
public class RepairLog {
    private static final String TAG = "NpthRepair";
    private static boolean debuggable;

    public static void d(Object obj) {
        if (debuggable) {
            Log.d(TAG, String.valueOf(obj));
        }
    }

    public static void i(Object obj) {
        if (debuggable) {
            Log.i(TAG, String.valueOf(obj));
        }
    }

    public static void d(String str, Object obj) {
        if (debuggable) {
            Log.i(TAG, str + " " + obj);
        }
    }

    public static void i(String str, Object obj) {
        if (debuggable) {
            Log.i(TAG, str + " " + obj);
        }
    }

    public static void setDebuggable(boolean z) {
        debuggable = z;
    }

    public static boolean getDebuggable() {
        return debuggable;
    }
}
