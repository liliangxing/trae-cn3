package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class NativeAudioDeviceManagerFunctions {
    public static native int nativeStartAudioDeviceRecordTest(long audioDeviceManagerPtr, int interval);

    public static native int nativeStartAudioPlaybackDeviceTest(long audioDeviceManagerPtr, String path, int interval);

    public static native int nativeStopAudioDevicePlayTest(long audioDeviceManagerPtr);

    public static native int nativeStopAudioDeviceRecordAndPlayTest(long audioDeviceManagerPtr);

    public static native int nativeStopAudioPlaybackDeviceTest(long audioDeviceManagerPtr);
}
