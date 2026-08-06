package com.ss.bytertc.base.media.screen;

/* loaded from: classes7.dex */
public final class RTCScreenAudioNativeFunctions {
    public static native void nativeOnAuidoFrameCaptured(long captureObserverPtr, byte[] audioFrame, int samples, int sampleRate, int channel);

    public static native void nativeOnCapturerError(long captureObserverPtr, int error);

    public static native void nativeOnCapturerStarted(long captureObserverPtr);

    public static native void nativeOnCapturerStopped(long captureObserverPtr);
}
