package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AttenuationType {
    ATTENUATION_TYPE_NONE(0),
    ATTENUATION_TYPE_LINEAR(1),
    ATTENUATION_TYPE_EXPONENTIAL(2);

    private final int value;

    public int value() {
        return this.value;
    }

    AttenuationType(int value) {
        this.value = value;
    }
}
