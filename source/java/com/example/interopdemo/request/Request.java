package com.example.interopdemo.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Request.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001f¨\u0006&"}, d2 = {"Lcom/example/interopdemo/request/Request;", "", "url", "", "method", "headers", "", "Lkotlin/Pair;", "bodyType", "strBody", "bytesBody", "", "requestTimeout", "", "connectTimeout", "readTimeout", "writeTimeout", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;[BIIII)V", "getUrl", "()Ljava/lang/String;", "getMethod", "getHeaders", "()Ljava/util/List;", "getBodyType", "getStrBody", "getBytesBody", "()[B", "getRequestTimeout", "()I", "setRequestTimeout", "(I)V", "getConnectTimeout", "setConnectTimeout", "getReadTimeout", "setReadTimeout", "getWriteTimeout", "setWriteTimeout", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Request {
    private final String bodyType;
    private final byte[] bytesBody;
    private int connectTimeout;
    private final List<Pair<String, String>> headers;
    private final String method;
    private int readTimeout;
    private int requestTimeout;
    private final String strBody;
    private final String url;
    private int writeTimeout;

    public Request(String url, String method, List<Pair<String, String>> headers, String bodyType, String strBody, byte[] bytesBody, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(bodyType, "bodyType");
        Intrinsics.checkNotNullParameter(strBody, "strBody");
        Intrinsics.checkNotNullParameter(bytesBody, "bytesBody");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.bodyType = bodyType;
        this.strBody = strBody;
        this.bytesBody = bytesBody;
        this.requestTimeout = i;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    public /* synthetic */ Request(String str, String str2, List list, String str3, String str4, byte[] bArr, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, str3, str4, bArr, (i5 & 64) != 0 ? -1 : i, (i5 & 128) != 0 ? 15000 : i2, (i5 & 256) != 0 ? 15000 : i3, (i5 & 512) != 0 ? 15000 : i4);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public final List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public final String getBodyType() {
        return this.bodyType;
    }

    public final String getStrBody() {
        return this.strBody;
    }

    public final byte[] getBytesBody() {
        return this.bytesBody;
    }

    public final int getRequestTimeout() {
        return this.requestTimeout;
    }

    public final void setRequestTimeout(int i) {
        this.requestTimeout = i;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public final void setWriteTimeout(int i) {
        this.writeTimeout = i;
    }
}
