package com.bytedance.ies.web.jsbridge;

import android.util.Log;

/* loaded from: classes4.dex */
public class JSLog {
    private static boolean isDebug;

    public static void debug() {
        isDebug = true;
    }

    public static void d(String str) {
        if (isDebug) {
            Log.d("JsBridge", str);
        }
    }

    public static void e(String str) {
        if (isDebug) {
            Log.e("JsBridge", str);
        }
    }
}
