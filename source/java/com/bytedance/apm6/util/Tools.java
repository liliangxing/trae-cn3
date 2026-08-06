package com.bytedance.apm6.util;

import android.os.Handler;
import android.os.Looper;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public final class Tools {
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static byte[] safeGetBytes(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return str.getBytes("UTF-8");
                }
            } catch (UnsupportedEncodingException unused) {
                return str.getBytes();
            }
        }
        return null;
    }

    public static void runOnUiThread(Runnable runnable) {
        sHandler.post(runnable);
    }
}
