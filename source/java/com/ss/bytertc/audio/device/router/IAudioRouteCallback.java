package com.ss.bytertc.audio.device.router;

/* loaded from: classes7.dex */
public interface IAudioRouteCallback {
    void onDeviceEvent(int deviceType, boolean connected, String deviceInfo);

    void onError(int eventCode, String info);
}
