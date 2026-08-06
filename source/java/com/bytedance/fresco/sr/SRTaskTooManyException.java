package com.bytedance.fresco.sr;

/* loaded from: classes2.dex */
public class SRTaskTooManyException extends Exception {
    public static final int SR_TASK_TOO_MANY = -200000;
    private int mCode;

    public SRTaskTooManyException() {
        this.mCode = -1;
    }

    public SRTaskTooManyException(String str) {
        super(str);
        this.mCode = -1;
    }

    public SRTaskTooManyException(int i, String str) {
        super(str);
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }
}
