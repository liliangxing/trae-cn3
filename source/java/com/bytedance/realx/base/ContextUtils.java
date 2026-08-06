package com.bytedance.realx.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;

/* loaded from: classes4.dex */
public class ContextUtils {
    private static final String TAG = "ContextUtils";
    private static Context applicationContext;

    public static void initialize(Context applicationContext2) {
        if (applicationContext2 == null) {
            throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
        }
        applicationContext = applicationContext2;
    }

    @Deprecated
    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static String getAppPath() {
        return applicationContext.getExternalFilesDir("").toString();
    }

    public static String getAppLibPath(String libName) {
        if (TextUtils.isEmpty(libName)) {
            return "";
        }
        try {
            String findLibrary = ((BaseDexClassLoader) applicationContext.getClassLoader()).findLibrary(libName);
            return findLibrary == null ? "" : findLibrary;
        } catch (Exception e) {
            RXLogging.e("realx Utils", "getAppLibPath Exception : " + e.getMessage());
            Log.e("realx Utils", "getAppLibPath Exception : " + e.getMessage());
            throw e;
        }
    }
}
