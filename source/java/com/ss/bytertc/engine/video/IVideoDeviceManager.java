package com.ss.bytertc.engine.video;

import java.util.List;

/* loaded from: classes7.dex */
public interface IVideoDeviceManager {
    List<VideoDeviceInfo> enumerateVideoCaptureDevices();

    int setVideoCaptureDevice(final String deviceId);
}
