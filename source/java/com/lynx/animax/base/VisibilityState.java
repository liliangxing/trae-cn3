package com.lynx.animax.base;

/* loaded from: classes6.dex */
public enum VisibilityState {
    BACKGROUND(1),
    VISIBLE(2),
    OPACITY(4),
    SIZE(8),
    ATTACH(16),
    AGGREGATED(32);

    private final int value;

    VisibilityState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
