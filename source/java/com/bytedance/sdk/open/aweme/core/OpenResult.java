package com.bytedance.sdk.open.aweme.core;

/* loaded from: classes5.dex */
public class OpenResult<T> {
    private T data;
    private int errCode;
    private String msg;

    public OpenResult(int i, String str) {
        this.errCode = i;
        this.msg = str;
    }

    public OpenResult(int i, String str, T t) {
        this.errCode = i;
        this.msg = str;
        this.data = t;
    }

    public T getData() {
        return this.data;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return this.errCode == 0;
    }
}
