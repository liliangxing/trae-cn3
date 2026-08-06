package com.lynx.animax.player;

/* loaded from: classes6.dex */
public class NativePlayerCallback {
    private static native void nativeOnError(long j, String str);

    public static void onError(long j, String str) {
        nativeOnError(j, str);
    }
}
