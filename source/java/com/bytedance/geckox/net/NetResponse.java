package com.bytedance.geckox.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TTNetImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/net/NetResponse;", "", "code", "", "message", "", "res", "Lcom/bytedance/retrofit2/client/Response;", "(ILjava/lang/String;Lcom/bytedance/retrofit2/client/Response;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getRes", "()Lcom/bytedance/retrofit2/client/Response;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class NetResponse {
    private final int code;
    private final String message;
    private final com.bytedance.retrofit2.client.Response res;

    public NetResponse(int i, String str, com.bytedance.retrofit2.client.Response response) {
        this.code = i;
        this.message = str;
        this.res = response;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NetResponse(int i, String str, com.bytedance.retrofit2.client.Response response, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, response);
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            response = null;
        }
    }

    public final String getMessage() {
        return this.message;
    }

    public final com.bytedance.retrofit2.client.Response getRes() {
        return this.res;
    }
}
