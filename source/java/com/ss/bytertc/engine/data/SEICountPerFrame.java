package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum SEICountPerFrame {
    SEI_COUNT_PER_FRAME_SINGLE(0),
    SEI_COUNT_PER_FRAME_MULTI(1);

    private int value;

    SEICountPerFrame(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static SEICountPerFrame fromId(int id) {
        for (SEICountPerFrame sEICountPerFrame : values()) {
            if (sEICountPerFrame.value() == id) {
                return sEICountPerFrame;
            }
        }
        return null;
    }
}
