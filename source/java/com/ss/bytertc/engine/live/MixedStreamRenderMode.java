package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamRenderMode {
    MIXED_STREAM_RENDER_MODE_HIDDEN(1),
    MIXED_STREAM_RENDER_MODE_FIT(2),
    MIXED_STREAM_RENDER_MODE_ADAPTIVE(3);

    private int renderMode;

    MixedStreamRenderMode(int value) {
        this.renderMode = value;
    }

    public int getValue() {
        return this.renderMode;
    }
}
