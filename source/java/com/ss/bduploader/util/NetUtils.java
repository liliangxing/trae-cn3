package com.ss.bduploader.util;

import android.content.Context;

/* loaded from: classes7.dex */
public class NetUtils {
    private static Context gContext;

    public static Context getApplicationContext() {
        return gContext;
    }

    public static void setApplicationContext(Context context) {
        if (gContext == null) {
            gContext = context;
        }
    }
}
