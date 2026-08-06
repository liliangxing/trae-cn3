package com.optimize.statistics;

import android.util.Log;

/* loaded from: classes7.dex */
public class StatLogUtils {
    public static final String TAG = "fresco_stat";
    private static boolean sIsDebug;

    public static void setsIsDebug(boolean z) {
        sIsDebug = z;
    }

    public static boolean IsDebug() {
        return sIsDebug;
    }

    public static void e(String str) {
        if (sIsDebug) {
            Log.e(TAG, str);
        }
    }
}
