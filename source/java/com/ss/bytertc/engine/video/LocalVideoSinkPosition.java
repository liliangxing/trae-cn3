package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public enum LocalVideoSinkPosition {
    AFTER_CAPTURE(0),
    AFTER_PREPROCESS(1);

    private int value;

    LocalVideoSinkPosition(int v) {
        this.value = v;
    }

    public static LocalVideoSinkPosition convertFromInt(int v) {
        return values()[v];
    }

    public int getValue() {
        return this.value;
    }
}
