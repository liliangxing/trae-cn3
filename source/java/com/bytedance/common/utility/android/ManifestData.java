package com.bytedance.common.utility.android;

import android.content.Context;

/* loaded from: classes3.dex */
public class ManifestData {
    private static Object readKey(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getString(Context context, String str) {
        Object readKey = readKey(context, str);
        if (readKey == null) {
            return null;
        }
        return (String) readKey;
    }

    public static int getInt(Context context, String str) {
        Object readKey = readKey(context, str);
        if (readKey == null) {
            return -1;
        }
        return ((Integer) readKey).intValue();
    }

    public static Boolean getBoolean(Context context, String str) {
        Object readKey = readKey(context, str);
        if (readKey == null) {
            return null;
        }
        return (Boolean) readKey;
    }

    public static Object get(Context context, String str) {
        return readKey(context, str);
    }
}
