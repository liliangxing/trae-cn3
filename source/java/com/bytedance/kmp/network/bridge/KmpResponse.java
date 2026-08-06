package com.bytedance.kmp.network.bridge;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018¨\u0006\""}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpResponse;", "T", "", "()V", "body", "getBody", "()Ljava/lang/Object;", "setBody", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "clientErrorCode", "", "getClientErrorCode", "()I", "setClientErrorCode", "(I)V", "code", "getCode", "setCode", "errMessage", "", "getErrMessage", "()Ljava/lang/String;", "setErrMessage", "(Ljava/lang/String;)V", "headers", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "message", "getMessage", "setMessage", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpResponse<T> {
    private T body;
    private int clientErrorCode;
    private int code;
    private String message = "";
    private String errMessage = "";
    private Map<String, String> headers = MapsKt.emptyMap();

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final int getClientErrorCode() {
        return this.clientErrorCode;
    }

    public final void setClientErrorCode(int i) {
        this.clientErrorCode = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final String getErrMessage() {
        return this.errMessage;
    }

    public final void setErrMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMessage = str;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.headers = map;
    }

    public final T getBody() {
        return this.body;
    }

    public final void setBody(T t) {
        this.body = t;
    }
}
