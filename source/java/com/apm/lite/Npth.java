package com.apm.lite;

import com.apm.lite.runtime.C0831l;
import com.apm.lite.runtime.ConfigManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Npth {
    private static boolean sInit;

    public static void checkInnerNpth(boolean z) {
        C0831l.m1168b(z);
    }

    public static void enableAnrInfo(boolean z) {
        C0831l.m1165a(z);
    }

    public static void enableNativeDump(boolean z) {
        C0831l.m1171c(z);
    }

    public static ConfigManager getConfigManager() {
        return C0749e.m567i();
    }

    public static boolean hasCrash() {
        return C0831l.m1182i();
    }

    public static boolean hasCrashWhenJavaCrash() {
        return C0831l.m1183j();
    }

    public static boolean hasCrashWhenNativeCrash() {
        return C0831l.m1184k();
    }

    public static boolean isANREnable() {
        return C0831l.m1172c();
    }

    public static boolean isInit() {
        return sInit;
    }

    public static boolean isJavaCrashEnable() {
        return C0831l.m1169b();
    }

    public static boolean isNativeCrashEnable() {
        return C0831l.m1173d();
    }

    public static boolean isStopUpload() {
        return C0831l.m1185l();
    }

    public static void openANRMonitor() {
        C0831l.m1179g();
    }

    public static void openJavaCrashMonitor() {
        C0831l.m1177f();
    }

    public static boolean openNativeCrashMonitor() {
        return C0831l.m1181h();
    }

    public static void stopUpload() {
        C0831l.m1186m();
    }
}
