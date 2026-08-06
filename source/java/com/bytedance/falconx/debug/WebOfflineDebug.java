package com.bytedance.falconx.debug;

/* loaded from: classes3.dex */
public class WebOfflineDebug {
    private static boolean sIsDebug;

    public static boolean isDebug() {
        return sIsDebug;
    }

    public static void enable() {
        sIsDebug = true;
    }

    public static void disable() {
        sIsDebug = false;
    }
}
