package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum SubscribeMediaType {
    NONE(0),
    AUDIO_ONLY(1),
    VIDEO_ONLY(2),
    AUDIO_AND_VIDEO(3);

    private int value;

    SubscribeMediaType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
