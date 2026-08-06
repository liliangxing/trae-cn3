package com.bytedance.sync.exc;

import java.io.IOException;

/* loaded from: classes5.dex */
public class SyncIOException extends IOException implements SyncException {
    int errorCode;

    public SyncIOException(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }

    @Override // com.bytedance.sync.exc.SyncException
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // com.bytedance.sync.exc.SyncException
    public String getErrorMsg() {
        return getMessage();
    }
}
