package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

/* loaded from: classes5.dex */
public class OpenException extends Exception {
    private int errCode;
    private String errMsg;

    public OpenException(int i, String str) {
        this.errCode = i;
        this.errMsg = str;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
