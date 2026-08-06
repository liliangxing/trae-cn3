package com.example.kmp.shared.sha;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTWsClientBridge.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/example/kmp/shared/sha/WsBridgeInfo;", "", "queries", "", "", "headers", "url", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "getQueries", "()Ljava/util/Map;", "getHeaders", "getUrl", "()Ljava/lang/String;", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WsBridgeInfo {
    private final Map<String, String> headers;
    private final Map<String, String> queries;
    private final String url;

    public WsBridgeInfo(Map<String, String> queries, Map<String, String> headers, String url) {
        Intrinsics.checkNotNullParameter(queries, "queries");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(url, "url");
        this.queries = queries;
        this.headers = headers;
        this.url = url;
    }

    public final Map<String, String> getQueries() {
        return this.queries;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getUrl() {
        return this.url;
    }
}
