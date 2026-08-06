package com.ss.vcbkit;

import com.bytedance.crash.Ensure;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UnExpected {
    private static boolean isModuleLoaded;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init() {
        if (isModuleLoaded) {
            return;
        }
        try {
            Ensure.getInstance();
            isModuleLoaded = true;
        } catch (Throwable unused) {
            isModuleLoaded = false;
        }
    }

    public static void notReachHere(Throwable th, String str) {
        if (isModuleLoaded) {
            Ensure.ensureNotReachHere(th, str);
        }
    }

    public static void notReachHere(Throwable th, String str, Map<String, String> map) {
        if (isModuleLoaded) {
            Ensure.ensureNotReachHere(th, str, map);
        }
    }

    private static void notReachHereNative(String str, String str2, Map<String, String> map) {
        if (isModuleLoaded) {
            Ensure.ensureNativeStack(str, "", Thread.currentThread().getName(), str2, map);
        }
    }
}
