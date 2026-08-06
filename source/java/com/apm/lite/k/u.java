package com.apm.lite.k;

/* loaded from: classes2.dex */
public class u {
    public static boolean a(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
