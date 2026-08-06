package com.ss.bytertc.base.media.screen;

import com.bytedance.realx.video.VideoFrame;

/* loaded from: classes7.dex */
public final class RTCScreenVideoNativeFunctions {
    public static native void nativeOnCapturerError(long captureObserverPtr, int error, String message);

    public static native void nativeOnCapturerSetType(long captureObserverPtr, int type);

    public static native void nativeOnCapturerStarted(long captureObserverPtr);

    public static native void nativeOnCapturerStopped(long captureObserverPtr);

    public static native void nativeOnFrameCaptured(long captureObserverPtr, VideoFrame videoFrame);
}
