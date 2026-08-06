package com.ss.bytertc.engine.device;

/* loaded from: classes7.dex */
public class MediaDeviceInfo {
    public DeviceError error;
    public String message;
    public DeviceState state;
    public DeviceType type;

    public MediaDeviceInfo(DeviceType type, DeviceState state, DeviceError error, String verbose) {
        this.type = type;
        this.state = state;
        this.error = error;
        this.message = verbose;
    }

    public String toString() {
        return "[type=" + this.type + ", state=" + this.state + ", error=" + this.error + ", msg=" + this.message + "]";
    }
}
