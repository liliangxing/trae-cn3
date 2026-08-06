package com.ss.android.common;

/* loaded from: classes7.dex */
public class NetworkResponseInfo {
    private String mResult = "";
    private int mResultCode = -1;

    public void setResult(String str) {
        this.mResult = str;
    }

    public void setResultCode(int i) {
        this.mResultCode = i;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getResultCode() {
        return this.mResultCode;
    }
}
