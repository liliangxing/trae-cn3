package com.bytedance.vmsdk.worker;

/* loaded from: classes6.dex */
public class VmSdkException extends Exception {
    private int mCode;
    private String mMessage;

    public VmSdkException(int i, String str) {
        super(str);
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static void throwVmSdkException(int i, String str) throws VmSdkException {
        throw new VmSdkException(i, str);
    }
}
