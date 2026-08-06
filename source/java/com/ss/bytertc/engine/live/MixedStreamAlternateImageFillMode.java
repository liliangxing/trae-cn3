package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamAlternateImageFillMode {
    FIT(0),
    FILL(1);

    private int imageFillMode;

    MixedStreamAlternateImageFillMode(int value) {
        this.imageFillMode = value;
    }

    public int getValue() {
        return this.imageFillMode;
    }
}
