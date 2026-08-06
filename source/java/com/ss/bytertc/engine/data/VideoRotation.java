package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoRotation {
    VIDEO_ROTATION_0(0),
    VIDEO_ROTATION_90(90),
    VIDEO_ROTATION_180(180),
    VIDEO_ROTATION_270(270);

    private int value;

    VideoRotation(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static VideoRotation fromId(int id) {
        for (VideoRotation videoRotation : values()) {
            if (videoRotation.value() == id) {
                return videoRotation;
            }
        }
        return null;
    }
}
