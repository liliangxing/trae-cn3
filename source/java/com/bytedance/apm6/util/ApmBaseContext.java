package com.bytedance.apm6.util;

import android.app.Application;
import android.content.Context;

/* loaded from: classes3.dex */
public class ApmBaseContext {
    private static Application context;
    private static boolean debugMode;
    private static boolean systraceMode;

    public static void setDebugMode(boolean z) {
        debugMode = z;
    }

    public static boolean isDebugMode() {
        return debugMode && !systraceMode;
    }

    public static void setSystraceMode(boolean z) {
        systraceMode = z;
    }

    public static boolean isSystraceMode() {
        return systraceMode;
    }

    public static Application getContext() {
        return context;
    }

    public static void setContext(Context context2) {
        if (context2 != null) {
            context = getApplication(context2);
        }
    }

    private static Application getApplication(Context context2) {
        if (context2 == null) {
            return null;
        }
        if (!(context2 instanceof Application)) {
            context2 = context2.getApplicationContext();
        }
        return (Application) context2;
    }
}
