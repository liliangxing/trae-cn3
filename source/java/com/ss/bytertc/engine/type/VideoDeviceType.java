package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum VideoDeviceType {
    VIDEO_DEVICE_TYPE_UNKNOWN(-1),
    VIDEO_DEVICE_TYPE_RENDER_DEVICE(0),
    VIDEO_DEVICE_TYPE_CAPTURE_DEVICE(1),
    VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE(2);

    private final int value;

    VideoDeviceType() {
        this.value = 0;
    }

    public int value() {
        return this.value;
    }

    VideoDeviceType(int value) {
        this.value = value;
    }

    public static VideoDeviceType fromId(int id) {
        for (VideoDeviceType videoDeviceType : values()) {
            if (videoDeviceType.value() == id) {
                return videoDeviceType;
            }
        }
        return VIDEO_DEVICE_TYPE_UNKNOWN;
    }
}
