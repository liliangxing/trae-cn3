package com.ss.bytertc.base.utils;

import android.content.Context;
import com.bytedance.realx.base.ContextUtils;

/* loaded from: classes7.dex */
public class RtcContextUtils {
    private static final String TAG = "ContextUtils";
    private static Context applicationContext;

    public static void initialize(Context applicationContext2) {
        if (applicationContext2 == null) {
            throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
        }
        ContextUtils.initialize(applicationContext2.getApplicationContext());
    }

    public static Context getApplicationContext() {
        return ContextUtils.getApplicationContext();
    }

    public static String getAppExternalPath() {
        return ContextUtils.getAppPath();
    }
}
