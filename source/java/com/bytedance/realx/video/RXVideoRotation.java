package com.bytedance.realx.video;

/* loaded from: classes4.dex */
public enum RXVideoRotation {
    VIDEO_ROTATION_0(0),
    VIDEO_ROTATION_90(90),
    VIDEO_ROTATION_180(180),
    VIDEO_ROTATION_270(270);

    private int value;

    RXVideoRotation(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RXVideoRotation fromId(int id) {
        for (RXVideoRotation rXVideoRotation : values()) {
            if (rXVideoRotation.value() == id) {
                return rXVideoRotation;
            }
        }
        return null;
    }
}
