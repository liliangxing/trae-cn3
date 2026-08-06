package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public enum EffectTouchGesture {
    GESTURE_TAP(0),
    GESTURE_SWIPE(1),
    GESTURE_PINCH(2),
    GESTURE_LONG_TAP(3),
    GESTURE_DRAG(4),
    GESTURE_DROP(5),
    GESTURE_DOUBLE_CLICK(6),
    ANY_SUPPORTED(-1);

    private final int value;

    EffectTouchGesture(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
