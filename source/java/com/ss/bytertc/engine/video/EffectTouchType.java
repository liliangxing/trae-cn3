package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public enum EffectTouchType {
    TOUCH_BEGAN(0),
    TOUCH_MOVED(1),
    TOUCH_STATIONARY(2),
    TOUCH_ENDED(3),
    TOUCH_CANCELED(4);

    private final int value;

    EffectTouchType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
