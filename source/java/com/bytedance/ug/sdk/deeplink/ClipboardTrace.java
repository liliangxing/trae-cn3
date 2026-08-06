package com.bytedance.ug.sdk.deeplink;

/* loaded from: classes4.dex */
public class ClipboardTrace {
    private static boolean sHasPrimaryClipCalled;

    public static void setHasPrimaryClipCalled(boolean z) {
        sHasPrimaryClipCalled = z;
    }

    public static boolean getHasPrimaryClipCalled() {
        return sHasPrimaryClipCalled;
    }
}
