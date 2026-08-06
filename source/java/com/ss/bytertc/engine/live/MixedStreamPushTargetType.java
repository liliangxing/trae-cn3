package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamPushTargetType {
    PUSH_TO_CDN(0),
    PUSH_TO_WTN(1);

    private int targetType;

    MixedStreamPushTargetType(int value) {
        this.targetType = value;
    }

    public int value() {
        return this.targetType;
    }
}
