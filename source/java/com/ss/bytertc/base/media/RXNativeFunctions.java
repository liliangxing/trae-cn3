package com.ss.bytertc.base.media;

import com.bytedance.realx.video.VideoFrame;

/* loaded from: classes7.dex */
public final class RXNativeFunctions {
    public static native void nativeOnCapturerError(long captureObserverPtr, int error);

    public static native void nativeOnCapturerFormatSelected(long captureObserverPtr, int width, int height, int minFramerate, int maxFramerate, int pixelFormat);

    public static native void nativeOnCapturerStarted(long captureObserverPtr, boolean started);

    public static native void nativeOnCapturerStopped(long captureObserverPtr);

    public static native void nativeOnFrameCaptured(long captureObserverPtr, VideoFrame videoFrame);
}
