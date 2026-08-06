package com.bytedance.applog.log;

/* loaded from: classes3.dex */
public class NativeLogWrapper {
    private static native void nativeSetLogEnable(boolean z);

    public static void setLogEnable(boolean z) {
        try {
            nativeSetLogEnable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
