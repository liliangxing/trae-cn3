package com.example.interopdemo.websocket;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeRawWsInfo.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/example/interopdemo/websocket/NativeRawWsInfo;", "", "url", "", "queries", "", "headers", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getUrl", "()Ljava/lang/String;", "getQueries", "()Ljava/util/Map;", "getHeaders", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeRawWsInfo {
    private final Map<String, String> headers;
    private final Map<String, String> queries;
    private final String url;

    public NativeRawWsInfo(String url, Map<String, String> queries, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(queries, "queries");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.queries = queries;
        this.headers = headers;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Map<String, String> getQueries() {
        return this.queries;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }
}
