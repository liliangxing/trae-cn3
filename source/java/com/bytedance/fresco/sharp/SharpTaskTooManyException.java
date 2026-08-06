package com.bytedance.fresco.sharp;

/* loaded from: classes2.dex */
public class SharpTaskTooManyException extends Exception {
    public static final int SHARP_TASK_TOO_MANY = -200000;
    private int mCode;

    public SharpTaskTooManyException() {
        this.mCode = -1;
    }

    public SharpTaskTooManyException(String str) {
        super(str);
        this.mCode = -1;
    }

    public SharpTaskTooManyException(int i, String str) {
        super(str);
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }
}
