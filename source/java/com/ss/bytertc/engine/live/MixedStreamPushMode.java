package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamPushMode {
    ON_STREAM(0),
    ON_START_REQUEST(1);

    private int pushMode;

    MixedStreamPushMode(int value) {
        this.pushMode = value;
    }

    public int getValue() {
        return this.pushMode;
    }
}
