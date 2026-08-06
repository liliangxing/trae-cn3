package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum SubscribeMode {
    AUTO_SUBSCRIBE_MODE(0),
    MANUAL_SUBSCRIBE_MODE(1);

    private int value;

    SubscribeMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
