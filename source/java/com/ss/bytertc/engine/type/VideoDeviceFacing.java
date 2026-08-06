package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum VideoDeviceFacing {
    FRONT(0),
    BACK(1),
    UNKNOWN(2);

    private int value;

    VideoDeviceFacing(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static VideoDeviceFacing fromId(int id) {
        for (VideoDeviceFacing videoDeviceFacing : values()) {
            if (videoDeviceFacing.value() == id) {
                return videoDeviceFacing;
            }
        }
        return null;
    }
}
