package com.lynx.tasm.gesture.common;

/* loaded from: classes7.dex */
public class GestureExtraBundle {
    private int gestureDirection = 0;
    private float simultaneousDeltaX = 0.0f;
    private float simultaneousDeltaY = 0.0f;
    private boolean isNeedConsumedSimultaneousGesture = false;

    public int getGestureDirection() {
        return this.gestureDirection;
    }

    public void setGestureDirection(int i) {
        this.gestureDirection = i;
    }

    public float getSimultaneousDeltaX() {
        return this.simultaneousDeltaX;
    }

    public void setSimultaneousDeltaX(float f) {
        this.simultaneousDeltaX = f;
    }

    public float getSimultaneousDeltaY() {
        return this.simultaneousDeltaY;
    }

    public void setSimultaneousDeltaY(float f) {
        this.simultaneousDeltaY = f;
    }

    public void resetSimultaneousDelta() {
        this.simultaneousDeltaX = 0.0f;
        this.simultaneousDeltaY = 0.0f;
        this.isNeedConsumedSimultaneousGesture = false;
    }

    public boolean isNeedConsumedSimultaneousGesture() {
        return this.isNeedConsumedSimultaneousGesture;
    }

    public void setNeedConsumedSimultaneousGesture(boolean z) {
        this.isNeedConsumedSimultaneousGesture = z;
    }
}
