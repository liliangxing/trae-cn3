package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RangeAudioMode {
    RANGE_AUDIO_MODE_UNDEFINED(0),
    RANGE_AUDIO_MODE_TEAM(1),
    RANGE_AUDIO_MODE_WORLD(2);

    private int value;

    RangeAudioMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
