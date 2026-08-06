package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;

/* loaded from: classes2.dex */
public class ClientProtocolException extends TTNetExceptionStorage {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String str) {
        super(str);
    }

    public ClientProtocolException(Throwable th) {
        initCause(th);
    }

    public ClientProtocolException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
