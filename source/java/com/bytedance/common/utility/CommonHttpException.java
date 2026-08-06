package com.bytedance.common.utility;

/* loaded from: classes3.dex */
public class CommonHttpException extends Exception {
    private int mResponseCode;

    public CommonHttpException(int i, String str) {
        super(str);
        this.mResponseCode = i;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
