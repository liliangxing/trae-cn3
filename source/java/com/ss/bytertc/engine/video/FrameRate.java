package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public enum FrameRate {
    FRAME_RATE_FPS_1(1),
    FRAME_RATE_FPS_7(7),
    FRAME_RATE_FPS_10(10),
    FRAME_RATE_FPS_15(15),
    FRAME_RATE_FPS_24(24),
    FRAME_RATE_FPS_30(30);

    private final int value;

    FrameRate(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
