package com.bytedance.android.monitor.entity;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class FetchError {
    public int errorCode;
    public String errorMessage;
    public int hitPrefetch;
    public int jsbReturn;
    public String method;
    public int requestErrorCode;
    public String requestErrorMsg;
    public int statusCode;
    public String url;

    public String toString() {
        return "FetchError{method='" + this.method + "', url='" + this.url + "', errorMessage='" + this.errorMessage + "', errorCode=" + this.errorCode + ", statusCode=" + this.statusCode + ", requestErrorCode=" + this.requestErrorCode + ", requestErrorMsg='" + this.requestErrorMsg + "', jsbReturn=" + this.jsbReturn + ", hitPrefetch=" + this.hitPrefetch + AbstractJsonLexerKt.END_OBJ;
    }
}
