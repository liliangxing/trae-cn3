package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum InterpolationMode {
    LAST_FRAME_FILL(0),
    BACKGROUND_IMAGE_FILL(1);

    private int mode;

    InterpolationMode(int value) {
        this.mode = value;
    }

    public int value() {
        return this.mode;
    }
}
