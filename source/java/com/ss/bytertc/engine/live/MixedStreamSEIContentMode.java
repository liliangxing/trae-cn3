package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamSEIContentMode {
    MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT(0),
    MIXED_STREAM_SEI_CONTENT_MODE_ENABLE_VOLUME_INDICATION(1);

    private int seiContentMode;

    MixedStreamSEIContentMode(int value) {
        this.seiContentMode = value;
    }

    public int getValue() {
        return this.seiContentMode;
    }
}
