package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum StreamLayoutMode {
    AUTO(0),
    CUSTOM(2);

    private int mode;

    StreamLayoutMode(int value) {
        this.mode = value;
    }

    public int value() {
        return this.mode;
    }
}
