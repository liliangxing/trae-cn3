package com.bytedance.push.helper;

import com.bytedance.services.apm.api.EnsureManager;

/* loaded from: classes4.dex */
public class EnsureExceptionHelper {
    private static Boolean hasAmpApi;

    public static void ensureNotReachHere(Throwable th, String str) {
        Boolean bool = hasAmpApi;
        if (bool == null || bool.booleanValue()) {
            try {
                EnsureManager.ensureNotReachHere(th, str);
                hasAmpApi = true;
            } catch (Throwable unused) {
                hasAmpApi = false;
            }
        }
    }

    public static void ensureNotReachHere(String str) {
        Boolean bool = hasAmpApi;
        if (bool == null || bool.booleanValue()) {
            try {
                EnsureManager.ensureNotReachHere(str);
                hasAmpApi = true;
            } catch (Throwable unused) {
                hasAmpApi = false;
            }
        }
    }
}
