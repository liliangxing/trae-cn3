package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public enum VideoApplyRotation {
    DEFAULT(-1),
    DEGREE_0(0);

    private int value;

    VideoApplyRotation(int v) {
        this.value = v;
    }

    public static VideoApplyRotation convertFromInt(int v) {
        if (v == -1) {
            return DEFAULT;
        }
        if (v == 0) {
            return DEGREE_0;
        }
        throw new IllegalArgumentException("VideoApplyRotation enum value invalidate: " + v);
    }

    public int getValue() {
        return this.value;
    }
}
