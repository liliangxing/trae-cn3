package com.lynx.tasm.gesture;

import com.lynx.react.bridge.ReadableMap;

/* loaded from: classes7.dex */
public interface LynxNewGestureDelegate {
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_END = 3;
    public static final int STATE_FAIL = 2;

    void consumeGesture(int i, ReadableMap readableMap);

    float[] scrollBy(float f, float f2);

    void setGestureDetectorState(int i, int i2);
}
