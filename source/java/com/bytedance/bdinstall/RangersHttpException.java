package com.bytedance.bdinstall;

/* loaded from: classes3.dex */
public class RangersHttpException extends Exception {
    private int mResponseCode;

    public RangersHttpException(int i, String str) {
        super(str);
        this.mResponseCode = i;
    }

    public RangersHttpException(int i, Throwable th) {
        super(th);
        this.mResponseCode = i;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
