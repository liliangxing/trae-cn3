package com.ss.bytertc.base.media.camera;

import com.ss.bytertc.base.media.camera.CameraEnumerationAndroid;
import com.ss.bytertc.base.media.camera.CameraVideoCapturer;
import java.util.List;

/* loaded from: classes7.dex */
public interface CameraEnumerator {
    CameraVideoCapturer createCapturer(String deviceName, CameraVideoCapturer.CameraEventsHandler eventsHandler);

    String[] getDeviceNames();

    int getDeviceOrientation(String deviceName);

    List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String deviceName);

    boolean isBackFacing(String deviceName);

    boolean isFrontFacing(String deviceName);
}
