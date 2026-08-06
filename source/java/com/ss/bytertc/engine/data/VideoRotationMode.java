package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoRotationMode {
    FOLLOW_APP(0),
    FOLLOW_GSENSOR(1);

    private int value;

    VideoRotationMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == FOLLOW_GSENSOR ? "kVideoRotationModeFollowGSensor" : "kVideoRotationModeFollowApp";
    }

    public static VideoRotationMode fromId(int id) {
        for (VideoRotationMode videoRotationMode : values()) {
            if (videoRotationMode.value() == id) {
                return videoRotationMode;
            }
        }
        return null;
    }
}
