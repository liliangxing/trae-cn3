package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.type.VideoDeviceFacing;

/* loaded from: classes7.dex */
public class VideoDeviceInfo {
    public VideoDeviceFacing deviceFacing;
    public String deviceId;
    public String deviceName;

    public VideoDeviceInfo() {
        this.deviceId = "";
        this.deviceName = "";
        this.deviceFacing = VideoDeviceFacing.UNKNOWN;
    }

    public VideoDeviceInfo(String deviceId, String deviceName, VideoDeviceFacing deviceFacing) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceFacing = deviceFacing;
    }

    public static VideoDeviceInfo create(String deviceId, String deviceName, VideoDeviceFacing deviceFacing) {
        return new VideoDeviceInfo(deviceId, deviceName, deviceFacing);
    }
}
