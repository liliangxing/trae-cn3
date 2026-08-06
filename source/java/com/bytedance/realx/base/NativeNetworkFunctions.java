package com.bytedance.realx.base;

/* loaded from: classes4.dex */
public final class NativeNetworkFunctions {
    public static native void nativeOnBlockedStatusChanged(String ifName, boolean blocked, long handler);

    public static native void nativeOnCapabilitiesChanged(String ifName, String capabilities, long handler);

    public static native void nativeOnLinkPropertiesChanged(String ifName, String properties, long handler);

    public static native void nativeOnNetworkAvailable(String ifName, long handler);

    public static native void nativeOnNetworkLost(String ifName, long handler);

    public static native void nativeOnNetworkResumed(String ifName, long handler);

    public static native void nativeOnNetworkSuspended(String ifName, long handler);

    public static native void nativeOnNetworkUnavailable(long handler);
}
