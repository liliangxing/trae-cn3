package com.bytedance.sync.exc;

/* loaded from: classes5.dex */
public class SyncApiException extends Exception implements SyncException {
    private int errorCode;

    public SyncApiException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    @Override // com.bytedance.sync.exc.SyncException
    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    @Override // com.bytedance.sync.exc.SyncException
    public String getErrorMsg() {
        return getMessage();
    }
}
