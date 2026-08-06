package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;

/* loaded from: classes2.dex */
public class NetworkNotAvailabeException extends TTNetExceptionStorage {
    private static final int INTERNET_DISCONNECTED = -106;
    private static final long serialVersionUID = -7281385706782665299L;

    public int getCronetInternalErrorCode() {
        return -106;
    }

    public NetworkNotAvailabeException() {
    }

    public NetworkNotAvailabeException(String str) {
        super(str);
    }

    public NetworkNotAvailabeException(Throwable th) {
        initCause(th);
    }

    public NetworkNotAvailabeException(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    @Override // com.bytedance.retrofit2.ttnet.TTNetExceptionStorage
    public void setInfo(boolean z, boolean z2, String str, String str2, Object obj) {
        super.setInfo(z, z2, str, str2, obj);
    }
}
