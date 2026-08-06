package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.VideoDeviceInfo;
import java.util.List;

/* loaded from: classes7.dex */
public class NativeVideoDeviceManagerFunctions {
    public static native List<VideoDeviceInfo> nativeEnumerateVideoCaptureDevices(long videoDeviceManager);

    public static native int nativeSetVideoCaptureDevice(long videoDeviceManager, String deviceId);
}
