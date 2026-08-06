package com.lynx.canvas;

/* loaded from: classes6.dex */
public enum SurfaceScaleMode {
    SCALE_TO_FILL(0),
    SCALE_TO_CENTER(1),
    SCALE_TO_FILL_AND_CROP(2),
    SCALE_TO_FILL_WITH_SOURCE_CROP(3);

    public final int value;

    SurfaceScaleMode(int i) {
        this.value = i;
    }
}
