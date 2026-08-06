package com.lynx.animax.base;

/* loaded from: classes6.dex */
public class Status {
    public final String mErrMsg;
    public final boolean mSuccess;

    public Status(boolean z) {
        this.mSuccess = z;
        this.mErrMsg = z ? null : "unknown error";
    }

    public Status(String str) {
        this.mSuccess = str == null;
        this.mErrMsg = str;
    }
}
