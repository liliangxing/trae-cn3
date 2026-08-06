package com.ss.bytertc.engine.loader;

/* loaded from: classes7.dex */
public class RTCNativeLibraryLoaderAdapter {
    protected static RTCNativeLibraryLoader mRtcNativeLibraryLoader = new RTCNativeLibraryLoaderImpl();

    public static void setRtcNativeLibraryLoader(RTCNativeLibraryLoader rtcNativeLibraryLoader) {
        mRtcNativeLibraryLoader = rtcNativeLibraryLoader;
    }

    public static RTCNativeLibraryLoader getRtcNativeLibraryLoader() {
        return mRtcNativeLibraryLoader;
    }
}
