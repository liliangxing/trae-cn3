package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public enum VideoSinkMirrorType {
    ON(1),
    OFF(2);

    private int value;

    VideoSinkMirrorType(int v) {
        this.value = v;
    }

    public static VideoSinkMirrorType convertFromInt(int v) {
        if (v == 1) {
            return ON;
        }
        if (v == 2) {
            return OFF;
        }
        throw new IllegalArgumentException("VideoSinkMirrorType enum value invalidate: " + v);
    }

    public int getValue() {
        return this.value;
    }
}
