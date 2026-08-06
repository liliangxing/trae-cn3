package com.ss.bytertc.base.media;

/* loaded from: classes7.dex */
public final class RTCNativeFunctions {
    public static native void nativeNotifyChoreographerDoFrame(long nativeSurfaceHolderCallbackPtr, Object surface, String renderTaskUUID);

    public static native void nativeNotifySurfaceAvailable(long nativeSurfaceHolderCallbackPtr, Object surface, String renderTaskUUID, boolean isSurfaceTexture, boolean isAGFX);

    public static native void nativeNotifySurfaceDestroyed(long nativeSurfaceHolderCallbackPtr, Object surface, String renderTaskUUID, boolean isSurfaceTexture, boolean isAGFX);

    public static native void nativeNotifySurfaceSizeChanged(long nativeSurfaceHolderCallbackPtr, String renderTaskUUID, boolean isAGFX);

    public static native void nativeNotifyVSyncDoFrame(long nativeSurfaceHolderCallbackPtr, String renderTaskUUID);
}
