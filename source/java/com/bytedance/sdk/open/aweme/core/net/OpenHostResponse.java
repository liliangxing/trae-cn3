package com.bytedance.sdk.open.aweme.core.net;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class OpenHostResponse {
    public OpenResponseBody body;
    public int code;
    public OpenNetHeaders headers;
    public String message;
    public Throwable throwable;
    public String url;

    public OpenHostResponse(int i, String str, String str2, OpenNetHeaders openNetHeaders, OpenResponseBody openResponseBody, Throwable th) {
        this.code = i;
        this.message = str;
        this.url = str2;
        this.headers = openNetHeaders;
        this.body = openResponseBody;
        this.throwable = th;
    }

    public boolean isSuccessful() {
        int i = this.code;
        return i <= 299 && i >= 200;
    }

    public String toString() {
        return "OpenHostResponse{code=" + this.code + ", message='" + this.message + "', url='" + this.url + "', headers=" + this.headers + ", body=" + this.body + ", throwable=" + this.throwable + AbstractJsonLexerKt.END_OBJ;
    }
}
